package controlers;
import models.connectionsql;
import models.patient;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;


public class patientcontrol implements Initializable {

    Connection cnp;
    PreparedStatement ptp;
    ResultSet resp;
   

    @FXML
    private Button add_btn;

    @FXML
    private Button delet_btn;

    @FXML
    private TextField fi_name;

    @FXML
    private TableColumn<patient, String> fname_col;

    @FXML
    private Button go_btn;

    @FXML
    private TableColumn<patient, Integer> idcell;

    @FXML
    private TextField last_nm;

    @FXML
    private TableColumn<patient, String> lname_col;

    @FXML
    private TableColumn<patient, Date> lsp;

    @FXML
    private Button refresh;

    @FXML
    private TableView<patient> pattable;

    @FXML
    private TextField phone;

    @FXML
    private TableColumn<patient, String> phone_col;

    @FXML
    private TextField search;

    @FXML
    private Label warninglab;

    public ObservableList<patient> data = FXCollections.observableArrayList();
    
    String sql = "select * FROM patient";

  //general fun to get patient model
    public ObservableList<patient> getpatien(String sql) throws SQLException {

        
        ptp = cnp.prepareStatement(sql);
        resp = ptp.executeQuery();

        while(resp.next()){
        
        data.add(new patient(resp.getInt("IDp"), resp.getString("name"), resp.getString("firstn"),resp.getString("tel"),resp.getDate("date")));

           
        }
    
        
        return data;


    }
   //creating the list to upload the table
    private ObservableList<patient> addpatientlist;
    public void showpat(String sql) throws SQLException{

        addpatientlist = getpatien(sql);


        //adding into each cell the extracted element into the fxml columns
        idcell.setCellValueFactory(new PropertyValueFactory<patient, Integer>("id"));
        fname_col.setCellValueFactory(new PropertyValueFactory<patient, String>("name"));
        lname_col.setCellValueFactory(new PropertyValueFactory<patient, String>("prename"));
        phone_col.setCellValueFactory(new PropertyValueFactory<patient, String>("phone"));
        lsp.setCellValueFactory(new PropertyValueFactory<patient, Date>("date"));

        //add all elements into the fxml table
        pattable.setItems(data);


    }


    //adding patient
    @FXML
    void addpatient(MouseEvent event) throws SQLException {

        String name = fi_name.getText();
        String lsname = last_nm.getText();
        String phonen = phone.getText();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        
        //error control in case the cells are empty

        if(name =="" || lsname == "" || phonen == ""){
                warninglab.setText("please fill all the fields");
        }

        else{ 
            warninglab.setText("");

            //sql request for insert
            String sql2 = "INSERT into patient (name, firstn, date, tel)values(?,?,?,?)";
            ptp = cnp.prepareStatement(sql2);
            
        try {

        // implement the element added from the textfields to the database
        ptp.setString(1, name);
        ptp.setString(2, lsname); 
        ptp.setString(3, String.valueOf(formatter.format(now)));
        ptp.setString(4, phonen);

        //debug 
        System.out.println(formatter.format(now));


        // execute the previous operations 
        int n = ptp.executeUpdate();
        System.out.println(n);
     
       
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }   }
        
       
    }

    @FXML
    void deletepatient(MouseEvent event) throws SQLException {
        Integer i =Integer.parseInt(search.getText());


        //sql request to delete element recognized by his id
        String sql = "DELETE FROM patient WHERE IDp = '"+i+"' ";

        //execute the operation !! dont forget this op!!
        ptp = cnp.prepareStatement(sql);
       
        warninglab.setText("");
       try{ 

        //execute the operation 
        int n = ptp.executeUpdate();
        System.out.println(n);
        
        
        //clear the table after deleting to show success of the operation 
        pattable.getItems().clear();
        showpat(sql);
    }
        catch (Exception e) {
            System.out.println("error cant delete");
            e.printStackTrace();
        } 
    }

    @FXML
    void refresh(MouseEvent event) throws SQLException {
        warninglab.setText("");
        pattable.getItems().clear();
        showpat("select * FROM patient");
      
    }

    @FXML
    void search(MouseEvent event) {
        warninglab.setText("");

        //sql search operation 
        String sqll = "select IDp,name, firstn,date, tel  FROM patient WHERE IDp = '"+search.getText()+"' or firstn= '"+search.getText()+"' ";

     

        try {

            //simple display of the result 
            pattable.getItems().clear();
            ptp = cnp.prepareStatement(sqll);
            resp = ptp.executeQuery();
            showpat(sqll);
           

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error in search");
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cnp = connectionsql.connectionbd();
        try {

            //showing the table while openning the interface 
            showpat(sql);
        } catch (Exception e) {
            // TODO: handle exception
        }
   
    }}

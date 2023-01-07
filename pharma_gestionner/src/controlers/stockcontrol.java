package controlers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.connectionsql;
import models.med;

public class stockcontrol implements Initializable {

    Connection cnp;
    PreparedStatement ptp;
    ResultSet resp;


    @FXML
    private TableColumn<med, Integer> gram_col;

    @FXML
    private Button add_btn;

    @FXML
    private TableColumn<med, String> cat_col;

    @FXML
    private TextField catego_tex;

    @FXML
    private Button delet_btn;

    @FXML
    private Button gobtn;

    @FXML
    private TableColumn<med, Integer> id_col;

    @FXML
    private TextField med_gram;

    @FXML
    private Button modify_btn;

    @FXML
    private TableColumn<med, String> name_col;

    @FXML
    private TextField name_tex;

    @FXML
    private TableColumn<med, Integer> price_col;

    @FXML
    private TextField price_tex;

    @FXML
    private TableColumn<med, Integer> qte_col;

    @FXML
    private TextField qte_tex;

    @FXML
    private TextField search_box;

    @FXML
    private TableView<med> tab;
    @FXML
    private Label warninglan;

    public ObservableList<med> data = FXCollections.observableArrayList();
    
    String sql = "select * FROM stock";

    //*************************methods********************************************** */

    public ObservableList<med> getmed(String sql) throws SQLException {

        
        ptp = cnp.prepareStatement(sql);
        resp = ptp.executeQuery();

        while(resp.next()){
        
        data.add(new med(resp.getInt("ID_med"), resp.getString("name"), resp.getInt("grammage"),resp.getInt("qte"),resp.getString("categorie"),resp.getInt("price")));

           
        }
    
        
        return data;


    }

     //creating the list to upload the table
     private ObservableList<med> addmedlist;
     public void showmed(String sql) throws SQLException{
 
         addmedlist = getmed(sql);
 
 
         //adding into each cell the extracted element into the fxml columns
         id_col.setCellValueFactory(new PropertyValueFactory<med, Integer>("id"));
         name_col.setCellValueFactory(new PropertyValueFactory<med, String>("name"));
         gram_col.setCellValueFactory(new PropertyValueFactory<med, Integer>("gram"));
         cat_col.setCellValueFactory(new PropertyValueFactory<med, String>("ctg"));
         qte_col.setCellValueFactory(new PropertyValueFactory<med, Integer>("qte"));
         price_col.setCellValueFactory(new PropertyValueFactory<med, Integer>("price"));
 
         //add all elements into the fxml table
         tab.setItems(data);
 
 
     }

    @FXML
    void addmed(MouseEvent event) throws SQLException {
        String name = name_tex.getText();
        String gram = med_gram.getText();
        String qte = qte_tex.getText();
        String cat = catego_tex.getText();
        String price = price_tex.getText();
      
        
        
        //error control in case the cells are empty

        if(name =="" || gram == "" || qte == "" || cat == "" || price == ""){
            warninglan.setText("please fill all the fields");
        }

        else{ 
            warninglan.setText("");

            //sql request for insert
            String sql2 = "INSERT into stock (name, grammage, qte, categorie, price)values(?,?,?,?,?)";
            ptp = cnp.prepareStatement(sql2);
            
        try {

            int grammage = Integer.parseInt(gram);
            int qtee = Integer.parseInt(qte);
            int pricee = Integer.parseInt(price);

        // implement the element added from the textfields to the database
        ptp.setString(1, name);
        ptp.setInt(2, grammage); 
        ptp.setInt(3, qtee);
        ptp.setString(4, cat);
        ptp.setInt(5, pricee);

        //debug 
        System.out.println("works,!");


        // execute the previous operations 
        int n = ptp.executeUpdate();
        System.out.println(n);
     
       
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        } 
    }
    }

    @FXML
    void deletemed(MouseEvent event) {

    }

    @FXML
    void modifymed(MouseEvent event) {

    }

    @FXML
    void search(MouseEvent event) {
        int i = Integer.parseInt(search_box.getText());
        String sqll = "select *  FROM stock WHERE ID_med = '"+i+"' ";

     

        try {

            //simple display of the result 
            tab.getItems().clear();
            ptp = cnp.prepareStatement(sqll);
            resp = ptp.executeQuery();

            while(resp.next()){ 
            System.out.println(resp.getInt("ID_med"));

            }
            showmed(sqll);
           

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error in search");
        }

    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cnp = connectionsql.connectionbd();

        try {
            showmed(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
    


}

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.connectionsql;
import models.user;

public class admincontrol implements Initializable {
    Connection cnp;
    PreparedStatement ptp;
    ResultSet resp;

    @FXML
    private TableView<user> empl_tab;

    @FXML
    private TableColumn<user, Integer> id_col;

    @FXML
    private TableColumn<user, String> lname_col;

    @FXML
    private TableColumn<user, String> name_col;

    @FXML
    private Button add_btn;

    @FXML
    private Button pt_btn;

    @FXML
    private Button sell_btn;

    @FXML
    private Button stk_btn;

    @FXML
    private Button out_btn;

    @FXML
    private AnchorPane winP;

    private Parent fxml;




  
    // *************************************add user panel****************************************************** 
    
    @FXML
    public void adduser() {
        System.out.println("open dash board");
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/add_user.fxml"));
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }

    }

    //*********************************************  log out methode************************************************
    @FXML
    public void logout() {
        System.out.println("open dash board");
            winP.getScene().getWindow().hide();
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }

    }

    


    //**************** display patient panel******************************************************
    @FXML
    public void openpatient() {

        System.out.println("open dash board");
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/patient_dashb.fxml"));
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }

    }

    


    //********************display sells panel ***********************************
    @FXML
    public void opensells() {
        System.out.println("open dash board");
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/sells.fxml"));
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }

    }

    


    // ******************************************stock display panel**********************************************
    @FXML
    public void openstock() {
        System.out.println("open dash board");
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/stock_dash.fxml"));
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }




        }



    // ************************************* table of employee in home********************************************

        public ObservableList<user> data = FXCollections.observableArrayList();
    
        String sql = "select * FROM vendeur";
        public ObservableList<user> getuser() throws SQLException {
    
            
            ptp = cnp.prepareStatement(sql);
            resp = ptp.executeQuery();
    
            while(resp.next()){
            
            data.add(new user(resp.getInt("id_v"), resp.getString("name"), resp.getString("lastname")));
    
               
            }
        
            
            return data;
    
    
        }

         //creating the list to upload the table
      private ObservableList<user> userlist;
      public void showuser() throws SQLException{
  
          userlist = getuser();
  
  
          //adding into each cell the extracted element into the fxml columns
          id_col.setCellValueFactory(new PropertyValueFactory<user, Integer>("idu"));
          name_col.setCellValueFactory(new PropertyValueFactory<user, String>("name"));
          lname_col.setCellValueFactory(new PropertyValueFactory<user, String>("lname"));
       
          //add all elements into the fxml table
          empl_tab.setItems(data);
  
  
      }
        


    //******************************** end of table employee ***********************************************************
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        cnp = connectionsql.connectionbd();
        try {
            showuser();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}

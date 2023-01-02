// ***************************** PLEASE DO NOT MODIFY THIS FILE ******************************************************
//********************************************************************************************************************

package controlers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class admincontrol implements Initializable {

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


    // add user panel 
    
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

    // log out methode
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

    


    // patient panel
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

    


    // sells panel
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

    


    // stock panel
    @FXML
    public void openstock() {
        System.out.println("open dash board");
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/medic_dashb.fxml"));
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }

        }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
}


package controlers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class logincontrol implements Initializable {
 
    @FXML
    private Button btn_log;

    @FXML
    private PasswordField pw_field;

    @FXML
    private TextField tex;
    @FXML
    private VBox vbox;

    @FXML
    private Label lab;

    private Parent fxml;

    //log in to dashboard 

    public void opendashboard() {
       String name = tex.getText();
       String pwd = pw_field.getText();


      //admin log 
       if(name.equals("admin") && pwd.equals("admin")){

        System.out.println("open dash board");
        vbox.getScene().getWindow().hide();

       Stage dash_board = new Stage();
        try{
          
         fxml = FXMLLoader.load(getClass().getResource("/sample/dashboard_admin.fxml"));
         Scene scene = new Scene(fxml);
         dash_board.setScene(scene);
         dash_board.show();

     }catch(Exception e){
         e.printStackTrace();
     }


       }else{
         if(name.equals("a") && pwd.equals("b")){

            System.out.println("open dash board");
            vbox.getScene().getWindow().hide();
    
           Stage dash_board = new Stage();
            try{
              
             fxml = FXMLLoader.load(getClass().getResource("/sample/dashboard.fxml"));
           
             Scene scene = new Scene(fxml);
             dash_board.setScene(scene);
             dash_board.show();
    
         }catch(Exception e){
             e.printStackTrace();
         }}
         else
            System.out.println("erreur");

       }
        
    }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      // TODO Auto-generated method stub
      
   }


   
  
    
    }



    

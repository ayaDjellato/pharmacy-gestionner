package controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class logincontrol implements Initializable{
 
    @FXML
    private Button btn_log;

    @FXML
    private PasswordField pw_field;

    @FXML
    private TextField tex;

    void openDashboard() {
       String name = tex.getText();
       String pwd = pw_field.getText();
       if(name.equals("abc") && pwd.equals("aa")){
        System.out.println("open dash board");

       }else{
        System.out.println("erreur");

       }
        
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
    }
  
    
    }




    




    

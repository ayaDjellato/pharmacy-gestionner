
package controlers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import models.connectionsql;


public class logincontrol implements Initializable {
    Connection cn;
    public PreparedStatement pt;
    public ResultSet res;
 
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

    public void opendashboard() throws SQLException, IOException {
    String name = tex.getText();
    String pwd = pw_field.getText();
      
       String sql = "select * from adminlog WHERE name = ? and password = ?";
       String sql2 = "select * from vendeur WHERE name = ? and password = ?";
       cn = connectionsql.connectionbd();

            pt = cn.prepareStatement(sql);
            pt.setString(1, name);
            pt.setString(2, pwd);
            res = pt.executeQuery();

                //admin log 
                if(res.next()){

                    System.out.println("open dash board");
                    vbox.getScene().getWindow().hide();

                    Stage dash_board = new Stage();
                    
                    
                    fxml = FXMLLoader.load(getClass().getResource("/sample/dashboard_admin.fxml"));
                    Scene scene = new Scene(fxml);
                    dash_board.setScene(scene);
                    dash_board.show();

                   }
                    else{
                        pt = cn.prepareStatement(sql2);
                        pt.setString(1, name);
                        pt.setString(2, pwd);
                        res = pt.executeQuery();
                            if(res.next()){

                                System.out.println("open dash board");
                                vbox.getScene().getWindow().hide();
            
                                Stage dash_board = new Stage();
                                
                                
                                fxml = FXMLLoader.load(getClass().getResource("/sample/dashboard.fxml"));
                                Scene scene = new Scene(fxml);
                                dash_board.setScene(scene);
                                dash_board.show();
            

                            }}
       

    
    }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
     
    cn = connectionsql.connectionbd();

   
      
   }


   
  
    
    }




    




    

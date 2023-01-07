package controlers;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.connectionsql;


public class addusercontrol implements Initializable{

    Connection cnp;
    PreparedStatement ptp;
    ResultSet resp;


    @FXML
    private Label errorlab;


    @FXML
    private Button btnRegister;

    @FXML
    private TextField firstn;

    @FXML
    private TextField lastn;

    @FXML
    private TextField pwd;

    @FXML
    void btnRegisterClick(MouseEvent event) {
        String username = lastn.getText();
        String password = pwd.getText();
        String firstname = firstn.getText();
        
        if(username =="" || password =="" || firstname == ""){
            errorlab.setText("please fill all the fiels ");

        }else{ 
            errorlab.setText("");
            try {
                    //sql request for insert
                    String query = "INSERT into vendeur (name, lastname, password)values(?,?,?)";
                    ptp = cnp.prepareStatement(query);
             
                    ptp.setString(1, username);
                    ptp.setString(2, firstname);
                    ptp.setString(3, password);
                
                    int n = ptp.executeUpdate();
                    System.out.println(n);

               
            } catch (SQLException var6) {
                var6.printStackTrace();
            }}



           
        }

        

    


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cnp = connectionsql.connectionbd();
      

    }

}

package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class sellscontrol implements Initializable{
 
    @FXML
    private Button add_btn;

    @FXML
    private CheckBox check_btn;

    @FXML
    private Button delet_btn;

    @FXML
    private Button go_btn;

    @FXML
    private TextField id;

    @FXML
    private TextField id_box;

    @FXML
    private TextField last_n;

    @FXML
    private TextField name;

    @FXML
    private TextField name_me;


    //elem list 
    @FXML
    private Pane pan;

    @FXML
    private Button print_btn;

    @FXML
    private Spinner<?> qte_spin;



    // add an elem to the bill
    @FXML
    void add(ActionEvent event) {

    }

    //delete element from the bill
    @FXML
    void deleteelem(ActionEvent event) {

    }


    // print the bill
    @FXML
    void printfun(ActionEvent event) {

    }


    //search in the database


    @FXML
    void search(ActionEvent event) {

    }

    //spinner function 
    @FXML
    void spinfun(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}

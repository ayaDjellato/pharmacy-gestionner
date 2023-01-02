// ***************************** PLEASE DO NOT MODIFY THIS FILE ******************************************************
//********************************************************************************************************************


package controlers;
import models.connectionsql;
import models.patient;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;


public class patientcontrol implements Initializable {

    Connection cn;
    public PreparedStatement pt;
    public ResultSet res;
   

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
    private TableColumn<patient, Integer> Id;

    @FXML
    private TextField last_nm;

    @FXML
    private TableColumn<patient, String> lname_col;

    @FXML
    private TableColumn<patient, String> lsp;

    @FXML
    private Button modify_btn;

    @FXML
    private TableView<patient> pat_table;

    @FXML
    private TextField phone;

    @FXML
    private TableColumn<patient, String> phone_col;

    @FXML
    private TextField search;

    public ObservableList<patient> data = FXCollections.observableArrayList();

    public void showpatien() throws SQLException{

        String sql = "select * from patient";
        pt = cn.prepareStatement(sql);

        res = pt.executeQuery();
        while(res.next()){
            data.add(new patient(res.getInt("ID_pat"), res.getString("nom"), res.getString("prenom"),res.getString("num_tel"), res.getDate("date_vente")));
        }
        Id.setCellValueFactory(new PropertyValueFactory<patient, Integer>("id"));
        fname_col.setCellValueFactory(new PropertyValueFactory<patient, String>("fname"));
        lname_col.setCellValueFactory(new PropertyValueFactory<patient, String>("lname"));
        phone_col.setCellValueFactory(new PropertyValueFactory<patient, String>("phone"));
        pat_table.setItems(data);


    }

    @FXML
    void addpatient(MouseEvent event) {

    }

    @FXML
    void deletepatient(MouseEvent event) {

    }

    @FXML
    void modifypat(MouseEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cn = connectionsql.connectionbd();

        try {
            showpatien();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}

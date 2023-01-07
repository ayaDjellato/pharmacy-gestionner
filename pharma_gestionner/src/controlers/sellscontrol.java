package controlers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.mysql.cj.conf.PropertyDefinitions.DatabaseTerm;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.bill;
import models.connectionsql;
import models.med;
import models.vendor;
import models.vente;


public class sellscontrol implements Initializable{

    Connection cnp;
    PreparedStatement ptp;
    ResultSet resp;

    PreparedStatement ptp2;
    ResultSet resp2;

    @FXML
    private Label errorlab;
    
    @FXML
    private Button display;

 
    @FXML
    private Button add_btn;

    @FXML
    private TableView<med> bill_tab;

    @FXML
    private Button delet_btn;

    @FXML
    private Button go_btn;

    @FXML
    private TableColumn<med, Integer> gram_col;

    @FXML
    private TextField id_med;

    @FXML
    private TextField last_n;

    @FXML
    private TableColumn<med, String> med_col;

    @FXML
    private TextField name_tex;

    
    @FXML
    private Pane pan;

    @FXML
    private TableColumn<bill, Integer> price_col;

    @FXML
    private Button print_btn;

    @FXML
    private TableColumn<bill, Integer> qte_col;

    @FXML
    private TextField qte_tex;

    @FXML
    private TextField search_box;

    @FXML
    private TableView<bill> qte_tab;
    @FXML
    private TableColumn<med, Integer> unitprice;


    public ObservableList<med> data = FXCollections.observableArrayList();
    public ObservableList<vente> data2 = FXCollections.observableArrayList();
    public ObservableList<bill> datab = FXCollections.observableArrayList();
   
    
    String sql1 = "select * FROM vente";
    String sql2 = "select * FROM stock";
    String sql3 = "select * FROM recu_vente";

    public ObservableList<vente> getvente(String sql1) throws SQLException {

        
        ptp = cnp.prepareStatement(sql1);
        resp = ptp.executeQuery();

        while(resp.next()){
        
        data2.add(new vente(resp.getInt("Id_vente"), resp.getInt("ID_med"), resp.getInt("id_v"),resp.getInt("ID_pat"),resp.getInt("qte_vendu"), resp.getDate("date_vente"), resp.getInt("prix")));

           
        }
    
        return data2;


    }


    public ObservableList<med> getsellmed(String sql2) throws SQLException {

        
        ptp = cnp.prepareStatement(sql2);
        resp = ptp.executeQuery();

        while(resp.next()){
        
        data.add(new med(resp.getInt("ID_med"), resp.getString("name"), resp.getInt("grammage"),resp.getInt("qte"),resp.getString("categorie"),resp.getInt("price")));

           
        }
    
        
        return data;


    }


 
                


        private ObservableList<med> addmeddlist;
        
        String query = "select * FROM stock JOIN recu_vente on stock.ID_med = recu_vente.id_med ";
        public void showarticle() throws SQLException{

           


                addmeddlist = getsellmed(query);
                

                System.out.println(addmeddlist);
             
                

                //adding into each cell the extracted element into the fxml columns
                med_col.setCellValueFactory(new PropertyValueFactory<med, String>("name"));
                gram_col.setCellValueFactory(new PropertyValueFactory<med, Integer>("gram"));
                unitprice.setCellValueFactory(new PropertyValueFactory<med, Integer>("price"));
                
                
                //add all elements into the fxml table
                bill_tab.setItems(data);


    }

    private ObservableList<bill> addventeqte;
        String queryb = "select * FROM recu_vente ";
        public void showsqte() throws SQLException{

                addventeqte = getbill(queryb);

                price_col.setCellValueFactory(new PropertyValueFactory<bill, Integer>("prix"));
                qte_col.setCellValueFactory(new PropertyValueFactory<bill, Integer>("qte"));
                qte_tab.setItems(datab);

        }

    
    
    @FXML
    void addelem(MouseEvent event) throws SQLException { 

        int idm = Integer.parseInt(id_med.getText());
        Integer qte = Integer.parseInt(qte_tex.getText());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String query = "INSERT into recu_vente (id_med,quantity,date,priceb)values(?,?,?,?)";
              ptp = cnp.prepareStatement(query);  
                
        try{
            
            ptp.setInt(1, idm);
            ptp.setInt(2, qte);
            ptp.setString(3, String.valueOf(formatter.format(now)));


         
            query = "select price FROM stock WHERE ID_med = '"+idm+"'";
                ptp2 = cnp.prepareStatement(query);
                resp = ptp2.executeQuery();
                
                while(resp.next()){
                ptp.setInt(4, resp.getInt("price"));
                }  


                System.out.println(ptp);
                int n = ptp.executeUpdate();
                System.out.println(n);

                qte_tab.getItems().clear();
                bill_tab.getItems().clear();
                showarticle();
                showsqte();
      
        }catch(Exception e){
            System.out.println("error in bill");
        }

       
            
    }

    private ObservableList<bill> billlist;

    public ObservableList<bill> getbill(String sql3) throws SQLException {

        
        ptp = cnp.prepareStatement(sql3);
        resp = ptp.executeQuery();

        while(resp.next()){
        
        datab.add(new bill(resp.getInt("id_recu"), resp.getInt("id_med"),resp.getInt("quantity"),resp.getDate("date"),resp.getInt("priceb")));

           
        }
    
        
        return datab;


    }

    @FXML
    void deletm(MouseEvent event) throws SQLException {

        Integer  i =Integer.parseInt(search_box.getText());


        //sql request to delete element recognized by his id
        String sql = "DELETE FROM recu_vente WHERE id_recu ='"+i+"'  ";

        //execute the operation !! dont forget this op!!
        ptp = cnp.prepareStatement(sql);
       
       
       try{ 

        //execute the operation 
        int n = ptp.executeUpdate();
        System.out.println(n);
        qte_tab.getItems().clear();
        
        
        //clear the table after deleting to show success of the operation 
        bill_tab.getItems().clear();
        showarticle();
        showsqte();
        
        
        
        
    }
        catch (Exception e) {
            System.out.println("error cant delete");
            e.printStackTrace();
        } 
    }


    

    @FXML
    void display(ActionEvent event) {
        System.out.println("open dash board");
    
        Stage dash_board = new Stage();
         try{
           
        
          Scene scene = new Scene( FXMLLoader.load(getClass().getResource("/sample/mandash.fxml")));
          dash_board.setScene(scene);
          dash_board.show();
 
      }catch(Exception e){
          e.printStackTrace();
      }
    }



    @FXML
    void search(MouseEvent event) {
        int i = Integer.parseInt(search_box.getText());
        String sqll = "select ID_med  FROM vente WHERE Id_vente = '"+i+"' ";

     

        try {

            //simple display of the result 
           
            ptp = cnp.prepareStatement(sqll);
            resp = ptp.executeQuery();

            while(resp.next()){ 
            System.out.println(resp.getInt("ID_med"));

            }
            qte_tab.getItems().clear();
            bill_tab.getItems().clear();
            showarticle();
            showsqte();
           

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error in search");
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cnp = connectionsql.connectionbd();
        try {
            showarticle();
            showsqte();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

}

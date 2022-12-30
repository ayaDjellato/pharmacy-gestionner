

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mainprint extends Application {

    @Override
    public void start(Stage primstage) throws IOException {
     
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
            Scene scene = new Scene(root);
            primstage.setScene(scene);
            primstage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


        public static void main(String[] args){
       
            launch(args);
        }

    }


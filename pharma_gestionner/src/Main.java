

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primstage) throws Exception {
     
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/sample/sells.fxml"));
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
    


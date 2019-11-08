package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{

        GUIPassword gui = new GUIPassword(primaryStage);/*
        Parent root = FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.getIcons().add(new Image("/Images/lock.png"));
        primaryStage.setScene(new Scene(root, 480, 390));
        primaryStage.setResizable(false);
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
/*
   public static void main(String[] args){
        launch(args);*/
     /*   Controller controller = new Controller();
        controller.generatePassword();*/
   // }

/*
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.generatePassword();

    }

 */
}

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main/* extends Application */{
/*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        controller.start(primaryStage);
    }
*/

    public static void main(String[] args) {
       // launch(args);
        Controller controler = new Controller();
        controler.generatePassword();

    }
}

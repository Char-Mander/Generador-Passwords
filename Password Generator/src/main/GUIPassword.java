package main;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class GUIPassword extends Application {
    Controller controller;

    public GUIPassword(Stage stage){
        controller = new Controller();
        try {
            start(stage);
            //GUIGeneratePassword("", "", );
            //mostrarPassword(stage);
           // String name = getNombrePassword();
           // controller = new Controller();
        }
        catch(Exception e){
            System.out.println("Exception");
        }
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.getIcons().add(new Image("/Images/lock.png"));
        Scene scene = new Scene(root, 480, 390);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        Button button = (Button) scene.lookup("#generatePass");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    TextField directory, file, name;
                    directory = (TextField) scene.lookup("#directory");
                    file = (TextField) scene.lookup("#fileName");
                    name = (TextField) scene.lookup("#passwordName");
                    String password = controller.generateAndSavePassword(directory.getText(), file.getText(), name.getText());
                    mostrarPassword(primaryStage, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //Click on generate pass
    public void GUIGeneratePassword(String directory, String fileName, String passwordName){
        controller.generateAndSavePassword(null, null, passwordName);
    }

    private void mostrarPassword(Stage primaryStage, String password) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EndWindow.fxml"));
        Scene scene = new Scene(root, 480, 390);
        primaryStage.setScene(scene);
        Label pass = (Label) scene.lookup("#password");
        pass.setText(password);
        Button button = (Button) scene.lookup("#loadVentanaInicio");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                   start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

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
import javax.xml.soap.Text;
import java.io.IOException;
import java.util.Scanner;

public class GUIPassword extends Application {
    Controller controller;
    ScreenController screenController;

    public GUIPassword(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
        Scene scene = new Scene(root, 480, 390);
        screenController = new ScreenController(stage, scene);
        screenController.addScreen("inicio", FXMLLoader.load(getClass().getResource("VentanaInicio.fxml")));
        screenController.addScreen("resultado", FXMLLoader.load(getClass().getResource("EndWindow.fxml")));

        controller = new Controller();
        try {
            ventanaInicio();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public void start(Stage primaryStage) throws Exception {
    }

    private void ventanaInicio() {
        Scene scene = screenController.getScene();
        screenController.activate("inicio");
        Button button = (Button) scene.lookup("#generatePass");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Scene scene = screenController.getScene();
                    TextField directory, file, name;
                    directory = (TextField) scene.lookup("#directory");
                    file = (TextField) scene.lookup("#fileName");
                    name = (TextField) scene.lookup("#passwordName");
                    String password = controller.generateAndSavePassword(directory.getText(), file.getText(), name.getText());
                    mostrarPassword(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void mostrarPassword(String password) throws Exception {
        Scene scene = screenController.getScene();
        screenController.activate("resultado");
        Label pass = (Label) scene.lookup("#password");
        pass.setText(password);
        Button button = (Button) scene.lookup("#loadVentanainicio");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ventanaInicio();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
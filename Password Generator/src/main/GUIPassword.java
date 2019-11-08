package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class GUIPassword extends Application {
    Controller controller;

    public GUIPassword(Stage stage){
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
                    mostrarPassword(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private String getNombrePassword(){
        System.out.println ("Por favor introduzca un nombre para la contraseña:");
        String name = "";
        Scanner sc = new Scanner (System.in);
        name = sc.nextLine ();
        return name;
    }

    //Click on generate pass
    public void GUIGeneratePassword(String directory, String fileName, String passwordName){
        controller.generateAndSavePassword(null, null, passwordName);
    }

    private void mostrarPassword(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EndWindow.fxml"));
        Scene scene = new Scene(root, 480, 390);
        primaryStage.setScene(scene);
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

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Controller/* extends Application */{
    //private static Logger log = LogManager.getLogger(Controller.class);
    PasswordGenerator passwordGenerator = PasswordGenerator.getInstance();
    public void generatePassword(){
        String name = getNombrePassword();
        Password password = passwordGenerator.generatePassword(name);
        CheckPasswordSecurity security = new CheckPasswordSecurity();
        if(!security.check(password.getPassword())){
            password = passwordGenerator.generatePassword(name);
            while(!security.check(password.getPassword())){
                password = passwordGenerator.generatePassword(name);
            }
        }

        DAOPassword dao = new DAOPassword();
        try {
            dao.guardarPassword(password);
            System.out.println("Nombre: " + password.getName() + "\t contraseņa:" + password.getPassword());
        }
        catch(Exception e){
            System.out.println("Exception");
        }

    }

    private String getNombrePassword(){
        System.out.println ("Por favor introduzca un nombre para la contraseņa:");
        String name = "";
        Scanner sc = new Scanner (System.in);
        name = sc.nextLine ();
        return name;
    }


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.getIcons().add(new Image("/Images/lock.png"));
        primaryStage.setScene(new Scene(root, 480, 390));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

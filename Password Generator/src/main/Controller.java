package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller/* extends Application */{
    PasswordGenerator passwordGenerator = PasswordGenerator.getInstance();
    public void generatePassword(){
        Password password = passwordGenerator.generatePassword();
        CheckPasswordSecurity security = new CheckPasswordSecurity();
        if(!security.check(password.getPassword())){
            password = passwordGenerator.generatePassword();
            while(!security.check(password.getPassword())){
                password = passwordGenerator.generatePassword();
            }
        }

        DAOPassword dao = new DAOPassword();
        try {
            dao.guardarPassword(password.getPassword());
            System.out.println("Contraseña:" + password.getPassword());
        }
        catch(Exception e){
            System.out.println("Exception");
        }

    }

/*
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GeneratePasswordWindow.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/
}

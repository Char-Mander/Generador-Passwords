package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GUIPassword extends Application {
    private PasswordController passwordController;
    private ScreenController screenController;
    private final int width = 480, height = 390;

    public GUIPassword(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(GUIComponents.VENTANA_INICIO.getValue()));
        Scene scene = new Scene(root, width, height);
        passwordController = new PasswordController();
        screenController = new ScreenController(stage, scene);
        screenController.addScreen("inicio", FXMLLoader.load(getClass().getResource(GUIComponents.VENTANA_INICIO.getValue())));
        screenController.addScreen("resultado", FXMLLoader.load(getClass().getResource(GUIComponents.VENTANA_PASSWORD.getValue())));
        try {
            ventanaInicio();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public void start(Stage primaryStage) throws Exception {
    }

    private void ventanaInicio() {
        screenController.activate("inicio");
        screenController.cleanTextFields();
        Button button = screenController.getButton(GUIComponents.GENERATE_PASSWORD_BUTTON.getValue());
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    TextField directory, file, name;
                    directory = screenController.getTextField(GUIComponents.DIRECTORY_TEXT_FIELD.getValue());
                    file = screenController.getTextField(GUIComponents.FILE_NAME_TEXT_FIELD.getValue());
                    name = screenController.getTextField(GUIComponents.PASSWORD_NAME_TEXT_FIELD.getValue());
                    String password = passwordController.generateAndSavePassword(directory.getText(), file.getText(), name.getText());
                    mostrarPassword(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void mostrarPassword(String password) throws Exception {
        screenController.activate("resultado");
        Label pass = screenController.getLabel(GUIComponents.PASSWORD_LABEL.getValue());
        pass.setText(password);
        copyToTheClipBoard(password);
        alertConfirmation();
        Button button = screenController.getButton(GUIComponents.GO_TO_START_WINDOW_BUTTON.getValue());
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

    private void copyToTheClipBoard(String info){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent cc = new ClipboardContent();
        cc.putString(info);
        clipboard.setContent(cc);
    }

    private void alertConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("The password has been successfully saved");
        alert.setHeaderText(null);
        alert.setContentText("The password has been copied to the clipboard");
        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait();
    }
}
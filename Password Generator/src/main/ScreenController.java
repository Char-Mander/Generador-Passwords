package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class ScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Stage primaryStage;
    private Scene currentScene;

    public ScreenController(Stage _primaryStage, Scene main) {
        this.primaryStage = _primaryStage;
        this.currentScene = main;
    }

    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    protected void activate(String name){
        currentScene.setRoot( screenMap.get(name) );
        primaryStage.setScene(currentScene);
        primaryStage.show();
    }

    protected void desactivate(String name){
        primaryStage.hide();
    }

    public Scene getScene(){ return currentScene; }

    public Stage getStage(){ return primaryStage;}

    public void cleanTextFields(){
        TextField cleanDirectory = (TextField) currentScene.lookup(GUIComponents.DIRECTORY_TEXT_FIELD.getValue());
        TextField cleanFile = (TextField) currentScene.lookup(GUIComponents.FILE_NAME_TEXT_FIELD.getValue());
        TextField cleanPass = (TextField) currentScene.lookup(GUIComponents.PASSWORD_NAME_TEXT_FIELD.getValue());
        cleanDirectory.setText("");
        cleanFile.setText("");
        cleanPass.setText("");
    }

    public Label getLabel(String id){ return (Label) currentScene.lookup(id);}

    public TextField getTextField(String id){ return (TextField) currentScene.lookup(id);}

    public Button getButton(String id){ return  (Button) currentScene.lookup(id); }

}
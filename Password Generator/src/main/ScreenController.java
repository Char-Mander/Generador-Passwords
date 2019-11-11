package main;

import javafx.scene.Scene;
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

    public void cleanFields(){
        TextField cleanPass = (TextField) currentScene.lookup("#passwordName");
        cleanPass.setText("");
    }
}
package com.example.whack;

import javafx.application.Preloader;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class ChangeScene {

    public static Stage stage;
    public static Scene scene;

    public static void changeScene(Event event, String strFXMLFileName) throws IOException{
        URL url = new File("src/main/resources/com/example/whack/" + strFXMLFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.show();
    }

}

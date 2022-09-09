package com.example.whack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button btnHello;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        btnHello.setText(("Done"));
        ChangeScene.changeScene(event, "WhackBoard.fxml");

    }
}
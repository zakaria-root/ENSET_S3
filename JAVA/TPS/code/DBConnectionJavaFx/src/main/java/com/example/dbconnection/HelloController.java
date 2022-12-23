package com.example.dbconnection;

import com.example.dbconnection.DB.DBInteraction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        if (DBInteraction.connect() == true) {
            welcomeText.setText("Database Connected!");
        } else {
            welcomeText.setText("Database Not connected");
        }

    }
}
package com.parking.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MainAppController {
    @FXML
    private Label welcomeText;
    
    @FXML
    private TextField matricula;
    
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Matricula Anadida!");
    }
}

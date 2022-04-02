package com.parking.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MainAppController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label welcomeText1;
    @FXML
    private TextField matricula;
    @FXML
    private TextField propietario;
    @FXML
    protected void onMatriculaButtonClick() {
        welcomeText.setText("Matricula Anyadida!");
    }
    @FXML
    protected void onPropietarioButtonClick() {
        welcomeText1.setText("Propietario Anyadido!");
    }
}

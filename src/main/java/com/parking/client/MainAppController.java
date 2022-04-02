package com.parking.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MainAppController {
    @FXML
    private Label matriculaLabel;
    @FXML
    private Label usuarioLabel;
    @FXML
    private TextField matriculaTF;
    @FXML
    private TextField propietarioTF;

    @FXML
    protected void onUsuarioButtonClick() {
        MainApp.initRootLayout(getClass().getResource("usuarioWindow.fxml"));
    }
    @FXML
    protected void onPlazaButtonClick() {
        MainApp.initRootLayout(getClass().getResource("plazaWindow.fxml"));
    }

    @FXML
    protected void onPropietarioButtonClick() {
        usuarioLabel.setText("Propietario Anñadido!");
        //TODO Guardar propietario
    }
    @FXML
    protected void onMatriculaButtonClick() {
        matriculaLabel.setText("Matrícula Añadida!");
        //TODO Guardar matrícula
    }
}

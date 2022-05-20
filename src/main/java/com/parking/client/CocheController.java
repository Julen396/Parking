package com.parking.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CocheController {

    @FXML
    private Button bRegistrar;
    
    /** TextFields **/
    @FXML
    private TextField matricula;
    @FXML
    private TextField nombreProp;
    
    /** Labels **/
    @FXML
    private Label matriculaText;
    @FXML
    private Label nombrePropText;

    @FXML
    void onHomeButtonClick(ActionEvent event) {
    	MainApp.initRootLayout(getClass().getResource("cocheWindow.fxml"));
        System.out.println(nombreProp.getText() + " registrado correctamente!");
    }

}

package com.parking.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PlazaController {
	
	/** Buttons **/
    @FXML
    private Button botonAnyadir;
    
    /** TextFields **/
    @FXML
    private TextField coche;
    @FXML
    private TextField nombreZona;
    @FXML
    private TextField piso;
    @FXML
    private TextField posicion;    
    
    /** Labels **/
    @FXML
    private Label cocheText;
    @FXML
    private Label nombreZonaText;
    @FXML
    private Label pisoText;
    @FXML
    private Label posicionText;

    /** Metodos **/
    @FXML
    void onPropietarioButtonClick(ActionEvent event) {
    	cocheText.setText("coche anyadido");
    	nombreZonaText.setText("zona anyadida!");
    	pisoText.setText("piso anyadido!");
    	posicionText.setText("posicion anyadida!");
    }

    @FXML
    void onHomeButtonClick() {
        MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
    }

}

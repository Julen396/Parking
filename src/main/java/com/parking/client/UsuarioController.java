package com.parking.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class UsuarioController {
	
	/** Buttons **/
	@FXML
    private Button bRegistrar;

	/** TextFields **/
    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
  
    /** Labels **/
    @FXML
    private Label dniText;
    @FXML
    private Label fecha_nctoText;
    @FXML
    private Label nombreText;
   
    /** DatePickers **/
    @FXML
    private DatePicker fecha_ncto;

    @FXML
    void onMatriculaButtonClick(ActionEvent event) {
    	dniText.setText("Anyadido dni!");
    	fecha_nctoText.setText("Anyadida fecha de nacimiento!");
    	nombreText.setText("Anyadido nombre!");
    	System.out.println(dni.getText() + " registrado correctamente!");
    }

    @FXML
    void onHomeButtonClick() {
        MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
        System.out.println(nombre.getText() + " registrado correctamente!");
    }

}

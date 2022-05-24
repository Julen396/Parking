package com.parking.client;

import com.parking.serialization.Coche;
import com.parking.serialization.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.Month;

public class CocheController {

    @FXML
    private Button bRegistrar;
    
    /** TextFields **/
    @FXML
    private TextField matricula;
    @FXML
    private TextField dniProp;

    @FXML
    void onHomeButtonClick(ActionEvent event) {
    	MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
    }

    @FXML
    protected void onCrearButtonClick() {
        //Guardar propietario
        Usuario user = new Usuario(dniProp.getText(), "Usuario", LocalDate.of(2001, Month.DECEMBER, 12));
        Coche coche = new Coche(matricula.getText(), user);

        MainApp.cliente.addCoche(coche);
    }

}

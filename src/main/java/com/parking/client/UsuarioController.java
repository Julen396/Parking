package com.parking.client;

import com.parking.serialization.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class UsuarioController {

	/** TextFields **/
    @FXML
    private TextField dniTF;
    @FXML
    private TextField nombreTF;
   
    /** DatePickers **/
    @FXML
    private DatePicker fecha_ncto;

    @FXML
    void onCrearButtonClick() {
    	Usuario u = new Usuario(dniTF.getText(), nombreTF.getText(), fecha_ncto.getValue());

        MainApp.cliente.addUsuario(u);
    	System.out.println(dniTF.getText() + " registrado correctamente!");
    }

    @FXML
    void onHomeButtonClick() {
        MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
    }

}

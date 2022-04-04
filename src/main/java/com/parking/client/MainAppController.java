package com.parking.client;

import com.parking.serialization.Coche;
import com.parking.serialization.Usuario;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Date;


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
    protected void onCrearButtonClick() {
        usuarioLabel.setText("Propietario Anñadido!");
        matriculaLabel.setText("Matrícula añadida!");
        //TODO Guardar propietario
        Usuario user = new Usuario("123456789A", propietarioTF.getText(), new Date());
        Coche coche = new Coche(matriculaTF.getText(), user);

        MainApp.cliente.addCoche(coche);
    }
}

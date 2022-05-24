package com.parking.client;

import com.parking.serialization.Coche;
import com.parking.serialization.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.Month;


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
    protected void onRegistrarCocheButtonClick() {
        MainApp.initRootLayout(getClass().getResource("cocheWindow.fxml"));
    }
    @FXML
    protected void onMostrarUsuariosButtonClick() {MainApp.initRootLayout(getClass().getResource("mostrarUsuariosWindow.fxml")); }
    @FXML
    protected void onMostrarMatriculasButtonClick() {MainApp.initRootLayout(getClass().getResource("mostrarMatriculasWindow.fxml")); }
    @FXML
    protected void onCrearButtonClick() {
        usuarioLabel.setText("Propietario Anyadido!");
        matriculaLabel.setText("Matricula anyadida!");

        //Guardar propietario
        Usuario user = new Usuario("1234567A", propietarioTF.getText(), LocalDate.of(2001, Month.DECEMBER, 12));
        Coche coche = new Coche(matriculaTF.getText(), user);

        MainApp.cliente.addCoche(coche);
    }
}

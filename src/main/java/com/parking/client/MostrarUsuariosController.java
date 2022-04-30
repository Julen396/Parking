package com.parking.client;

import com.parking.serialization.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class MostrarUsuariosController {

    /** Table **/
    @FXML
    private TableView table;

    /** Métodos **/
    @FXML
    void onHomeButtonClick() {
        MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
    }

    @FXML
    void onMostrarButtonClick() {
        ArrayList<Usuario> usuarios = MainApp.cliente.getUsuarios();

        for (Usuario u: usuarios) {
            table.getItems().add(u);
        }
    }
}

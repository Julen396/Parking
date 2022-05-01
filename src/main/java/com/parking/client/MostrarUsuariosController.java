package com.parking.client;

import com.parking.serialization.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.datanucleus.properties.PropertyValidator;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MostrarUsuariosController {

    /** Table **/
    @FXML
    private TableView<Usuario> table;

    @FXML private TableColumn<Usuario, String> nombreColumn;
    @FXML private TableColumn<Usuario, String> dniColumn;
    @FXML private TableColumn<Usuario, LocalDate> dateColumn;

    /** Métodos **/
    @FXML
    void onHomeButtonClick() {
        MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
    }

    @FXML
    void onMostrarButtonClick() {

        nombreColumn.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        dniColumn.setCellValueFactory(new PropertyValueFactory<Usuario, String>("dni"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Usuario, LocalDate>("fecha_nac"));

        table.setItems(getPeople());
    }

    public ObservableList<Usuario> getPeople() {
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        for (Usuario u: MainApp.cliente.getUsuarios()) {
            usuarios.add(u);
        }
        usuarios.add(new Usuario("11111111D", "Unai", LocalDate.of(2001, Month.DECEMBER, 15)));
        usuarios.add(new Usuario("12344122S", "Julen", LocalDate.of(2002, Month.MAY, 2)));
        usuarios.add(new Usuario("12345678A", "Pike", LocalDate.of(1999, Month.JULY, 21)));

        return usuarios;
    }
}

package com.parking.client;

import com.parking.serialization.Coche;
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

public class MostrarListaMatriculasController {
	/** Table **/
    @FXML
    private TableView<Coche> table;

    @FXML private TableColumn<Coche, String> matricula;
    @FXML private TableColumn<Coche, Usuario> propietario;
    
    /** Métodos **/
    @FXML
    void onHomeButtonClick() {
        MainApp.initRootLayout(getClass().getResource("mainWindow.fxml"));
    }

    @FXML
    void onMostrarButtonClick() {

    	matricula.setCellValueFactory(new PropertyValueFactory<Coche, String>("matricula"));
    	propietario.setCellValueFactory(new PropertyValueFactory<Coche, Usuario>("propietario"));
        

        table.setItems(getMatricula());
    }

    public ObservableList<Coche> getMatricula() {
        ObservableList<Coche> coches = FXCollections.observableArrayList();
        for (Coche c: MainApp.cliente.getCoches()) {
            coches.add(c);
        }
        coches.add(new Coche("1234ABC",(new Usuario("11111111D", "Unai", LocalDate.of(2001, Month.DECEMBER, 15)))));
        coches.add(new Coche("1234ABC",(new Usuario("12345678A", "Pike", LocalDate.of(1999, Month.JULY, 21)))));
        coches.add(new Coche("1234ABC",(new Usuario("12344122S", "Julen", LocalDate.of(2002, Month.MAY, 2)))));        
        return coches;
    }
}

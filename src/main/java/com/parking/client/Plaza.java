package com.parking.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Plaza extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RegistroPlaza");

        MainApp.initRootLayout(getClass().getResource("plazaWindow.fxml"));

    }

    /**
     * Returns the main stage.
     * @return returns the stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

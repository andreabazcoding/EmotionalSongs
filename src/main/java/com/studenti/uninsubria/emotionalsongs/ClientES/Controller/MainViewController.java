package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainViewController implements Initializable {

    @FXML
    private StackPane stackPaneMain;

    @FXML
    private Label exit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit.setOnMouseClicked(event->{
            System.exit(0);
        });


        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
            stackPaneMain.getChildren().removeAll();
            stackPaneMain.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnHomePressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/View/HomeView"));
        stackPaneMain.getChildren().removeAll();
        stackPaneMain.getChildren().setAll(fxml);
    }

    public void btnAccediPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/View/LoginView"));
        stackPaneMain.getChildren().removeAll();
        stackPaneMain.getChildren().setAll(fxml);
    }

    public void btnRegistratiPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/View/RegistratiView"));
        stackPaneMain.getChildren().removeAll();
        stackPaneMain.getChildren().setAll(fxml);
    }

    public void btnPlaylistPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/View/PlaylistView"));
        stackPaneMain.getChildren().removeAll();
        stackPaneMain.getChildren().setAll(fxml);
    }

    public void btnCreaNuovaPlaylistPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/View/NuovaPlaylistView"));
        stackPaneMain.getChildren().removeAll();
        stackPaneMain.getChildren().setAll(fxml);
    }
}

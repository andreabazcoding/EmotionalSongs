package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author luqmanasghar
 */
public class MenuController extends Controller implements Initializable{
    @FXML
    private Button btnAccedi;
    @FXML
    private Button btnPlaylist;
    @FXML
    private Button btnCreaPlaylist;
    @FXML
    private Button btnCanzoni;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        if (getUserId() == 0) {
            btnCreaPlaylist.setDisable(true);
        } else {
            btnAccedi.setDisable(true);
            btnAccedi.setText("Accesso effettuato");
        }
    }

    public void addListeners() {
        btnAccedi.setOnAction(actionEvent -> onAccedi());
        btnPlaylist.setOnAction(actionEvent -> onPlaylist());
        btnCreaPlaylist.setOnAction(actionEvent -> onCreaPlaylist());
        btnCanzoni.setOnAction(actionEvent -> onCanzoni());
    }

    @FXML
    private void onPlaylist() {
        Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("Playlist");
    }

    @FXML
    private void onCanzoni() {
        Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("Canzoni");
    }

    @FXML
    private void onAccedi() {
        Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("Accedi");
    }

    @FXML
    private void onCreaPlaylist() { Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("CreaPlaylist"); }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }
}

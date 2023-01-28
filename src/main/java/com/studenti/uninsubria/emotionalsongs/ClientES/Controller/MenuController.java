package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author luqmanasghar
 */
public class MenuController implements Initializable{

    public Button btnAccedi;
    public Button btnPlaylist;
    public Button btnCreaPlaylist;
    public Button btnCanzoni;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddListeners();
    }

    public void AddListeners(){
        btnPlaylist.setOnAction(actionEvent -> onPlaylist());
        btnCanzoni.setOnAction(actionEvent -> onCanzoni());
        btnAccedi.setOnAction(actionEvent -> onAccedi());
    }

    private void onPlaylist() {
        Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("Playlist");
    }

    private void onCanzoni() {
        Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("Canzoni");
    }

    private void onAccedi() {
        Model.GetInstance().GetViewFactory().getSelectedMenuItem().set("Accedi");
    }
}

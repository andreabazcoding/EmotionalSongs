package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    @FXML
    Label lblAccesso;

    private BorderPane mainViewParent;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvCanzoniView());
        addListeners();
        if (getUserId() == 0) {
            btnCreaPlaylist.setDisable(true);
        } else {
            btnAccedi.setDisable(true);
            btnAccedi.setText("Accesso effettuato");
            lblAccesso.setText("Accesso effettuato");
        }
    }

    public void setMainViewParent(BorderPane mainViewParent) {
        this.mainViewParent = mainViewParent;
    }

    public void addListeners() {
        btnAccedi.setOnAction(actionEvent -> onAccedi());
        btnPlaylist.setOnAction(actionEvent -> onPlaylist());
        btnCreaPlaylist.setOnAction(actionEvent -> onCreaPlaylist());
        btnCanzoni.setOnAction(actionEvent -> onCanzoni());
    }

    @FXML
    private void onPlaylist() {
        mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvPlaylistView(getUserId()));
    }

    @FXML
    private void onCanzoni() {
        mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvCanzoniView());
    }

    @FXML
    private void onAccedi() {
        try {
            Stage stage = (Stage)mainViewParent.getScene().getWindow();
            Model.GetInstance().GetViewFactory().CloseStage(stage);
            Model.GetInstance().GetViewFactory().ShowLoginView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCreaPlaylist() {
        try {
            Stage stage = (Stage)mainViewParent.getScene().getWindow();
            Model.GetInstance().GetViewFactory().CloseStage(stage);
            Model.GetInstance().GetViewFactory().ShowEditPlaylistView(getUserId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }
}

package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

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
 * Classe controller per la view "Menu".
 * Gestisce la selezione dei bottoni nella MainView.
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
            btnAccedi.setText("Logout");
            lblAccesso.setText("Utente: " + getUsername());
        }
    }

    public void setMainViewParent(BorderPane mainViewParent) {
        this.mainViewParent = mainViewParent;
    }

    public void addListeners() {
        btnAccedi.setOnAction(actionEvent -> {
            try {
                onAccedi();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnPlaylist.setOnAction(actionEvent -> onPlaylist());
        btnCreaPlaylist.setOnAction(actionEvent -> onCreaPlaylist());
        btnCanzoni.setOnAction(actionEvent -> onCanzoni());
    }

    /**
     * Al click del bottone "Playlist" mostra la view "GvPlaylist"
     */
    @FXML
    private void onPlaylist() {
        mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvPlaylistView(getUserId(), getUsername()));
    }

    /**
     * Al click del bottone "Canzoni" mostra la view "GvCanzoni"
     */
    @FXML
    private void onCanzoni() {
        mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvCanzoniView());
    }

    /**
     * Al click del bottone "Accedi" apre la view "LoginView"
     */
    @FXML
    private void onAccedi() throws IOException {
        if (btnAccedi.getText() == "Logout") {
            Stage stage = (Stage)mainViewParent.getScene().getWindow();
            Model.GetInstance().GetViewFactory().CloseStage(stage);
            Model.GetInstance().GetViewFactory().ShowMainView();
        } else {
            try {
                Stage stage = (Stage)mainViewParent.getScene().getWindow();
                Model.GetInstance().GetViewFactory().CloseStage(stage);
                Model.GetInstance().GetViewFactory().ShowLoginView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Al click del bottone "Crea Playlist" apre la view "EditPlaylist"
     */
    @FXML
    private void onCreaPlaylist() {
        try {
            Stage stage = (Stage)mainViewParent.getScene().getWindow();
            Model.GetInstance().GetViewFactory().CloseStage(stage);
            Model.GetInstance().GetViewFactory().ShowEditPlaylistView(getUserId(), getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }
}

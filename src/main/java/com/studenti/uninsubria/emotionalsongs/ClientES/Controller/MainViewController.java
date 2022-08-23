package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainViewController extends Controller implements Initializable {

    // <editor-fold desc="Attributi FXML">
    public Button btnAccedi;
    public Button btnRegistrati;
    public Button btnPlaylist;
    public Button btnHome;
    public Button btnCreaPlaylist;

    // </editor-fold>

    private int userId;

    // <editor-fold desc="Methods">

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Parent fxml = null;
        try {
            // Da togliere
            setUserId(5);

            fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/GvCanzoni.fxml")));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnHomePressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/GvCanzoni.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void btnAccediPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/LoginView.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void btnRegistratiPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/RegistratiView.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void btnPlaylistPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/PlaylistEditor.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void btnCreaNuovaPlaylistPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        setContentArea(contentArea);
        changeView("CreaPlaylist.fxml", getUserId());
    }


    /**
     * Loads the content of the view
     */
    @Override
    public void LoadContent() {

    }

    // </editor-fold>

}

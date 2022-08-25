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

    /**
     * Popola la MainView con la pane GvCanzoni permettendo di vedere la lista delle canzoni
     * @param url
     * @param resourceBundle
     */
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

    /**
     * Permetto lo switch sulla view GvCanzoni
     * @param actionEvent
     * @throws IOException
     */
    public void btnHomePressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/GvCanzoni.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    /**
     * Permetto lo switch sulla view LoginView
     * @param actionEvent
     * @throws IOException
     */
    public void btnAccediPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/LoginView.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    /**
     * Permetto lo switch sulla view RegistrationView
     * @param actionEvent
     * @throws IOException
     */
    public void btnRegistratiPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/RegistrationView.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    /**
     * Permetto lo switch sulla view GvPlaylist
     * @param actionEvent
     * @throws IOException
     */
    public void btnPlaylistPressed(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/PlaylistEditor.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    /**
     * Permetto lo switch sulla view CreaPlaylist
     * @param actionEvent
     * @throws IOException
     */
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

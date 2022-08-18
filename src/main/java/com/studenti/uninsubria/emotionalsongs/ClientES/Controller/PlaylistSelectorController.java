package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.HelloApplication;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe controller per la view "PlaylistSelector-view"
 * Permette la visualizzazione e la selezione di tutte le playlist
 * @author Andrea Basilico
 * @author Nour Faraj
 */

public class PlaylistSelectorController extends Application implements Initializable {

    @FXML
    private ListView lviewSelezionePlaylist;

    @FXML
    private Button btnSelezionaPlaylist;

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * @param stage
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/View/PlaylistSelector-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Selezione playlist");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Riceve il resultset dal metodo statico allPlaylists() e inserisce i dati nella listview
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ResultSet resultSet = PlaylistEntity.allPlaylists();
            while (resultSet.next()) {
                lviewSelezionePlaylist.getItems().add(resultSet.getString(2) + " [" + resultSet.getString(3) + "]");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gestisce l'evento di click del mouse sul bottone "Seleziona"
     * @param mouseEvent
     */
    public void btnSelezionaPlaylistClicked(MouseEvent mouseEvent) {
        if(btnSelezionaPlaylist.isPressed()) {
            //do something
        }
    }
}

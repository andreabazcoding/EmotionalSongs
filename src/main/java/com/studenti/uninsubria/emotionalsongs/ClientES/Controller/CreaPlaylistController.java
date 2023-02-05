package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author luqmanasghar
 */
public class CreaPlaylistController extends Controller implements Initializable {

    // <editor-fold desc="Attributi FXML">
    public TextField txtNomePlaylist;
    public Button btnCreaPlaylist;
    public BorderPane borderPaneListCanzoniPlaylist;
    public Label lblErrorMessage;

    // </editor-fold>

    // <editor-fold desc="Methods">

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //stampa prova
        System.out.println("User ID: " + getUserId());

        addListeners();
    }

    private void addListeners() {
        btnCreaPlaylist.setOnAction(actionEvent -> {
            try {
                btnCreaPlaylistPressed();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Creazione di una playlist
     * @throws SQLException
     * @throws IOException
     */
    public void btnCreaPlaylistPressed() throws SQLException, IOException {

        PlaylistModel playlistModel = new PlaylistModel();
        PlaylistEntity playlistEntity = new PlaylistEntity();
        int createdPlaylistId = 0;
        String nomePlaylist = txtNomePlaylist.getText().trim();

        if(nomePlaylist.isBlank())
            lblErrorMessage.setText("Inserire un nome valido.");
        else if(PlaylistEntity.checkPlaylistExists(nomePlaylist, getUserId()))
            lblErrorMessage.setText("Una playlist con questo nome esiste già, cambiare nome.");
        else{
            UtenteRegistratoModel utenteRegistratoModel = new UtenteRegistratoModel();
            playlistModel.setNomePlaylist(nomePlaylist);
            utenteRegistratoModel.setUtenteRegistratoID(getUserId());
            createdPlaylistId = playlistEntity.Create(playlistModel, utenteRegistratoModel);

            // dopo aver creato la playlist chiamo la playlist editor passando l'id della playlist creata
            changeView("PlaylistEditor.fxml",
                    getUserId(),
                    createdPlaylistId);
        }
    }

    /**
     * Loads the content of the view
     */
    @Override
    public void LoadContent() {

    }

    // </editor-fold>


}

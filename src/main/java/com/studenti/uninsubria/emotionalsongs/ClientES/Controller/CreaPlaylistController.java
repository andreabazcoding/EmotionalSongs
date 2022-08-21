package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author luqmanasghar
 */
public class CreaPlaylistController extends Controller {
    public TextField txtNomePlaylist;
    public Button btnCreaPlaylist;
    public BorderPane borderPaneListCanzoniPlaylist;
    public Label lblErrorMessage;

    public void btnCreaPlaylistPressed(ActionEvent actionEvent) throws SQLException, IOException {

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
}

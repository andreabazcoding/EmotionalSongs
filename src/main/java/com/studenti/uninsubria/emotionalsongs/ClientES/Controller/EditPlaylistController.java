package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.*;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

/**
 * Classe controller di "EditPlaylistView"
 * Permette la creazione di una nuova playlist
 * @author  Andrea Basilico
 */
public class EditPlaylistController extends Controller implements Initializable {

    // <editor-fold desc="Attributi FXML">
    @FXML
    private Button btnAggiungiCanzone, btnRimuoviCanzone, btnCrea, btnIndietro;
    @FXML
    private TextField txtFieldTitoloPlaylist;
    @FXML
    private ListView<String> lviewRiepilogoPlaylist;

    @FXML
    private TableView tbViewCanzoni;

    @FXML
    public BorderPane bpGvCanzoni;

    private GvCanzoniController gvCanzoniController;

    private ArrayList<LinkedList> songIdList;

    // </editor-fold>

    // <editor-fold desc="Methods">
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();

        songIdList = new ArrayList<>();

        ArrayList arrayList = Model.GetInstance().GetViewFactory().GetGvCanzoniView(new ArrayList<Object>());
        gvCanzoniController = (GvCanzoniController) arrayList.get(0);
        bpGvCanzoni.setTop((Node) arrayList.get(1));
        tbViewCanzoni = gvCanzoniController.getTbViewCanzoni();

        System.out.println("User ID: " + getUserId());
    }

    public void addListeners() {
        btnAggiungiCanzone.setOnAction(actionEvent -> {
            try {
                onAggiungiCanzone(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnRimuoviCanzone.setOnAction(actionEvent -> onRimuoviCanzone());
        btnCrea.setOnAction(actionEvent -> {
            try {
                onCrea();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnIndietro.setOnAction(actionEvent -> {
            try {
                onIndietro();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Al click del bottone "Aggiungi canzone" aggiunge la canzone alla playlist.
     * @param actionEvent
     * @throws IOException
     */
    public void onAggiungiCanzone(ActionEvent actionEvent) throws IOException {

        TableModel tableModel = (TableModel) tbViewCanzoni.getSelectionModel().getSelectedItem();

        if (tableModel == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nessuna canzone selezionata");
            alert.setHeaderText(null);
            alert.setContentText("Selezionare una canzone e poi premere il bottone.");
            alert.showAndWait();
        } else {
            int canzoneId = (int) tableModel.getCanzoneId().getValue();
            String titolo = tableModel.getTitolo().get();
            String autore = tableModel.getAutore().get();
            int anno = (int) tableModel.getAnno().getValue();

            lviewRiepilogoPlaylist.getItems().add(titolo + " - " + autore);
            lviewRiepilogoPlaylist.getSelectionModel().selectLast();

            LinkedList<Integer> couple = new LinkedList<Integer>();
            couple.add(lviewRiepilogoPlaylist.getSelectionModel().getSelectedIndex());
            couple.add(canzoneId);
            songIdList.add(couple);
        }
    }

    /**
     * Al click del bottone "Rimuovi canzone" rimuove la canzone dalla playlist.
     */
    public void onRimuoviCanzone() {
        int selectedId = lviewRiepilogoPlaylist.getSelectionModel().getSelectedIndex();
        if (selectedId == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nessuna canzone selezionata");
            alert.setHeaderText(null);
            alert.setContentText("Selezionare una canzone e poi premere il bottone.");
            alert.showAndWait();
        } else {

            LinkedList<Integer> couple = null;

            for (LinkedList<Integer> element : songIdList) {
                if (element.getFirst().intValue() == selectedId) {
                    lviewRiepilogoPlaylist.getItems().remove(selectedId);
                    couple = element;
                    break;
                }
            }
            songIdList.remove(couple);
        }
    }

    /**
     * Al click del bottone "Crea Playlist" effettua il salvataggio della playlist sul database.
     * @throws SQLException
     * @throws IOException
     */
    public void onCrea() throws SQLException, IOException {
        ObservableList<String> playlist = lviewRiepilogoPlaylist.getSelectionModel().getSelectedItems();
        if (playlist.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("La playlist non può essere vuota");
            alert.setHeaderText(null);
            alert.setContentText("Aggiungere almeno una canzone per creare la playlist.");
            alert.showAndWait();
        } else if(txtFieldTitoloPlaylist.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Il nome della playlist non può essere vuoto");
            alert.setHeaderText(null);
            alert.setContentText("Inserire un nome playlist valido.");
            alert.showAndWait();
        } else {

            PlaylistModel playlistModel = new PlaylistModel();
            playlistModel.setNomePlaylist(txtFieldTitoloPlaylist.getText());
            playlistModel.setUtenteRegistratoID(getUserId());

            UtenteRegistratoModel utenteRegistratoModel = new UtenteRegistratoModel();
            utenteRegistratoModel.setUtenteRegistratoID(getUserId());

            PlaylistEntity playlistEntity = new PlaylistEntity();
            int playlistId = playlistEntity.Create(playlistModel, utenteRegistratoModel);

            CrossPlaylistCanzoniModel crossPlaylistCanzoniModel = new CrossPlaylistCanzoniModel();
            crossPlaylistCanzoniModel.setPlaylistID(playlistId);

            for (LinkedList<Integer> couple : songIdList) {
                crossPlaylistCanzoniModel.setCanzoneID(couple.getLast());
                playlistEntity.CreateCrossPlaylist(crossPlaylistCanzoniModel);
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Playlist creata con successo");
            alert.setHeaderText(null);
            alert.setContentText("Hai creato la playlist \"" + txtFieldTitoloPlaylist.getText() + "\"");
            alert.showAndWait();

            clearAll();
        }
    }

    /**
     * Al click del bottone "Indietro" chiude la view attuale e apre la view principale.
     * @throws IOException
     */
    public void onIndietro() throws IOException {
        Stage stage = (Stage) btnIndietro.getScene().getWindow();
        Model.GetInstance().GetViewFactory().CloseStage(stage);
        Model.GetInstance().GetViewFactory().ShowMainView(getUserId(), getUsername());
    }

    public void clearAll() {
        txtFieldTitoloPlaylist.clear();
        lviewRiepilogoPlaylist.getItems().clear();
    }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }
    // </editor-fold>

}

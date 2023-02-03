package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditPlaylistController extends Controller implements Initializable {

    // <editor-fold desc="Attributi FXML">
    @FXML
    private Button btnAggiungiCanzone, btnRimuoviCanzone, btnCrea;
    @FXML
    private TextField txtFieldTitoloPlaylist;
    @FXML
    private ListView<ObservableList> lviewRiepilogoPlaylist;

    @FXML
    private TableView tbViewCanzoni;
    // </editor-fold>

    // <editor-fold desc="Methods">
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        System.out.println("User ID: " + getUserId());

    }

    public void addListeners() {
        btnAggiungiCanzone.setOnAction(actionEvent -> onAggiungiCanzone());
        btnRimuoviCanzone.setOnAction(actionEvent -> onRimuoviCanzone());
        btnCrea.setOnAction(actionEvent -> onCrea());
    }

    @FXML
    public void onAggiungiCanzone() {

    }
    @FXML
    public void onRimuoviCanzone() {

    }
    @FXML
    public void onCrea() {

    }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }
    // </editor-fold>

}

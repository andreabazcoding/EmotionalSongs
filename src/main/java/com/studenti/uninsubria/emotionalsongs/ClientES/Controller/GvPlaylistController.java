package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe controller per la view "PlaylistSelectorView"
 * Permette la visualizzazione e la selezione di tutte le playlist
 * @author Andrea Basilico
 * @author Nour Faraj
 */

public class GvPlaylistController extends Controller implements Initializable {

    // <editor-fold desc="Attributi FXML">

    @FXML
    private TableView<TableModel> tbViewPlaylist;
    @FXML
    private TableColumn<TableModel, String> tblColumnTitoloPlaylist;
    @FXML
    private TableColumn<TableModel, String> tblColumnUsername;
    @FXML
    private Button btnSelezionaPlaylist;

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }

    /**
     * @param stage
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/GvPlaylist.fxml"));
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

        System.out.println(getUserId() + " in GvPlaylist");

        try {
            ResultSet rs = PlaylistEntity.allPlaylists();
            ObservableList<TableModel> data;
            data = FXCollections.observableArrayList();

            while(rs.next()){
                data.add(new TableModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            tblColumnTitoloPlaylist.setCellValueFactory(tableModelPlaylistStringCellDataFeatures -> tableModelPlaylistStringCellDataFeatures.getValue().getNomePlaylist());
            tblColumnUsername.setCellValueFactory(tableModelPlaylistStringCellDataFeatures -> tableModelPlaylistStringCellDataFeatures.getValue().getUsername());
            tbViewPlaylist.setItems(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Al click del mouse sul bottone "Seleziona" apre la playlist selezionata.
     * @param actionEvent
     */
    public void btnSelezionaPlaylistClicked(ActionEvent actionEvent) throws IOException {
        TableModel tableModel = tbViewPlaylist.getSelectionModel().getSelectedItem();
        int playlistId = tableModel.getPlaylistId();
        String nomePlaylist = tableModel.getNomePlaylist().get();
        int userId = getUserId();
        System.out.println(userId + " passato da GvPlaylist a PlaylistViewer");

        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Model.GetInstance().GetViewFactory().ShowPlaylistViewer(userId, playlistId, nomePlaylist);
    }

    // </editor-fold>
}

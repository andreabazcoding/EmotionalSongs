package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CrossPlaylistCanzoniModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.View.ViewFactory;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.EmozioniEntity;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe controller per la view "PlaylistViewer"
 * Permette di visualizzare le canzoni presenti all' interno della playlist selezionata.
 * @author Nour Faraj
 */

public class PlaylistViewerController extends Controller implements Initializable {

    @FXML
    private TableView<TableModel> tbViewCanzoni;

    @FXML
    private TableColumn<TableModel, String> tblColumnTitolo;

    @FXML
    private TableColumn<TableModel, String> tblColumnAutore;

    @FXML
    private TableColumn<TableModel, String> tblColumnAnno;

    @FXML
    Button btnGoBack;

    @FXML
    Label lblNomePlaylist;

    int userID = getUserId();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }

    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/PlaylistViewer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Visualizza playlist");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblNomePlaylist.setText(getNomePlaylist());

        //stampa di controllo
        System.out.println(getPlaylistId());

        try {
            //query per estrarre le canzoni di una specifica playlist
            ResultSet rs = PlaylistEntity.getSongs(getPlaylistId());
            ObservableList<TableModel> data;
            data = FXCollections.observableArrayList();

            while(rs.next()){
                data.add(new TableModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            tblColumnTitolo.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getTitolo());
            tblColumnAutore.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAutore());
            tblColumnAnno.setCellValueFactory(tableModelCanzoniIntegerCellDataFeatures -> tableModelCanzoniIntegerCellDataFeatures.getValue().getAnno());
            tbViewCanzoni.setItems(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Al click del bottone chiude la schermata della playlist e apre la schermata principale
     * @param actionEvent
     * @throws IOException
     */
    public void goBack(ActionEvent actionEvent) throws IOException {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.ShowMainView(); //viewFactory.showMainView(userId);
    }

    /**
     * Al click del bottone apre il prospetto delle emozioni per la canzone selezionata
     * @param actionEvent
     * @throws IOException
     */
    public void btnProspettoEmozioniClicked (ActionEvent actionEvent) throws IOException {
        TableModel tableModel = tbViewCanzoni.getSelectionModel().getSelectedItem();

        int canzoneId = (int) tableModel.getCanzoneId().getValue();
        String titolo = tableModel.getTitolo().get();
        String autore = tableModel.getAutore().get();
        int anno = (int) tableModel.getAnno().getValue();

        //stampe di controllo
        System.out.println(canzoneId);
        System.out.println(titolo);
        System.out.println(autore);
        System.out.println(anno);

        Model.GetInstance().GetViewFactory().ShowProspectView(canzoneId, titolo, autore, anno);
    }

}

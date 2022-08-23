package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.CanzoneEntity;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.PlaylistEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistEditorController extends Controller {

    // <editor-fold desc="Attributi FXML">
    public BorderPane borderPaneListCanzoniPlaylist;
    public Label lblNomePlaylist;
    @FXML
    private TableView<TableModel> tbViewCanzoni;
    @FXML
    private TableColumn<TableModel, String> tblColumnTitolo;
    @FXML
    private TableColumn<TableModel, String> tblColumnAutore;
    @FXML
    private TableColumn<TableModel, String> tblColumnAlbum;
    @FXML
    private TableColumn<TableModel, Integer> tblColumnAnno;
    @FXML
    private TableColumn<TableModel, Double> tblColumnDurata;
    @FXML
    private TableColumn<TableModel, String> tblColumnGenere;

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Loads the content of the view
     */
    @Override
    public void LoadContent() throws SQLException, IOException {


        CanzoneEntity canzoneEntity = new CanzoneEntity();
        ResultSet rs = null;
        ObservableList<TableModel> data;



        try {
            PlaylistModel playlistModel = PlaylistEntity.Read(getEntityId());

            if(!playlistModel.getNomePlaylist().isBlank())
                lblNomePlaylist.setText(playlistModel.getNomePlaylist());

            rs = canzoneEntity.allSongs(getEntityId(), getUserId());

            data = FXCollections.observableArrayList();

            while(rs.next()){
                data.add(new TableModel(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4), rs.getDouble(5),
                        rs.getString(6)));
            }

            tbViewCanzoni.setItems(data);

        } catch (SQLException | IOException e) {

            throw new RuntimeException(e);

        }
    }

    // </editor-fold>

}

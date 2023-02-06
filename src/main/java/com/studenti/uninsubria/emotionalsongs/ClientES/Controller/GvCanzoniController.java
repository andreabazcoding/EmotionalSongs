package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.CanzoneEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe controller per la view "GvCanzoni"
 * Mostra l' elenco di canzoni disponibili e permette la ricerca di un brano.
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */
public class GvCanzoniController extends Controller implements Initializable {
    public Button btnSvuota;

    // <editor-fold desc="Attributi FXML">

    @FXML
    private ComboBox cBoxAnno;
    @FXML
    TextField txtFieldRicercaTitolo, txtFieldRicercaAutore;
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
    @FXML
    private Button btnRicerca, btnSelezionaCanzone;

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Al click del bottone "Cerca" effettua la ricerca nel database.
     * @param evt
     */
    @FXML
    public void btnSearch(ActionEvent evt) {
        if((txtFieldRicercaTitolo.getText().trim().isEmpty() || txtFieldRicercaTitolo.getText() == null)
                && ((txtFieldRicercaAutore.getText().trim().isEmpty() || txtFieldRicercaAutore.getText() == null)
                || cBoxAnno.getSelectionModel().getSelectedItem() == null)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Attenzione");
            alert.setContentText("Popolare almeno uno dei due filtri");
            alert.showAndWait();
        }else{
            CanzoneEntity tmpEntity = new CanzoneEntity();
            ResultSet tmpSet = null;
            ObservableList<TableModel> filtData;
            int tmpValue = 0;

            try{
                if(cBoxAnno.getSelectionModel().getSelectedItem() != null)
                    tmpValue = (Integer) cBoxAnno. getSelectionModel().getSelectedItem();

                tmpSet = tmpEntity.getListByFilter(txtFieldRicercaTitolo.getText(), txtFieldRicercaAutore.getText(),tmpValue );

                filtData = FXCollections.observableArrayList();

                while(tmpSet.next()){

                    filtData.add(new TableModel(tmpSet.getInt(1), tmpSet.getString(2),tmpSet.getString(3),
                            tmpSet.getString(4),tmpSet.getInt(5), tmpSet.getDouble(6),
                            tmpSet.getString(7)));
                }

                tblColumnTitolo.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getTitolo());
                tblColumnAutore.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAutore());
                tblColumnAlbum.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAlbum());
                tblColumnAnno.setCellValueFactory(tableModelCanzoniIntegerCellDataFeatures -> tableModelCanzoniIntegerCellDataFeatures.getValue().getAnno());
                tblColumnDurata.setCellValueFactory(tableModelCanzoniDoubleCellDataFeatures -> tableModelCanzoniDoubleCellDataFeatures.getValue().getDurata());
                tblColumnGenere.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getGenere());

                tbViewCanzoni.setItems(filtData);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        CanzoneEntity canzoneEntity = new CanzoneEntity();

        ObservableList<Integer> options ;
        ResultSet rsOptions = null;
        try{
            rsOptions = canzoneEntity.distinctYear();
            options = FXCollections.observableArrayList();

            while(rsOptions.next()){
                options.add(rsOptions.getInt(1));
            }
            cBoxAnno.setItems(options);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        try {

            tblColumnTitolo.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getTitolo());
            tblColumnAutore.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAutore());
            tblColumnAlbum.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAlbum());
            tblColumnAnno.setCellValueFactory(tableModelCanzoniIntegerCellDataFeatures -> tableModelCanzoniIntegerCellDataFeatures.getValue().getAnno());
            tblColumnDurata.setCellValueFactory(tableModelCanzoniDoubleCellDataFeatures -> tableModelCanzoniDoubleCellDataFeatures.getValue().getDurata());
            tblColumnGenere.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getGenere());

            tbViewCanzoni.setItems(GetSongsDataList());

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addListeners() {
        btnRicerca.setOnAction(actionEvent -> btnSearch(actionEvent));
        btnSelezionaCanzone.setOnAction(actionEvent -> {
            try {
                btnProspettoEmozioniClicked(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnSvuota.setOnAction(actionEvent -> {
            try {
                btnSvuota(actionEvent);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    /**
     * Al click del bottone "Svuota" svuota i campi della ricerca.
     * @param actionEvent
     * @throws SQLException
     * @throws IOException
     */
    public void btnSvuota(ActionEvent actionEvent) throws SQLException, IOException {
        try {
            txtFieldRicercaAutore.setText("");
            txtFieldRicercaTitolo.setText("");
            tbViewCanzoni.setItems(GetSongsDataList());
        }
        catch (Exception ex){
            throw ex;
        }
    }

    /**
     * Estre dal database tutte le canzoni.
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public ObservableList<TableModel> GetSongsDataList() throws SQLException, IOException {
        CanzoneEntity canzoneEntity = new CanzoneEntity();
        ObservableList<TableModel> data = null;
        try {
            ResultSet rs = canzoneEntity.allSongs();
            data = FXCollections.observableArrayList();

            while(rs.next()){
                data.add(new TableModel(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5), rs.getDouble(6),
                        rs.getString(7)));
            }
        }
        catch (Exception ex){
            throw ex;
        }

        return data;
    }


    /**
     * Al click del bottone apre il prospetto delle emozioni per la canzone selezionata
     * @param actionEvent
     * @throws IOException
     */
    public void btnProspettoEmozioniClicked (ActionEvent actionEvent) throws IOException {

        TableModel tableModel = tbViewCanzoni.getSelectionModel().getSelectedItem();

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

            Model.GetInstance().GetViewFactory().ShowProspectView(canzoneId, titolo, autore, anno);
        }
    }

    public TableView getTbViewCanzoni() { return tbViewCanzoni; }

    @Override
    public void LoadContent() throws SQLException, IOException {

    }

    // </editor-fold>

}

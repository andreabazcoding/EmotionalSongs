package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

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
 *  Classe controller di "GvCanzoni"
 *  Mostra il prospetto delle canzoni
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

    // </editor-fold>

    // <editor-fold desc="Methods">

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

    @Override
    public void LoadContent() throws SQLException, IOException {

    }

    // </editor-fold>

}

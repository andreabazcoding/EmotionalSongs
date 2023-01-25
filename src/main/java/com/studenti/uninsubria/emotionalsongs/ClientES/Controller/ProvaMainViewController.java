package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.CanzoneEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProvaMainViewController extends Application implements Initializable{

    public TitledPane tPaneMain;
    @FXML
    private Label lblAccesso,lblRicercaTitolo,lblRicercaAutoreAnno;
    @FXML
    private Button btnCreaPlaylist,btnPlaylist,btnAccedi,btnRicerca;
    @FXML
    private ComboBox cBoxAnno;
    @FXML
    private VBox vBoxFunzioni;
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
    /**@FXML
    public void btnSearch(ActionEvent evt){

        /**if(!(txtFieldRicercaTitolo.getText().isBlank()) || !(txtFieldRicercaTitolo.getText().isEmpty())||txtFieldRicercaTitolo.getText() != null){
            CanzoneEntity tmpEntity = new CanzoneEntity();
            ResultSet tmpSet = null;
            ObservableList<TableModel> filtData;
            try{
                tmpSet = tmpEntity.searchingByTitle(txtFieldRicercaTitolo.getText());

                filtData = FXCollections.observableArrayList();

                while(tmpSet.next()){

                    filtData.add(new TableModel(tmpSet.getString(1),tmpSet.getString(2),
                            tmpSet.getString(3),tmpSet.getInt(4), tmpSet.getDouble(5),
                            tmpSet.getString(6)));
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
        if (!(TxtFieldRicercaAutore.getText().isBlank()) || !(TxtFieldRicercaAutore.getText().isEmpty()) || TxtFieldRicercaAutore.getText() != null && !(cBoxAnno.getSelectionModel().isEmpty())){
            CanzoneEntity tmpEntity = new CanzoneEntity();
            ResultSet tmpSet = null;
            ObservableList<TableModel> filtData;
            try{
                int tmpValue = (Integer) cBoxAnno. getSelectionModel().getSelectedItem();
                tmpSet = tmpEntity.searchingByAuthorAndYear(TxtFieldRicercaAutore.getText(),tmpValue);

                filtData = FXCollections.observableArrayList();

                while(tmpSet.next()){

                    filtData.add(new TableModel(tmpSet.getString(1),tmpSet.getString(2),
                            tmpSet.getString(3),tmpSet.getInt(4), tmpSet.getDouble(5),
                            tmpSet.getString(6)));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
     */

    @FXML
    public void btnSearch(ActionEvent evt){
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

                    filtData.add(new TableModel(tmpSet.getString(1),tmpSet.getString(2),
                            tmpSet.getString(3),tmpSet.getInt(4), tmpSet.getDouble(5),
                            tmpSet.getString(6)));
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResultSet rs = null;
        ObservableList<TableModel> data ;

        try {

            rs = canzoneEntity.allSongs();

            data = FXCollections.observableArrayList();

            while(rs.next()){
                data.add(new TableModel(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4), rs.getDouble(5),
                        rs.getString(6)));
            }

            tblColumnTitolo.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getTitolo());
            tblColumnAutore.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAutore());
            tblColumnAlbum.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getAlbum());
            tblColumnAnno.setCellValueFactory(tableModelCanzoniIntegerCellDataFeatures -> tableModelCanzoniIntegerCellDataFeatures.getValue().getAnno());
            tblColumnDurata.setCellValueFactory(tableModelCanzoniDoubleCellDataFeatures -> tableModelCanzoniDoubleCellDataFeatures.getValue().getDurata());
            tblColumnGenere.setCellValueFactory(tableModelCanzoniStringCellDataFeatures -> tableModelCanzoniStringCellDataFeatures.getValue().getGenere());

            tbViewCanzoni.setItems(data);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/ProvaMainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("EmotionalSongs");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}


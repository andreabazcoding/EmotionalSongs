package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.CanzoneEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GvCanzoniController extends Application implements Initializable {

    @FXML
    private TextField txtFieldTitolo,txtFieldAutoreAnno;
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

    CanzoneEntity canzoneEntity = new CanzoneEntity();

    private ResultSet rs = null;

    ObservableList<TableModel> data ;


    public GvCanzoniController() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/GvCanzoni.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

}

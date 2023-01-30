package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;


import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.EmozioniEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe controller per la view "EmozioniProvateView"
 * Mostra il prospetto delle emozioni riferito alla canzone selezionata precedentemente
 * @author Nour Faraj
 * @author Andrea Basilico
 */
public class EmozioniProvateController extends Application implements Initializable {

    // <editor-fold desc="Attributi FXML">
    @FXML
    TableView<TableModel> tbViewEmozioniProvate;
    @FXML
    TableColumn<TableModel, String> colEmozione;
    @FXML
    TableColumn<TableModel, Integer> colNumeroUtenti;
    @FXML
    TableColumn<TableModel, Integer> colMedia;

    @FXML
    Label lblCanzoneSelezionata;

    @FXML
    TextArea txtAreaRecCompleta;

    // </editor-fold>

    // <editor-fold desc="Attributi ">

    CanzoneModel canzoneModel = new CanzoneModel(1,"Don't Pan Me", "Alberta Hunter", null, 1922, 0.0, null);
    EmozioniEntity emozioniEntity = new EmozioniEntity();
    ObservableList<TableModel> data;
    ResultSet rs = null;

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * @param stage
     * @throws IOException
     * @throws SQLException
     */

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/EmozioniProvateView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Prospetto Emozioni");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Imposta il titolo della canzone selezionata e popola la tabella del prospetto emozioni con il resultset ritornato da emotionProspect()
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            lblCanzoneSelezionata.setText(canzoneModel.getTitolo()  + " - " + canzoneModel.getAutore());

            rs = emozioniEntity.EmotionProspect(canzoneModel.getCanzoneID());
            data = FXCollections.observableArrayList();

            while (rs.next()){
                data.add(new TableModel(rs.getString(1), rs.getInt(2), rs.getFloat(3)));
            }

           colEmozione.setCellValueFactory(tableModelStringCellDataFeatures -> tableModelStringCellDataFeatures.getValue().getEmozione());
           colNumeroUtenti.setCellValueFactory(tableModelIntegerCellDataFeatures -> tableModelIntegerCellDataFeatures.getValue().getNumeroUtenti());
           colMedia.setCellValueFactory(tableModelFloatCellDataFeatures -> tableModelFloatCellDataFeatures.getValue().getMedia());
           tbViewEmozioniProvate.setItems(data);

           txtAreaRecCompleta.setEditable(false);
           rs = emozioniEntity.getAllComments(canzoneModel.getCanzoneID());
            while (rs.next()) {
                String annotazione = rs.getString(1);
                txtAreaRecCompleta.appendText(annotazione + "\n"); }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // </editor-fold>

}

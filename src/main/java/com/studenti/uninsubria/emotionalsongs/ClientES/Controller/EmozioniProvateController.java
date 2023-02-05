package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;


import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.TableModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.View.ViewFactory;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.EmozioniEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
public class EmozioniProvateController extends Controller implements Initializable {

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


    public EmozioniProvateController() {

    }

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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/EmozioniProvateView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Prospetto Emozioni");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Popola la tabella del prospetto emozioni con il resultset ritornato da emotionProspect()
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            txtAreaRecCompleta.setEditable(false);
            lblCanzoneSelezionata.setText(getTitolo() + " - " + getAutore() + " - " + getAnno());

            rs = emozioniEntity.EmotionProspect(getCanzoneId());
            data = FXCollections.observableArrayList();

            if(!rs.next()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informazione");
                alert.setHeaderText(null);
                alert.setContentText("Non sono presenti feedback emozionali per questa canzone!");
                alert.showAndWait();
            } else {
                    do {
                    data.add(new TableModel(rs.getString(1), rs.getInt(2), rs.getFloat(3)));

                    colEmozione.setCellValueFactory(tableModelStringCellDataFeatures -> tableModelStringCellDataFeatures.getValue().getEmozione());
                    colNumeroUtenti.setCellValueFactory(tableModelIntegerCellDataFeatures -> tableModelIntegerCellDataFeatures.getValue().getNumeroUtenti());
                    colMedia.setCellValueFactory(tableModelFloatCellDataFeatures -> tableModelFloatCellDataFeatures.getValue().getMedia());
                    tbViewEmozioniProvate.setItems(data);

                     } while(rs.next());

                rs = emozioniEntity.getAllComments(getCanzoneId());
                while (rs.next()) {
                    String annotazione = rs.getString(1);
                    txtAreaRecCompleta.appendText(annotazione + "\n");
                     }
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // </editor-fold>

}

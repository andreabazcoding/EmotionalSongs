package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.EmozioneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.EmozioniEntity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

    /**
     * @author Nour Faraj
     * @author Andrea Basilico
     * La classe gestisce l' inserimento di un feedback emozionale da parte di un utente registrato;
     * l' utente inserisce l' emozione provata, l' intensità di tale emozione
     * ed eventualmente un commento opzionale.
     * Infine effettua il salvataggio del feedback sul database.
     */
    public class InserimentoEmozioneController implements Initializable {

        // <editor-fold desc="Attributi ">

        UtenteRegistratoModel utenteRegistratoModel = new UtenteRegistratoModel();
        EmozioneModel emozioneModel = new EmozioneModel();
        EmozioniEntity emozioniEntity = new EmozioniEntity();
        //da modificare
        CanzoneModel canzoneModel = new CanzoneModel(1,"The Twist", "Chubby Checker", "Twist With Chubby Checker", 1960, 155, "r&b");

        /**
         * Array contenente le 9 emozioni.
         */
        private String[] Emozioni = { "Stupore", "Solennità", "Tenerezza", "Nostalgia", "Calma", "Potere", "Gioia", "Tensione", "Tristezza" };

        // </editor-fold>

        // <editor-fold desc="Attributi FXML">

        /**
         * La ChoiceBox contenente le 9 emozioni selezionabili.
         */
        @FXML
        private ChoiceBox<String> CbEmozioni;

        /**
         *Il bottone Salva.
         */
        @FXML
        private Button btnSave;

        /**
         * Lo Slider per selezionare l' intensità dell' emozione.
         */
        @FXML
        private Slider Slider;

        /**
         * La Label che indica la canzone selezionata.
         */
        @FXML
        private Label lblCanzoneSelezionata;

        /**
         * La Label che conferma l' inserimento.
         */
        @FXML
        private Label lblConferma;

        /**
         * La TextArea per il commento opzionale.
         */
        @FXML
        private TextArea txtCommento;

        String Emozione, Commento;
        int Intensita;

        // </editor-fold>

        // <editor-fold desc="Methods ">

        /**
         * Inizializza la ChoiceBox e lo Slider, associandogli un listener per leggere il valore dell' intensità.
         * @param url
         * @param resourceBundle
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            lblCanzoneSelezionata.setText(canzoneModel.getAutore() + ", " + canzoneModel.getTitolo());
            CbEmozioni.getItems().addAll(Emozioni);
            CbEmozioni.setOnAction(this::leggiEmozione);
            Slider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    Intensita = (int) Slider.getValue();
                }
            });
        }

        /**
         * Legge l' emozione inserita nella ChoiceBox.
         * @param event
         */
        public void leggiEmozione(ActionEvent event){
            Emozione = CbEmozioni.getValue();
        }

        /**
         * Effettua l' inserimento del feedback emozionale sul database.
         * @throws SQLException
         * @throws IOException
         */
        public void salvaEmozione() throws SQLException, IOException {

            Commento = txtCommento.getText();
            int emozioneProvabileID = 0;

            switch (Emozione) {
                case "Stupore" :
                    emozioneProvabileID = 1;
                    break;

                case "Solennità" :
                    emozioneProvabileID = 2;
                    break;

                case "Tenerezza" :
                    emozioneProvabileID = 3;
                    break;

                case "Nostalgia" :
                    emozioneProvabileID = 4;
                    break;

                case "Calma" :
                    emozioneProvabileID = 5;
                    break;

                case "Potere" :
                    emozioneProvabileID = 6;
                    break;

                case "Gioia" :
                    emozioneProvabileID = 7;
                    break;

                case "Tensione" :
                    emozioneProvabileID = 8;
                    break;

                case "Tristezza" :
                    emozioneProvabileID = 9;
            }

            emozioneModel.setUtenteRegistratoID(4);   //emozioneModel.setUtenteRegistratoID(utenteRegistratoModel.getUtenteRegistratoID());
            emozioneModel.setCanzoneID(canzoneModel.getCanzoneID());
            emozioneModel.setEmozioneProvabileID(emozioneProvabileID);
            emozioneModel.setIntensità(Intensita);
            emozioneModel.setAnnotazioneEmozione(Commento);

            emozioniEntity.Create(emozioneModel);

            lblConferma.setVisible(true);
        }

        public void previousView() throws IOException {
        }

        // </editor-fold>

    }


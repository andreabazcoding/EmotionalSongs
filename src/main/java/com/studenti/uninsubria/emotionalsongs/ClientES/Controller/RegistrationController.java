package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.Main;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.UtenteRegistratoEntity;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.*;

/**
 * Classe controller per la view "RegistrationView"
 * Permette la registrazione dell'utente tramite compilazione dei campi
 * @author Nour Faraj
 * @author Andrea Basilico
 */

public class RegistrationController extends Controller {

    // <editor-fold desc="Attributi FXML">
    @FXML
    private TextField txtNome, txtCognome, txtCodiceFiscale, txtVia, txtNrCivico, txtComune, txtProvincia, txtCAP, txtUsername, txtEmail;
    @FXML
    private PasswordField passPassword;
    @FXML
    private Button btnIndietro, btnRegistrati;
    @FXML
    private Label lblError, lblConferma;
    @FXML
    private RadioButton rbtnVia;
    @FXML
    private RadioButton rbtnPiazza;

    // </editor-fold>

    // <editor-fold desc="Attributi">
    private UtenteRegistratoModel utenteRegistratoModel;
    private ConnectionFactory connectionFactory;
    private UtenteRegistratoEntity utenteRegistratoEntity;

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * @param stage
     * @throws IOException
     * @throws SQLException
     */
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/View/RegistrationView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registrazione utente");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Salva le informazioni inserite nell'istanza di UtenteRegistratoModel, controlla che tutti i campi siano compilati e ne verifica la sintassi
     * In caso contrario crea un'istanza di Alert che indica campi mancanti / sintassi errata
     * Se tutti i campi inseriti sono corretti viene chiamato il metodo registraUtente per eseguire l'inserimento nel database.
     * @param actionEvent
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    public void btnRegistratiClicked(ActionEvent actionEvent) throws SQLException, IOException {

        utenteRegistratoModel = new UtenteRegistratoModel();
        utenteRegistratoEntity = new UtenteRegistratoEntity();

        utenteRegistratoModel.setNome(txtNome.getText().trim());
        utenteRegistratoModel.setCognome(txtCognome.getText().trim());
        utenteRegistratoModel.setCodiceFiscale(txtCodiceFiscale.getText().trim());

        String via = txtVia.getText().trim();
        String nrCivico = txtNrCivico.getText().trim();
        String comune = txtComune.getText().trim();
        String provincia = txtProvincia.getText().trim();
        String cap = txtCAP.getText().trim();
        String indirizzo = via + " " + nrCivico + " " + comune + " " + provincia + " " + cap;

        utenteRegistratoModel.setIndirizzo(indirizzo);
        utenteRegistratoModel.setUsername(txtUsername.getText().trim());
        utenteRegistratoModel.setEmail(txtEmail.getText().trim());
        utenteRegistratoModel.setPassword(passPassword.getText().trim());

        if(utenteRegistratoModel.getNome().isBlank() || utenteRegistratoModel.getCognome().isBlank() || utenteRegistratoModel.getCodiceFiscale().isBlank() || via.isBlank() ||
             nrCivico.isBlank() || comune.isBlank()|| provincia.isBlank() || cap.isBlank()
             || utenteRegistratoModel.getUsername().isBlank() || utenteRegistratoModel.getEmail().isBlank() || utenteRegistratoModel.getPassword().isBlank()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText("Campi mancanti!");
                alert.setContentText("Assicurati di aver compilato tutti i campi.");
                alert.showAndWait();

        } else if (!isCodiceFiscale(utenteRegistratoModel.getCodiceFiscale())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Codice fiscale non valido!");
            alert.setContentText("Assicurati di aver inserito correttamente il codice fiscale.");
            alert.showAndWait();
        } else if (Integer.parseInt(cap) != 5) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Lunghezza del cap errata! Il cap deve essere di 5 cifre.");
            alert.setContentText("Assicurati di aver inserito correttamente il cap.");
            alert.showAndWait();
        } else if (!isEmail(utenteRegistratoModel.getEmail())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Indirizzo email non valido!");
            alert.setContentText("Assicurati di aver inserito correttamente l'indirizzo email.");
            alert.showAndWait();
        } else if (utenteRegistratoModel.getUsername().length() < 6 || utenteRegistratoModel.getUsername().length() > 30) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Username non valido!");
            alert.setContentText("Lo username deve essere lungo dai 6 ai 30 caratteri.");
            alert.showAndWait();
        } else if (utenteRegistratoModel.getPassword().length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Password troppo corta!");
            alert.setContentText("La password deve essere di almeno 8 caratteri.");
            alert.showAndWait();
        } else {
            if (registraUtente(utenteRegistratoEntity)) {
                System.out.println("LOG: L'utente è stato registrato correttamente");
                clearAll();
                lblConferma.setVisible(true);
                changeView("CreaPlaylist.fxml", getUserId());
            }
        }
    }

    /**
     * Richiama i metodi AuthenticateUser per l'autenticazioni con le credenziali e Create per l'inserimento delle informazioni nel database
     * Ritorna TRUE se esegue i metodi con successo
     * @param utenteRegistratoEntity
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public boolean registraUtente(UtenteRegistratoEntity utenteRegistratoEntity) throws SQLException, IOException {
        utenteRegistratoEntity.AuthenticateUser(utenteRegistratoModel.getUsername(), utenteRegistratoModel.getPassword());
        utenteRegistratoEntity.Create(utenteRegistratoModel);
        return true;
    }

    /**
     * Controlla la sintassi del codice fiscale utilizzando una regular expression.
     * Ritorna TRUE se il codice fiscale ha lo stesso pattern definito nel metodo.
     * @param codiceFiscale
     * @return
     */
    public boolean isCodiceFiscale(String codiceFiscale) {
        Pattern p = Pattern.compile("/^(?:[A-Z][AEIOU][AEIOUX]|[AEIOU]X{2}|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$/i\n");
        return p.matcher(codiceFiscale).matches();
    }

    /**
     * Controlla la sintassi dell'indirizzo email utilizzando una regular expression.
     * Ritorna TRUE se l'email ha lo stesso pattern definito nel metodo.
     * @param email
     * @return
     */
    public boolean isEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        return p.matcher(email).matches();
    }

    /**
     * Svuota tutti i campi precedentemente compilati.
     */
    public void clearAll(){
        txtNome.clear();
        txtCognome.clear();
        txtEmail.clear();
        txtUsername.clear();
        txtCodiceFiscale.clear();
        txtVia.clear();
        txtNrCivico.clear();
        txtComune.clear();
        txtProvincia.clear();
        txtCAP.clear();
        passPassword.clear();
    }

    /**
     * Loads the content of the view
     */
    @Override
    public void LoadContent() {

    }

    // </editor-fold>

}

package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.UtenteRegistratoEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */

public class LoginController extends Controller implements Initializable {

    // <editor-fold desc="Attributi FXML">
    @FXML
    private Label lblUsername, lblPassword,lblLoginMessage;
    @FXML
    private TextField txtFieldUsername;
    @FXML
    private PasswordField pssFieldPassword;
    @FXML
    private Button btnAccedi;

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Loads the content of the view
     */
    @Override
    public void LoadContent() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Controlla l'accesso dell'utente
     * @param e
     * @throws SQLException
     * @throws IOException
     */
    public void btnAccediClicked(ActionEvent e) throws SQLException, IOException {

        UtenteRegistratoEntity utenteRegistratoEntity = new UtenteRegistratoEntity();

        if(txtFieldUsername.getText().isBlank() && pssFieldPassword.getText().isBlank() ) {
            lblLoginMessage.setText("Inserisci username e password: ");
        }else if(utenteRegistratoEntity.AuthenticateUser(txtFieldUsername.getText(),pssFieldPassword.getText() )== 1){
            LoadMainView();
        }else{
            lblLoginMessage.setText("Username e/o password errati! ");
        }
    }

    private void LoadMainView() throws IOException {
        Stage stage = (Stage) txtFieldUsername.getScene().getWindow();
        Model.GetInstance().GetViewFactory().CloseStage(stage);
        Model.GetInstance().GetViewFactory().ShowMainView();
    }

    // </editor-fold>

}

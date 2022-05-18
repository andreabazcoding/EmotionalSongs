package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.UtenteRegistratoEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;


/**
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */

public class LoginController {

    @FXML
    private Label lblUsername, lblPassword;
    @FXML
    private TextField txtFieldUsername;
    @FXML
    private PasswordField pssFieldPassword;
    @FXML
    private Button btnAccedi,btnOspite;

    private UtenteRegistratoEntity utenteRegistratoEntity;
    private ConnectionFactory connectionFactory;

    /**
     * Verifica l'accesso: controlla la correttezza dei campi inseriti respetto i vincoli del Database
     *
     * @param event
     */
    public void btnAccediClicked(ActionEvent event) throws SQLException, IOException {

        if(btnAccedi.isPressed()){

            String username = txtFieldUsername.getText().trim();
            String password = pssFieldPassword.getText().trim();

            if(username.isBlank() || password.isBlank()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Campi mancanti, inserire username e password per accedere");
                alert.showAndWait();
            }

        }

    }

    public void btnOspiteClicked(ActionEvent event){

        if(btnOspite.isPressed()){

        }

    }

}

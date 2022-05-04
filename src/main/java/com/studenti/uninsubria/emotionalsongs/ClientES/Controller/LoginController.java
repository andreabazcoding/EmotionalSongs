package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;


/**
 * @author luqmanasghar
 */

public class LoginController {

    public TitledPane titledPaneEmotionaSongs;
    @FXML
    private Label lblUsername, lblPassword, lblError;
    @FXML
    private TextField txtFieldUsername, txtFieldPassword;
    @FXML
    private Button btnAccedi, btnRegistrati, btnOspite;

    private UtenteRegistratoModel utenteRegistratoModel;
    private ConnectionFactory connectionFactory;

    /**
     * Verifica l'accesso: controlla la correttezza dei campi inseriti respetto i vincoli del Database
     *
     * @param event
     */
    public void btnAccediClicked(ActionEvent event){

        //connesione DB

        String username = txtFieldUsername.getText().trim();
        String password = txtFieldPassword.getText().trim();

        if(username.isBlank() || password.isBlank()){
            lblError.setText("Campi mancanti, inserire username e password per accedere");
            return;
        }

        String query = "select *" +
                        "from UtentiRegistrati" +
                        "where username = '" + username +  "'and password ='" + password +"'";

        if(utenteRegistratoModel == null){
            lblError.setText("Credenziali errate, username e password non corrispondono a nessun utente registrato");
        }
        /**
         * else if(){
                // cambio scena
            }else{
                // cambio scena
            }
         */

        }


    /**
     * Permette la registrazione, agli utenti non ancora registrati
     *
     * @param event
     */
    public void btnRegistratiClicked(ActionEvent event){

    }

    /**
     * Permette di accedere come ospite
     *
     * @param event
     */
    public void btnOspiteClicked(ActionEvent event){

    }

    /**
     * Resetta i campi
     */
    public void reset(){

        txtFieldUsername.clear();
        txtFieldPassword.clear();

    }

}

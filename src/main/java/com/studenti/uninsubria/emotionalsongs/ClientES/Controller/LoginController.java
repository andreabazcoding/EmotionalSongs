package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author luqmanasghar
 */
public class LoginController {
    @FXML
    private Label LoginTitle;

    @FXML
    protected void onTestButtonClick() {
        LoginTitle.setText("Welcome to LoginController!");
    }
}

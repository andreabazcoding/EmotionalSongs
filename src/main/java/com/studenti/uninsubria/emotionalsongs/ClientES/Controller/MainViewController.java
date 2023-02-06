package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe controller per la view "MainView".
 * Gestisce la schermata principale che include altre due view: GvCanzoni e Menu
 * @author Asghar Luqman
 */
public class MainViewController extends Controller implements Initializable {

    public BorderPane mainViewParent;

    /**
     * Popola la MainView con la pane GvCanzoni permettendo di vedere la lista delle canzoni
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mainViewParent.setLeft(Model.GetInstance().GetViewFactory().GetMenuView(getUserId(), getUsername(), mainViewParent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //stampa prova
        System.out.println("User ID: " + getUserId());
    }

    /**
     * @throws SQLException
     * @throws IOException
     */
    @Override
    public void LoadContent() throws SQLException, IOException {

    }
}

package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

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
            mainViewParent.setLeft(Model.GetInstance().GetViewFactory().GetMenuView(getUserId(), mainViewParent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //stampa prova
        System.out.println("User ID: " + getUserId());
        /*
        Model.GetInstance().GetViewFactory().getSelectedMenuItem()
                .addListener((observableValue, oldVal, newVal) -> {
                    switch (newVal){
                        case "Playlist" -> mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvPlaylistView(getUserId()));
                        case "Accedi" -> {
                            try {
                                Stage stage = (Stage)mainViewParent.getScene().getWindow();
                                Model.GetInstance().GetViewFactory().CloseStage(stage);
                                Model.GetInstance().GetViewFactory().ShowLoginView();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        case "CreaPlaylist" -> {
                            try {
                                System.out.println("Case CreaPlaylist");
                                Stage stage = (Stage)mainViewParent.getScene().getWindow();
                                Model.GetInstance().GetViewFactory().CloseStage(stage);
                                Model.GetInstance().GetViewFactory().ShowEditPlaylistView(getUserId());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        default -> mainViewParent.setCenter(Model.GetInstance().GetViewFactory().GetGvCanzoniView());
                    }
                });

         */
    }

    /**
     * @throws SQLException
     * @throws IOException
     */
    @Override
    public void LoadContent() throws SQLException, IOException {

    }
}

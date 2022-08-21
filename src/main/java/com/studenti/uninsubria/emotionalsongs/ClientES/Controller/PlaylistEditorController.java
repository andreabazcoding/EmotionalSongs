package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlaylistEditorController extends Controller {
    public BorderPane borderPaneListCanzoniPlaylist;
    public Label lblNomePlaylist;

    /**
     * Loads the content of the view
     */
    @Override
    public void LoadContent() {
        LoadSubView(borderPaneListCanzoniPlaylist, "gvCanzoni.fxml");
    }
}

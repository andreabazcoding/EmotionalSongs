package com.studenti.uninsubria.emotionalsongs;

import com.studenti.uninsubria.emotionalsongs.ClientES.View.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Asghar Luqman
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.ShowMainView();
    }

    public static void main(String[] args) {
        launch();
    }
}
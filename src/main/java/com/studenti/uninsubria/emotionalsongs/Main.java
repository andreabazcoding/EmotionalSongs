package com.studenti.uninsubria.emotionalsongs;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

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
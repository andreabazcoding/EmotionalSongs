package com.studenti.uninsubria.emotionalsongs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/View/MainView.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
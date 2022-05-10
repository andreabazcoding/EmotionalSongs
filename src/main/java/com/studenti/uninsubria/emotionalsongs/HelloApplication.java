package com.studenti.uninsubria.emotionalsongs;

import com.studenti.uninsubria.emotionalsongs.ServerES.Entities.UtenteRegistratoEntity;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/View/Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        UtenteRegistratoEntity uteEntity = new UtenteRegistratoEntity();
        int res = uteEntity.AuthenticateUser("fsampi", "provaPass!");
        System.out.println(res);

    }

    public static void main(String[] args) {
        launch();
    }
}
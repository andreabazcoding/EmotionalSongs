package com.studenti.uninsubria.emotionalsongs.ClientES.View;

import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.EditPlaylistController;
import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.MainViewController;
import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.MenuController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author luqmanasghar
 */
public class ViewFactory {

    private final StringProperty SelectedMenuItem;
    private AnchorPane GvCanzoniView;
    private AnchorPane GvPlaylistView;
    private VBox MenuView;


    public ViewFactory(){
        this.SelectedMenuItem = new SimpleStringProperty("");
    }

    public AnchorPane GetGvCanzoniView() {
        if(GvCanzoniView == null){
            try{
                GvCanzoniView = new FXMLLoader(getClass().getResource("/View/GvCanzoni.fxml")).load();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return GvCanzoniView;
    }

    public AnchorPane GetGvPlaylistView() {
        if(GvPlaylistView == null){
            try{
                GvPlaylistView = new FXMLLoader(getClass().getResource("/View/GvPlaylist.fxml")).load();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return GvPlaylistView;
    }

    public VBox GetMenuView(int userId) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Menu.fxml"));
            MenuController menuController = new MenuController();
            menuController.setUserId(userId);
            loader.setController(menuController);
            MenuView = loader.load();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return MenuView;
    }

    public StringProperty getSelectedMenuItem() {
        return SelectedMenuItem;
    }

    public void ShowMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainView.fxml"));
        MainViewController mainViewController = new MainViewController();
        loader.setController(mainViewController);
        CreateStage(loader);
    }

    public void ShowMainView(int userId) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainView.fxml"));
        MainViewController mainViewController = new MainViewController();
        mainViewController.setUserId(userId);
        loader.setController(mainViewController);
        CreateStage(loader);
    }

    /**
     * Permette lo switch sulla view LoginView
     * @throws IOException
     */
    public void ShowLoginView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginView.fxml"));
        CreateStage(loader);
    }


    /**
     * Permette lo switch sulla view EditPlaylistView
     * @param userId
     * @throws IOException
     */
    public void ShowEditPlaylistView(int userId) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EditPlaylistView.fxml"));
        EditPlaylistController editPlaylistController = new EditPlaylistController();
        editPlaylistController.setUserId(userId);
        loader.setController(editPlaylistController);
        CreateStage(loader);
    }

    /**
     * Permetto lo switch sulla view RegistrationView
     * @throws IOException
     */
    public void ShowRegistrationView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/RegistrationView.fxml"));
        CreateStage(loader);
    }

    /**
     * Permetto lo switch sulla view GvPlaylist
     * @throws IOException
     */
    public void ShowPlaylistView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GvPlaylist.fxml"));
        CreateStage(loader);
    }

    /**
     * Permetto lo switch sulla view GvCanzoni
     * @throws IOException
     */
    public void ShowGvCanzoni() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GvCanzoni.fxml"));
        CreateStage(loader);
    }


    private void CreateStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void CloseStage(Stage stage) {
        stage.close();
    }
}

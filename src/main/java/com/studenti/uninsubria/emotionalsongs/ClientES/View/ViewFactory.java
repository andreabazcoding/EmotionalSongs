package com.studenti.uninsubria.emotionalsongs.ClientES.View;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.*;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe che gestisce il passaggio tra le diverse view.
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GvCanzoni.fxml"));
                GvCanzoniController gvCanzoniController = new GvCanzoniController();
                loader.setController(gvCanzoniController);
                GvCanzoniView = loader.load();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return GvCanzoniView;
    }

    public ArrayList<Object> GetGvCanzoniView(ArrayList<Object> arrayList) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GvCanzoni.fxml"));
            GvCanzoniController gvCanzoniController = new GvCanzoniController();
            loader.setController(gvCanzoniController);
            GvCanzoniView = loader.load();
            arrayList.add(gvCanzoniController);
            arrayList.add(GvCanzoniView);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return arrayList;
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

    public AnchorPane GetGvPlaylistView(int userId) {
        if(GvPlaylistView == null){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/GvPlaylist.fxml"));
                GvPlaylistController gvPlaylistController = new GvPlaylistController();
                gvPlaylistController.setUserId(userId);
                loader.setController(gvPlaylistController);
                GvPlaylistView = loader.load();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return GvPlaylistView;
    }

    public VBox GetMenuView(int userId, BorderPane mainViewParent) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Menu.fxml"));
            MenuController menuController = new MenuController();
            menuController.setMainViewParent(mainViewParent);
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
     * Permette lo switch sulla view PlaylistViewer
     * @param playlistId l' id della playlist selezionata
     * @param nomePlaylist il nome della playlist selezionata
     */
    public void ShowPlaylistViewer(int userId, int playlistId, String nomePlaylist) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PlaylistViewer.fxml"));
        PlaylistViewerController playlistViewerController = new PlaylistViewerController();
        playlistViewerController.setUserId(userId);
        playlistViewerController.setPlaylistId(playlistId);
        playlistViewerController.setNomePlaylist(nomePlaylist);
        loader.setController(playlistViewerController);
        CreateStage(loader);
    }


    /**
     * Permette lo switch sulla view EmozioniProvateView
     * @param titolo il titolo della canzone selezionata
     * @param autore l' autore della canzone selezionata
     * @param anno l' anno della canzone selezionata
     * @throws IOException
     */
    public void ShowProspectView(int canzoneId, String titolo, String autore, int anno) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EmozioniProvateView.fxml"));
        EmozioniProvateController emozioniProvateController = new EmozioniProvateController();

        emozioniProvateController.setCanzoneId(canzoneId);
        emozioniProvateController.setTitolo(titolo);
        emozioniProvateController.setAutore(autore);
        emozioniProvateController.setAnno(anno);
        loader.setController(emozioniProvateController);
        CreateStage(loader);
    }

    /**
     * Permette lo switch sulla view InserimentoEmozioneView
     * @param canzoneId l' Id della canzone selezionata
     * @param titolo il titolo della canzone selezionata
     * @param autore l' autore della canzone selezionata
     * @param anno l' anno della canzone selezionata
     * @param userId l' Id dell' utente corrente
     */
    public void ShowInserimentoEmozioneView(int canzoneId, String titolo, String autore, int anno, int userId) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/InserimentoEmozioneView.fxml"));
        InserimentoEmozioneController inserimentoEmozioneController = new InserimentoEmozioneController();

        inserimentoEmozioneController.setUserId(userId);
        inserimentoEmozioneController.setCanzoneId(canzoneId);
        inserimentoEmozioneController.setTitolo(titolo);
        inserimentoEmozioneController.setAutore(autore);
        inserimentoEmozioneController.setAnno(anno);
        loader.setController(inserimentoEmozioneController);
        CreateStage(loader);
    }

    /**
     * Permetto lo switch sulla view LoginView
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

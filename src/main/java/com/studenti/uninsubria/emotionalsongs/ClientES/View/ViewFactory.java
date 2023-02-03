package com.studenti.uninsubria.emotionalsongs.ClientES.View;

import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.EmozioniProvateController;
import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.MainViewController;
import com.studenti.uninsubria.emotionalsongs.ClientES.Controller.PlaylistViewerController;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author luqmanasghar
 */
public class ViewFactory {

    private final StringProperty SelectedMenuItem;
    private AnchorPane GvCanzoniView;
    private AnchorPane GvPlaylistView;


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


    public StringProperty getSelectedMenuItem() {
        return SelectedMenuItem;
    }

    public void ShowMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainView.fxml"));
        MainViewController mainViewController = new MainViewController();
        loader.setController(mainViewController);
        CreateStage(loader);
    }


    /**
     * Permette lo switch sulla view PlaylistViewer
     * @param playlistId l' id della playlist selezionata
     * @param nomePlaylist il nome della playlist selezionata
     */
    public void ShowPlaylistViewer(int playlistId, String nomePlaylist) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PlaylistViewer.fxml"));
        PlaylistViewerController playlistViewerController = new PlaylistViewerController();
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

        //stampe di controllo
        System.out.println(canzoneId);
        System.out.println(titolo);
        System.out.println(autore);
        System.out.println(anno);

        emozioniProvateController.setCanzoneId(canzoneId);
        emozioniProvateController.setTitolo(titolo);
        emozioniProvateController.setAutore(autore);
        emozioniProvateController.setAnno(anno);
        loader.setController(emozioniProvateController);
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

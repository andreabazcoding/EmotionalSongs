package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

/**
 * Gestisce i dati contenuti nella tabella del prospetto emozioni di una canzone
 * Gestisce i dati contenuti nella tabella di GvCanzoni
 * Gestisce i dati contenuti nella tabello di GvPlaylist
 *
 * @author Nour Faraj
 * @author Andrea Basilico
 * @author Cristian Zuffellato
 */
public class TableModel {

    // <editor-fold desc="Attributi">

    // necessari per tabella EmozioniProvateController
    private StringProperty emozione;
    private IntegerProperty numeroUtenti;
    private FloatProperty media;

    //necessari per tableview GvCanzoniController
    private StringProperty titolo;
    private StringProperty autore;
    private StringProperty album;
    private IntegerProperty anno;
    private DoubleProperty durata;
    private StringProperty genere;

    //necessari per tableview in GvPlaylistController
    private IntegerProperty playlistId;
    private StringProperty nomePlaylist;
    private StringProperty username;

    private IntegerProperty canzoneId;


    // </editor-fold>

    // <editor-fold desc="Costruttori">

    /**
     * Costruttore per TableModelEmozioni
     * @param emozione
     * @param numeroUtenti
     * @param media
     */
    public TableModel(String emozione, int numeroUtenti, float media) {
        this.emozione = new SimpleStringProperty(emozione);
        this.numeroUtenti = new SimpleIntegerProperty(numeroUtenti);
        this.media = new SimpleFloatProperty(media);
    }

    /**
     * Costruttore per TableModelCanzone
     * @param titolo
     * @param autore
     * @param album
     * @param anno
     * @param durata
     * @param genere
     */
    public TableModel(String titolo, String autore, String album, Integer anno, Double durata, String genere) {
        this.titolo = new SimpleStringProperty(titolo);
        this.autore = new SimpleStringProperty(autore);
        this.album = new SimpleStringProperty(album);
        this.anno = new SimpleIntegerProperty(anno);
        this.durata = new SimpleDoubleProperty(durata);
        this.genere = new SimpleStringProperty(genere);
    }


    /**
     * Costruttore per TableModelCanzone in PlaylistViewer
     * @param titolo
     * @param autore
     * @param anno
     */
    public TableModel(int CanzoneID, String titolo, String autore,  Integer anno) {
        this.canzoneId = new SimpleIntegerProperty(CanzoneID);
        this.titolo = new SimpleStringProperty(titolo);
        this.autore = new SimpleStringProperty(autore);
        this.anno = new SimpleIntegerProperty(anno);
    }


    /**
     * Costruttore per TableModelPlaylist
     * @param playlistId
     * @param nomePlaylist
     * @param username
     */
    public TableModel(Integer playlistId, String nomePlaylist, String username) {
        this.playlistId = new SimpleIntegerProperty(playlistId);
        this.nomePlaylist = new SimpleStringProperty(nomePlaylist);
        this.username = new SimpleStringProperty(username);
    }

    /**
     * Costruttore per TableModelCanzone
     * @param CanzoneId
     * @param titolo
     * @param autore
     * @param album
     * @param anno
     * @param durata
     * @param genere
     */
    public TableModel(int CanzoneId, String titolo , String autore, String album, int anno, double durata, String genere) {
        this.canzoneId = new SimpleIntegerProperty(CanzoneId);
        this.titolo = new SimpleStringProperty(titolo);
        this.album = new SimpleStringProperty(album);
        this.durata = new SimpleDoubleProperty(durata);
        this.genere = new SimpleStringProperty(genere);
        this.autore = new SimpleStringProperty(autore);
        this.anno = new SimpleIntegerProperty(anno);    }

    // </editor-fold>

    // <editor-fold desc="Getters&Setters">

    public StringProperty emozioneProperty() {
        return emozione;
    }

    public IntegerProperty utentiProperty() {
        return numeroUtenti;
    }

    public FloatProperty mediaProperty() {
        return media;
    }

    public IntegerProperty playlistIdProperty() {
        return playlistId;
    }

    /**
     * Legge playlistId
     * @return
     */
    public int getPlaylistId() { return playlistId.get(); }

    /**
     * Assegna playlistId
     * @param playlistId
     */
    public void setPlaylistId(int playlistId) { this.playlistId.set(playlistId); }

    /**
     * Assegna emozione
     * @param emozione
     */
    public void setEmozione(String emozione) {
        this.emozione.set(emozione);
    }

    /**
     * Assegna numeroUtenti
     * @param numeroUtenti
     */
    public void setNumeroUtenti(int numeroUtenti) {
        this.numeroUtenti.set(numeroUtenti);
    }

    /**
     * Assegna media
     * @param media
     */
    public void setMedia(int media) {
        this.media.set(media);
    }



    /**
     * Legge emozione
     * @return emozione
     */
    public StringProperty getEmozione() {
        return emozione;
    }

    /**
     * Legge numero utenti per emozione
     * @return numeroUtenti
     */
    public ObservableValue getNumeroUtenti() {
        return numeroUtenti;
    }

    /**
     * Legge media
     * @return media
     */
    public ObservableValue getMedia() {
        return media;
    }


    /**
     * legge il titolo
     * @return titolo
     */
    public StringProperty getTitolo() {
        return titolo;
    }

    /**
     * legge l'autore
     * @return autore
     */
    public StringProperty getAutore() {
        return autore;
    }

    /**
     * legge l'album
     * @return album
     */
    public StringProperty getAlbum() {
        return album;
    }

    /**
     * legge l'anno
     * @return anno
     */
    public ObservableValue getAnno() {
        return anno;
    }

    /**
     * legge la durata
     * @return durata
     */
    public ObservableValue getDurata() {
        return durata;
    }

    /**
     * legge il genere
     * @return genere
     */
    public StringProperty getGenere() {
        return genere;
    }

    /**
     * legge il nome della playlist
     * @return nomePlaylist
     */
    public StringProperty getNomePlaylist() { return nomePlaylist; }

    /**
     * legge l'username
      * @return username
     */
    public StringProperty getUsername() { return username; }


    public ObservableValue getCanzoneId() {
        return canzoneId;
    }

    // </editor-fold>

}

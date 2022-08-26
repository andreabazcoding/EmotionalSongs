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
     * @return
     */
    public StringProperty getEmozione() {
        return emozione;
    }

    /**
     * Legge numeroUtenti
     * @return
     */
    public ObservableValue getNumeroUtenti() {
        return numeroUtenti;
    }

    /**
     * Legge media
     * @return
     */
    public ObservableValue getMedia() {
        return media;
    }

    /**
     * legge il titolo
     * @return
     */
    public StringProperty getTitolo() {
        return titolo;
    }

    /**
     * legge l'autore
     * @return
     */
    public StringProperty getAutore() {
        return autore;
    }

    /**
     * legge l'album
     * @return
     */
    public StringProperty getAlbum() {
        return album;
    }

    /**
     * legge il'anno
     * @return
     */
    public ObservableValue getAnno() {
        return anno;
    }

    /**
     * legge la durata
     * @return
     */
    public ObservableValue getDurata() {
        return durata;
    }

    /**
     * legge il genere
     * @return
     */
    public StringProperty getGenere() {
        return genere;
    }

    /**
     * legge il nome della playlist
     * @return
     */
    public StringProperty getNomePlaylist() { return nomePlaylist; }

    /**
     * legge l'username
      * @return
     */
    public StringProperty getUsername() { return username; }

    // </editor-fold>

}

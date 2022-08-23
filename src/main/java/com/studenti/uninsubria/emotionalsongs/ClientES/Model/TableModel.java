package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

/**
 * Gestisce i dati contenuti nella tabella del prospetto emozioni di una canzone
 * @author Nour Faraj
 * @author Andrea Basilico
 */
public class TableModel {

    // <editor-fold desc="Attributi">
    private StringProperty emozione;
    private IntegerProperty numeroUtenti;
    private FloatProperty media;

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

    public TableModel(String titolo, String autore, String album, Integer anno, Double durata, String genere) {
        this.titolo = new SimpleStringProperty(titolo);
        this.autore = new SimpleStringProperty(autore);
        this.album = new SimpleStringProperty(album);
        this.anno = new SimpleIntegerProperty(anno);
        this.durata = new SimpleDoubleProperty(durata);
        this.genere = new SimpleStringProperty(genere);
    }

    public TableModel(/*Integer playlistId,*/ String nomePlaylist, String username) {
        //this.playlistId = new SimpleIntegerProperty(playlistId);
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

    public StringProperty getTitolo() {
        return titolo;
    }

    public StringProperty getAutore() {
        return autore;
    }

    public StringProperty getAlbum() {
        return album;
    }

    public ObservableValue getAnno() {
        return anno;
    }

    public ObservableValue getDurata() {
        return durata;
    }

    public StringProperty getGenere() {
        return genere;
    }

    public StringProperty getNomePlaylist() { return nomePlaylist; }
    public StringProperty getUsername() { return username; }

    // </editor-fold>

}

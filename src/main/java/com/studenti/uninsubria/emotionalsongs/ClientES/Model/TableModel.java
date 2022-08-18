package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

/**
 * Gestisce i dati contenuti nella tabella del prospetto emozioni di una canzone
 * @author Nour Faraj
 * @author Andrea Basilico
 */
public class TableModel {

    private StringProperty emozione;
    private IntegerProperty numeroUtenti;
    private FloatProperty media;

    /**
     * Costruttore
     * @param emozione
     * @param numeroUtenti
     * @param media
     */
    public TableModel(String emozione, int numeroUtenti, float media) {
        this.emozione = new SimpleStringProperty(emozione);
        this.numeroUtenti = new SimpleIntegerProperty(numeroUtenti);
        this.media = new SimpleFloatProperty(media);
    }

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
}

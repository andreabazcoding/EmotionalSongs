package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class TableModel {

    private StringProperty emozione;
    private IntegerProperty numeroUtenti;
    private FloatProperty media;

    public TableModel(String emozione, int numeroUtenti, float media) {
        this.emozione = new SimpleStringProperty(emozione);
        this.numeroUtenti = new SimpleIntegerProperty(numeroUtenti);
        this.media = new SimpleFloatProperty(media);
    }

    public TableModel() {

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


    public void setEmozione(String emozione) {
        this.emozione.set(emozione);
    }

    public void setNumeroUtenti(int numeroUtenti) {
        this.numeroUtenti.set(numeroUtenti);
    }

    public void setMedia(int media) {
        this.media.set(media);
    }

    public StringProperty getEmozione() {
        return emozione;
    }

    public ObservableValue getNumeroUtenti() {
        return numeroUtenti;
    }

    public ObservableValue getMedia() {
        return media;
    }
}

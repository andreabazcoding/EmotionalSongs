package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

public class EmozioneModel {

    // <editor-fold desc="Attributi">
    private int emozioneID;
    private int utenteRegistratoID;
    private int canzoneID;
    private int emozioneProvabileID;
    private int intensità;
    private String annotazioneEmozione;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public EmozioneModel() {

    }

    public EmozioneModel(int emozioneID, int utenteRegistratoID, int canzoneID, int emozioneProvabileID, int intentità, String annotazioneEmozione) {

        this.emozioneID = emozioneID;
        this.utenteRegistratoID = utenteRegistratoID;
        this.canzoneID = canzoneID;
        this.emozioneProvabileID = emozioneProvabileID;
        this.intensità = intentità;
        this.annotazioneEmozione = annotazioneEmozione;

    }

    // </editor-fold>

    // <editor-fold desc="Getters & Setters">

    /**
     * Legge emozioneID
     * @return
     */
    public int getEmozioneID() {
        return emozioneID;
    }

    /**
     * assegna emozioneID
     * @param emozioneID
     */
    public void setEmozioneID(int emozioneID) {
        this.emozioneID = emozioneID;
    }

    /**
     * legge utenteRegistratoID
     * @return
     */
    public int getUtenteRegistratoID() {
        return utenteRegistratoID;
    }

    /**
     * Assegna utenteRegistratoID
     * @param utenteRegistratoID
     */
    public void setUtenteRegistratoID(int utenteRegistratoID) {
        this.utenteRegistratoID = utenteRegistratoID;
    }

    /**
     * Legge canzoneID
     * @return
     */
    public int getCanzoneID() {
        return canzoneID;
    }

    /**
     * Assegna canzoneID
     * @param canzoneID
     */
    public void setCanzoneID(int canzoneID) {
        this.canzoneID = canzoneID;
    }

    /**
     * Legge emozioneProvabileID
     * @return
     */
    public int getEmozioneProvabileID() {
        return emozioneProvabileID;
    }

    /**
     * Assegna emozioneProvabileID
     * @param emozioneProvabileID
     */
    public void setEmozioneProvabileID(int emozioneProvabileID) {
        this.emozioneProvabileID = emozioneProvabileID;
    }

    /**
     * Legge intesità
     * @return
     */
    public int getIntensità() {
        return intensità;
    }

    /**
     * Assegna intesità
     * @param intensità
     */
    public void setIntensità(int intensità) {
        this.intensità = intensità;
    }

    /**
     * Legge annotazioneEmozione
     * @return
     */
    public String getAnnotazioneEmozione() {
        return annotazioneEmozione;
    }

    /**
     * Assegna annotazioneEmozione
     * @param annotazioneEmozione
     */
    public void setAnnotazioneEmozione(String annotazioneEmozione) {
        this.annotazioneEmozione = annotazioneEmozione;
    }

    // </editor-fold>

}

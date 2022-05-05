package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

public class EmozioneModel {

    // <editor-fold desc="Attributi">

    private short emozioneID;
    private short utenteRegistratoID;
    private short canzoneID;
    private short emozioneProvabileID;
    private short intensità;
    private String annotazioneEmozione;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public EmozioneModel() {

    }

    public EmozioneModel(short emozioneID, short utenteRegistratoID, short canzoneID, short emozioneProvabileID, short intentità, String annotazioneEmozione) {

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

    public short getEmozioneID() {
        return emozioneID;
    }

    /**
     * assegna emozioneID
     * @param emozioneID
     */

    public void setEmozioneID(short emozioneID) {
        this.emozioneID = emozioneID;
    }

    /**
     * legge utenteRegistratoID
     * @return
     */

    public short getUtenteRegistratoID() {
        return utenteRegistratoID;
    }

    /**
     * Assegna utenteRegistratoID
     * @param utenteRegistratoID
     */

    public void setUtenteRegistratoID(short utenteRegistratoID) {
        this.utenteRegistratoID = utenteRegistratoID;
    }

    /**
     * Legge canzoneID
     * @return
     */

    public short getCanzoneID() {
        return canzoneID;
    }

    /**
     * Assegna canzoneID
     * @param canzoneID
     */

    public void setCanzoneID(short canzoneID) {
        this.canzoneID = canzoneID;
    }

    /**
     * Legge emozioneProvabileID
     * @return
     */

    public short getEmozioneProvabileID() {
        return emozioneProvabileID;
    }

    /**
     * Assegna emozioneProvabileID
     * @param emozioneProvabileID
     */

    public void setEmozioneProvabileID(short emozioneProvabileID) {
        this.emozioneProvabileID = emozioneProvabileID;
    }

    /**
     * Legge intesità
     * @return
     */

    public short getIntensità() {
        return intensità;
    }

    /**
     * Assegna intesità
     * @param intensità
     */

    public void setIntensità(short intensità) {
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

package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

/**
 * Classe per gestire le 9 emozioni provabili.
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */
public class EmozioneProvabileModel {

    // <editor-fold desc="Attributi">
    private int emozioneID;
    private String nomeEmozione;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public EmozioneProvabileModel() {

    }

    public EmozioneProvabileModel(int emozioneID, String nomeEmozione) {
        this.emozioneID = emozioneID;
        this.nomeEmozione = nomeEmozione;
    }

    // </editor-fold>

    // <editor-fold desc="Getters & Setters">

    /**
     * Legge emozioniID
     * @return
     */
    public int getEmozioneID() {
        return emozioneID;
    }

    /**
     * Assegna emozioniID
     * @param emozioneID
     */
    public void setEmozioneID(int emozioneID) {
        this.emozioneID = emozioneID;
    }

    /**
     * Legge nomeEmozione
     * @return
     */
    public String getNomeEmozione() {
        return nomeEmozione;
    }

    /**
     * Assegna nomeEmozione
     * @param nomeEmozione
     */
    public void setNomeEmozione(String nomeEmozione) {
        this.nomeEmozione = nomeEmozione;
    }

    // </editor-fold>

}

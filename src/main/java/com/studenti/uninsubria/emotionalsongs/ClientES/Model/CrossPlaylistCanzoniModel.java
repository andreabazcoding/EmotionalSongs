package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

public class CrossPlaylistCanzoniModel {

    // <editor-fold desc="Attributi">
    private int crossPlaylistCanzoniID;
    private int canzoneID;
    private int playlistID;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public CrossPlaylistCanzoniModel() {
    }

    public CrossPlaylistCanzoniModel(int crossPlaylistCanzoniID, int canzoneID, int playlistID) {
        this.crossPlaylistCanzoniID = crossPlaylistCanzoniID;
        this.canzoneID = canzoneID;
        this.playlistID = playlistID;
    }

    // </editor-fold>

    // <editor-fold desc="Getters & Setters">

    /**
     * Legge crossPlaylistCanzoniID
     * @return
     */
    public int getCrossPlaylistCanzoniID() {
        return crossPlaylistCanzoniID;
    }

    /**
     * Assegna crossPlaylistCanzoniID
     * @param crossPlaylistCanzoniID
     */
    public void setCrossPlaylistCanzoniID(int crossPlaylistCanzoniID) {
        this.crossPlaylistCanzoniID = crossPlaylistCanzoniID;
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
     * Legge playlistID
     * @return
     */
    public int getPlaylistID() {
        return playlistID;
    }

    /**
     * Assegna playlistID
     * @param playlistID
     */
    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    // </editor-fold>

}

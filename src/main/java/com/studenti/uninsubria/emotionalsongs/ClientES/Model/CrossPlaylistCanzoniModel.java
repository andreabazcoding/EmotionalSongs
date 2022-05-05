package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

public class CrossPlaylistCanzoniModel {

    // <editor-fold desc="Attributi">

    private short crossPlaylistCanzoniID;
    private short canzoneID;
    private short playlistID;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public CrossPlaylistCanzoniModel() {

    }

    public CrossPlaylistCanzoniModel(short crossPlaylistCanzoniID, short canzoneID, short playlistID) {
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

    public short getCrossPlaylistCanzoniID() {
        return crossPlaylistCanzoniID;
    }

    /**
     * Assegna crossPlaylistCanzoniID
     * @param crossPlaylistCanzoniID
     */

    public void setCrossPlaylistCanzoniID(short crossPlaylistCanzoniID) {
        this.crossPlaylistCanzoniID = crossPlaylistCanzoniID;
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
     * Legge playlistID
     * @return
     */

    public short getPlaylistID() {
        return playlistID;
    }

    /**
     * Assegna playlistID
     * @param playlistID
     */

    public void setPlaylistID(short playlistID) {
        this.playlistID = playlistID;
    }

    // </editor-fold>

}

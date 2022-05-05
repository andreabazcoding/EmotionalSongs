package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

public class PlaylistModel {

    // <editor-fold desc="Attributi">

    private short playlistID;
    private String nomePlaylist;
    private short utenteRegistratoID;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public PlaylistModel() {

    }

    public PlaylistModel(short playlistID, String nomePlaylist, short utenteRegistratoID) {
        this.playlistID = playlistID;
        this.nomePlaylist = nomePlaylist;
        this.utenteRegistratoID = utenteRegistratoID;
    }

    // </editor-fold>

    // <editor-fold desc="Getters & Setters">

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

    /**
     * Legge nomePlaylist
     * @return
     */

    public String getNomePlaylist() {
        return nomePlaylist;
    }


    /**
     * Assegna nomePlaylist
     * @param nomePlaylist
     */

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }


    /**
     * Legge utenteRegistrato
     * @return
     */

    public short getUtenteRegistratoID() {
        return utenteRegistratoID;
    }


    /**
     * Assegna utenteRegistratoID
     * @param utenteRegistratoID
     */

    public void setUtenteRegistrato(short utenteRegistratoID) {
        this.utenteRegistratoID = utenteRegistratoID;
    }

    // </editor-fold>

}

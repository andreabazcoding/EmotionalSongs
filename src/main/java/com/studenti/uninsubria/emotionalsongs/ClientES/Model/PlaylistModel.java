package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

/**
 * Classe per gestire le playlist.
 * @author Asghar Luqman
 */
public class PlaylistModel {

    // <editor-fold desc="Attributi">
    private int playlistID;
    private String nomePlaylist;
    private int utenteRegistratoID;

    // </editor-fold>

    // <editor-fold desc="Costruttori">
    public PlaylistModel() {

    }

    public PlaylistModel(int playlistID, String nomePlaylist, int utenteRegistratoID) {
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

    // </editor-fold>

}

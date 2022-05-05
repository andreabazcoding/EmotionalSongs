package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

/**
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */
public class CanzoneModel {

    // <editor-fold desc="Attributi">

    private short canzoneID;
    private String titolo;
    private String autore;
    private String album;
    private short anno;
    private int durata;
    private String genere;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public CanzoneModel() {

    }

    public CanzoneModel(short canzoneID, String titolo, String autore, String album, short anno, int durata, String genere) {

        this.canzoneID = canzoneID;
        this.titolo = titolo;
        this.autore = autore;
        this.album = album;
        this.anno = anno;
        this.durata = durata;
        this.genere = genere;

    }

    // </editor-fold>

    // <editor-fold desc="Getters & Setters">


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
     * Legge titolo
     * @return
     */

    public String getTitolo() {
        return titolo;
    }


    /**
     * Assegna titolo
     * @param titolo
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     *Legge autore
     * @return
     */

    public String getAutore() {
        return autore;
    }


    /**
     * Assegna autore
     * @param autore
     */

    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * Legge album
     * @return
     */

    public String getAlbum() {
        return album;
    }

    /**
     * Assegna album
     * @param album
     */

    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Legge anno
     * @return
     */

    public short getAnno() {
        return anno;
    }

    /**
     * Assegna album
     * @param anno
     */

    public void setAnno(short anno) {
        this.anno = anno;
    }

    /**
     * Legge durata
     * @return
     */

    public int getDurata() {
        return durata;
    }

    /**
     * Assegna durata
     * @param durata
     */

    public void setDurata(int durata) {
        this.durata = durata;
    }

    /**
     * Legge genere
     * @return
     */

    public String getGenere() {
        return genere;
    }

    /**
     * Assegna genere
     * @param genere
     */

    public void setGenere(String genere) {
        this.genere = genere;
    }

    // </editor-fold>

}

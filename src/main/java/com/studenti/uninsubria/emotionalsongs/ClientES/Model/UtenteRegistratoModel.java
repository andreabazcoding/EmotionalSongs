package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

/**
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */
public class UtenteRegistratoModel {

    // <editor-fold desc="Attributi">
    private int utenteRegistratoID;
    private java.lang.String nome;
    private java.lang.String cognome;
    private String indirizzo;
    private java.lang.String email;
    private java.lang.String username;
    private java.lang.String password;

    private String codiceFiscale;

    // </editor-fold>

    // <editor-fold desc="Costruttori">
    public UtenteRegistratoModel() {

    }

    public UtenteRegistratoModel(int utenteRegistratoID, java.lang.String nome, java.lang.String cognome,String codiceFiscale, String indirizzo, java.lang.String email, java.lang.String username, java.lang.String password) {

        this.utenteRegistratoID = utenteRegistratoID;
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.email = email;
        this.username = username;
        this.password = password;

    }
    // </editor-fold>

    // <editor-fold desc="Getters & Setters">

    /**
     * Legge utenteRegistratoID
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
     * Legge nome
     * @return
     */
    public java.lang.String getNome() {
        return nome;
    }

    /**
     * Assegna nome
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    /**
     * Legge cognome
     * @return
     */
    public java.lang.String getCognome() {
        return cognome;
    }

    /**
     * Assegna cognome
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }

    /**
     * Legge codiceFiscale
     * @return
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Assegna codiceFiscale
     * @param codiceFiscale
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Legge indirizzo
     * @return
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Assegna indirizzo
     * @param string
     */
    public void setIndirizzo(String string) {
        this.indirizzo = string;
    }

    /**
     * Legge email
     * @return
     */
    public java.lang.String getEmail() {
        return email;
    }

    /**
     * Assegna email
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    /**
     * Legge username
     * @return
     */
    public java.lang.String getUsername() {
        return username;
    }

    /**
     * Assegna username
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    /**
     * Legge username
     * @return
     */
    public java.lang.String getPassword() {
        return password;
    }

    /**
     * Assegna password
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    // </editor-fold>

}

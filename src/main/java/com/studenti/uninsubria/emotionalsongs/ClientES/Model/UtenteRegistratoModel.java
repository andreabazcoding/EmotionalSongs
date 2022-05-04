package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

public class UtenteRegistratoModel {

    // <editor-fold desc="Attributes">
    private short utenteRegistratoID;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String email;
    private String username;
    private String password;
    // </editor-fold>

    // <editor-fold desc="Costruttori">
    public UtenteRegistratoModel() {

    }

    public UtenteRegistratoModel(short utenteRegistratoID, String nome, String cognome, String indirizzo, String email, String username, String password) {

        this.utenteRegistratoID = utenteRegistratoID;
        this.nome = nome;
        this.cognome = cognome;
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
     * Legge nome
     * @return
     */

    public String getNome() {
        return nome;
    }

    /**
     * Assegna nome
     * @param nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Legge cognome
     * @return
     */

    public String getCognome() {
        return cognome;
    }

    /**
     * Assegna cognome
     * @param cognome
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
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
     * @param indirizzo
     */

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Legge email
     * @return
     */

    public String getEmail() {
        return email;
    }

    /**
     * Assegna email
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Legge username
     * @return
     */

    public String getUsername() {
        return username;
    }

    /**
     * Assegna username
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Legge username
     * @return
     */

    public String getPassword() {
        return password;
    }

    /**
     * Assegna password
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    // </editor-fold>

}

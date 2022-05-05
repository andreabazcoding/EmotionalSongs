package com.studenti.uninsubria.emotionalsongs.ClientES.Utility;

/**
 * @author Asghar Luqman
 * @author Zuffellato Cristian
 */

public class Indirizzo {

    // <editor-fold desc="Attributi">

    private Qualificatore qualificatore;
    private String via;
    private String civico;
    private String comune;
    private String provincia;
    private String cap;

    // </editor-fold>

    // <editor-fold desc="Costruttori">

    public Indirizzo() {

    }

    public Indirizzo(Qualificatore qualificatore, String via, String civico, String comune, String provincia, String cap) {

        this.qualificatore = qualificatore;
        this.via = via;
        this.civico = civico;
        this.comune = comune;
        this.provincia = provincia;

        /**
         * Controlla che il cap sia maggiore di 9 (cap con numerazione più bassa è 00010),
         * inoltre guarda se supera 98168 (cap con numerazione più alta è 98168)
         * ed infine controlla la lunghezza che non deve essere superiore a 5
         */

        if(Integer.parseInt(cap) > 9 && Integer.parseInt(cap) < 98168 && cap.length() == 5)
            this.cap = cap;
        else
            this.cap = "00010";

    }

    // </editor-fold>

    // <editor-fold desc="Getters & Setters">

    /**
     * Legge qualificatore
     * @return
     */

    public Qualificatore getQualificatore() {
        return qualificatore;
    }

    /**
     * Assegna qualificatore
     * @return
     */

    public void setQualificatore(Qualificatore qualificatore) {
        this.qualificatore = qualificatore;
    }

    /**
     * Legge via
     * @return
     */

    public String getVia() {
        return via;
    }

    /**
     * Assegna via
     * @param via
     */

    public void setVia(String via) {
        this.via = via;
    }

    /**
     * Legge civico
     * @return
     */

    public String getCivico() {
        return civico;
    }

    /**
     * Assegna civico
     * @param civico
     */

    public void setCivico(String civico) {
        this.civico = civico;
    }

    /**
     * Legge comune
     * @return
     */

    public String getComune() {
        return comune;
    }


    /**
     * Assegna comune
     * @param comune
     */

    public void setComune(String comune) {
        this.comune = comune;
    }

    /**
     * Legge provincia
     * @return
     */

    public String getProvincia() {
        return provincia;
    }

    /**
     * Assegna provincia
     * @param provincia
     */

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Legge cap
     * @return
     */

    public String getCap() {
        return cap;
    }

    /**
     * Assegna cap
     * @param cap
     */

    public void setCap(String cap) {
        this.cap = cap;
    }

    // </editor-fold>

}

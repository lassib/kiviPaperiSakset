
package com.laatu.kivipaperisakset;

/**
 * Pelaaja-luokka sisältää pelaajan valinnan ja voittamisen tarkistuksen, sekä pelaajan voittojen määrän.
 * @author Ira Dook
 * @author Lassi Bågman
 */
public class Pelaaja {

    private int voitotYhteensä; // Pelaajan voitot yhteensä

    /**
     * Luo uuden pelaajan
     */
    public Pelaaja() {
        this.voitotYhteensä = 0;
    }

    /**
     * Valitse randomilla kivi, paperi tai sakset
     * @return valinta (kivi, paperi tai sakset)
     */
    public String pelaajanValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    /**
     * Tarkista voittiko pelaaja 1 vai 2
     * @param p1Valinta pelaajan 1 valinta
     * @param p2Valinta pelaajan 2 valinta
     * @return voittiko pelaaja 1 (true/false)
     */
    public boolean voittiko(String p1Valinta, String p2Valinta) {
        boolean voittiko = false;
        if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("sakset"))) {
            voittiko = true;
        } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("paperi"))) {
            voittiko = true;
        } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("kivi"))) {
            voittiko = true;
        }
        return voittiko;
    }

    /**
     * Lisää pelaajan voittoihin yhden
     */
    public void setVoitot() {
        voitotYhteensä++;
    }

    /**
     * Palauta pelaajan voitot
     * @return pelaajan voitot
     */
    public int getVoitot() {
        return (voitotYhteensä);
    }
}

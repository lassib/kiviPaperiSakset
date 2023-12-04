
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
    public String getValinta() {
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
     * Lisää pelaajan voittoihin yhden
     */
    public void addVoitto() {
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

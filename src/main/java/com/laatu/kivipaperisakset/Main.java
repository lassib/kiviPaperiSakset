package com.laatu.kivipaperisakset;

/**
 * Main-luokka, joka luo kaksi pelaajaa ja pelin ja pelaa uuden pelin niin kauan kunnes peli ohi ehto täyttyy.
 * @see Pelaaja
 * @see Peli
 * @auhtor Ira Dook
 * @auhtor Lassi Bågman
 * @version 0.2
 */
public class Main {

    /**
     * Main-metodi, sovelluksen aloituskohta.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Peli peli = new Peli(p1, p2);

        while (peli.getPeliLoppui() == false) {
            peli.pelaa();
        }
    }
}

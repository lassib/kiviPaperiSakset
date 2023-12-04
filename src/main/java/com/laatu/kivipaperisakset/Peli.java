package com.laatu.kivipaperisakset;

/**
 *
 * Peli-luokka sisältää pelin kulun ja tulosten päivittämisen, sekä pelin lopettamisen tarkistuksen.
 * Peli loppuu kun jompikumpi pelaajista saavuttaa kolme voittoa.
 * @see Pelaaja
 * @see Peli
 * @author Ira Dook
 * @author Lassi Bågman
 * @version 0.2
 */
public class Peli {
    private Pelaaja p1;
    private Pelaaja p2;
    private int pelatutPelit;           // Pelattujen pelien lkm
    private int tasapelit;              // Tasapelien lkm

    /**
     * Luo uuden pelin pelaajille 1 ja 2
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     */
    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.pelatutPelit = 0;
        this.tasapelit = 0;
    }

    /**
     * Pelaa yhden erän lukiten pelaajien valinnat ja päivittää tilanteen.
     */
    public void pelaa() {
        String p1Valinta = "";
        String p2Valinta = "";

        if (pelatutPelit == 0) {
            System.out.println("\n\t\tPeli alkaa!");
        } else {
            System.out.println("\n\t\tPeli jatkuu!");
        }
        System.out.println("Erä: " + (pelatutPelit += 1) + " =====================\n");

        p1Valinta = p1.pelaajanValinta();
        p2Valinta = p2.pelaajanValinta();

        System.out.println("Pelaaja 1: " + p1Valinta);
        System.out.println("Pelaaja 2: " + p2Valinta);

        kumpiVoitti(p1Valinta, p2Valinta);

        System.out.println("Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
        System.out.println("Tasapelien määrä: " + tasapelit + "\n");
    }

    /**
     * Määrittää kumpi voitti vai oliko kyseessä tasapeli ja päivittää tilanteen
     * @param p1Valinta Pelaajan 1 valinta
     * @param p2Valinta Pelaajan 2 valinta
     */
    public void kumpiVoitti(String p1Valinta, String p2Valinta) {
        if (p1Valinta == p2Valinta) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        } else if (p1.voittiko(p1Valinta, p2Valinta)) {
            p1.setVoitot();
            System.out.println("\n\t\tPelaaja 1 voittaa\n");
        } else {
            p2.setVoitot();
            System.out.println("\n\t\tPelaaja 2 voittaa\n");
        }
    }

    /**
     * Tarkistaa onko toinen pelaaja saavuttanut kolme voittoa
     * @return true jos toinen pelaaja on saavuttanut kolme voittoa
     */
    public boolean getPeliLoppui() {
        if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY! Voittaja on " + (p1.getVoitot() > p2.getVoitot() ? "Pelaaja 1" : "Pelaaja 2") + " kolmella voitolla!");
            return true;
        }
        return false;
    }

    /**
     * Palauttaa tasapelien määrän
     * @return tasapelien määrä
     */
    public int getTasapelit() {
        return tasapelit;
    }

    /**
     * Palauttaa pelattujen pelien määrän
     * @return pelattujen pelien määrä
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }
}

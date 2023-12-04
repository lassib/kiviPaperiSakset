package com.laatu.kivipaperisakset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testaa Pelaaja-luokkan toiminnaalisuutta
 * @see Pelaaja
 * @author Lassi Bågman
 */
public class PelaajaTest {

    /**
     * Testaa jos pelaaja 1 voittaa
     */
    @Test
    public void testPelaaja1Voitti() {
        Pelaaja pelaaja1 = new Pelaaja();
        assertTrue(pelaaja1.voittiko("kivi", "sakset"));
        assertTrue(pelaaja1.voittiko("paperi", "kivi"));
        assertTrue(pelaaja1.voittiko("sakset", "paperi"));
    }

    /**
     * Testaa jos pelaaja 1 häviää
     */
    @Test
    public void testPelaaja1Havisi() {
        Pelaaja pelaaja1 = new Pelaaja();
        assertFalse(pelaaja1.voittiko("kivi", "paperi"));
        assertFalse(pelaaja1.voittiko("paperi", "sakset"));
        assertFalse(pelaaja1.voittiko("sakset", "kivi"));
    }

    /**
     * Testaa jos tasapeli
     */
    @Test
    public void testPelaaja1Tasapeli() {
        Pelaaja pelaaja1 = new Pelaaja();
        assertFalse(pelaaja1.voittiko("kivi", "kivi"));
        assertFalse(pelaaja1.voittiko("paperi", "paperi"));
        assertFalse(pelaaja1.voittiko("sakset", "sakset"));
    }

    /**
     * Testaa että voiton lisääminen onnistuu
     */
    @Test
    public void testLisaaVoitto() {
        Pelaaja pelaaja1 = new Pelaaja();
        pelaaja1.setVoitot();
        assertEquals(1, pelaaja1.getVoitot());
    }
}

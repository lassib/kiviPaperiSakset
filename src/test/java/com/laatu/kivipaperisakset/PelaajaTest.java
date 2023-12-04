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
     * Testaa että voiton lisääminen onnistuu
     */
    @Test
    public void testLisaaVoitto() {
        Pelaaja pelaaja1 = new Pelaaja();
        pelaaja1.addVoitto();
        assertEquals(1, pelaaja1.getVoitot());
    }
}

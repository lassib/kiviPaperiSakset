package com.laatu.kivipaperisakset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

public class PeliTest {
    Peli peli;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;

    @BeforeEach
    public void setUp() {
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        peli = new Peli(pelaaja1, pelaaja2);
    }

    @Order(1)
    @Test
    void testLahtopiste() {
        assertEquals(0, pelaaja1.getVoitot());
        assertEquals(0, pelaaja2.getVoitot());
        assertEquals(0, peli.getTasapelit());
        assertEquals(0, peli.getPelatutPelit());
    }

    @Order(2)
    @ParameterizedTest(name = "{index} => pelaaja1Valinta={0}, pelaaja2Valinta={1}, pelaaja1OdotetutVoitot={2}, pelaaja2OdotetutVoitot={3}, tasapelit={4}")
    @CsvSource({
            "kivi, sakset, 1, 0, 0",
            "kivi, paperi, 0, 1, 0",
            "kivi, kivi, 0, 0, 1",
            "paperi, sakset, 0, 1, 0",
            "paperi, kivi, 1, 0, 0",
            "paperi, paperi, 0, 0, 1",
            "sakset, paperi, 1, 0, 0",
            "sakset, kivi, 0, 1, 0",
            "sakset, sakset, 0, 0, 1"
    })
    void testVoittaja(String pelaaja1Valinta, String pelaaja2Valinta, int pelaaja1OdotetutVoitot, int pelaaja2OdotetutVoitot, int tasapelit) {
        Peli peli = new Peli(pelaaja1, pelaaja2);
        peli.kumpiVoitti(pelaaja1Valinta, pelaaja2Valinta);
        assertEquals(pelaaja1OdotetutVoitot, pelaaja1.getVoitot());
        assertEquals(pelaaja2OdotetutVoitot, pelaaja2.getVoitot());
        assertEquals(tasapelit, peli.getTasapelit());
    }

    @Order(3)
    @Test
    void testaaPeli() {
        Peli mock = Mockito.spy(peli);
        doNothing().when(mock).kumpiVoitti(pelaaja1.pelaajanValinta(), pelaaja2.pelaajanValinta());
        mock.pelaa();
        verify(mock, times(1)).pelaa();
    }

    @Order(4)
    @Test
    void testPeliLoppuu() {
        assertFalse(peli.getPeliLoppui());
        while (!peli.getPeliLoppui()) {
            peli.pelaa();
        }
        assertTrue(peli.getPeliLoppui());
    }

    @Order(5)
    @Test
    void testKolmeVoittoa() {
        while(!peli.getPeliLoppui()) {
            peli.pelaa();
        }
        assertTrue(peli.getPeliLoppui());
        assertTrue(pelaaja1.getVoitot() == 3 || pelaaja2.getVoitot() == 3);
    }
}

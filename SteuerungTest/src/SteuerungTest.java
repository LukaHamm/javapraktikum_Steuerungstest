/**
Projekt: Ziffernreihen Spiel 
File: Steuerung.java
Author: Lukas Hammer
Last changed: 21.01.2023
**/


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class SteuerungTest {

	private static Steuerung steuerung;
	private static Spielkonsole spielkonsole;
	private static Bestenliste bestenliste;
	private static long startzeit;
	private static Ziffer ziffer1;
	private static Ziffer ziffer2;
	private static int vorigeZiffernlaenge;
	private static int aktuelleZiffernlaenge;
	
	@BeforeAll
	public static void init () {
		spielkonsole = new Spielkonsole();
		steuerung = new Steuerung(spielkonsole);
		bestenliste = new Bestenliste(steuerung);
		steuerung.melde_An(bestenliste);
		spielkonsole.melde_an(steuerung);
		ziffer1 = new Ziffer(spielkonsole);
		ziffer2 = new Ziffer(spielkonsole);
	}

	@Test
	@Order(1)
	public void testSpielGestartet() {
		vorigeZiffernlaenge = spielkonsole.laenge_Ziffernfolge();
		spielkonsole.melde_an(steuerung);
		steuerung.melde_An(bestenliste);
		steuerung.spiel_gestartet();
		aktuelleZiffernlaenge = spielkonsole.laenge_Ziffernfolge();
		assertTrue("Spielekonsole nicht sichtbar",spielkonsole.isVisible());
		assertTrue("Ziffernfolge nicht erweitert",(aktuelleZiffernlaenge - vorigeZiffernlaenge) == 1);
		steuerung.praesentation_Ziffernfolge_beendet();
	}

	@Test
	@Order(2)
	public void testKorrekteZifferNochNichtAlleMemoriert() {
		vorigeZiffernlaenge = aktuelleZiffernlaenge;
		spielkonsole.Ziffer_ausgewaehlt(ziffer1);
		aktuelleZiffernlaenge = spielkonsole.laenge_Ziffernfolge();
		assertTrue("Ziffernfolge wurde erweitert",(aktuelleZiffernlaenge-vorigeZiffernlaenge)== 0);
	}
	
	@Test
	@Order(3)
	public void testKorrekteZifferAlleMemoriert() {
		spielkonsole.starte_Praesentation_Ziffernfolge();
		vorigeZiffernlaenge = spielkonsole.laenge_Ziffernfolge();
		spielkonsole.Ziffer_ausgewaehlt(ziffer1);
		aktuelleZiffernlaenge = spielkonsole.laenge_Ziffernfolge();
		assertTrue("Ziffernfolge wurde nicht erweitert",(aktuelleZiffernlaenge-vorigeZiffernlaenge)== 1);
		steuerung.praesentation_Ziffernfolge_beendet();
	}
	
	@Test
	@Order(4)
	public void testFalscheZiffer() {
		vorigeZiffernlaenge = aktuelleZiffernlaenge;
		spielkonsole.Ziffer_ausgewaehlt(ziffer2);
		aktuelleZiffernlaenge = spielkonsole.laenge_Ziffernfolge();
		assertTrue("Ziffernfolge wurde erweitert",(aktuelleZiffernlaenge-vorigeZiffernlaenge)== 0);
		assertTrue("Spielekonsole sichtbar",!spielkonsole.isVisible());
		
	}
	
	@Test
	@Order(5)
	public void testEingabeName() {
		startzeit = steuerung.startzeitInMs;
		assertTrue("Spielekonsole ist sichtbar",!spielkonsole.isVisible());
		steuerung.name_eingegeben();
	}
	
	@Test
	@Order(6)
	public void testAnzeigeBestenListe() {
		vorigeZiffernlaenge = aktuelleZiffernlaenge;
		aktuelleZiffernlaenge=spielkonsole.laenge_Ziffernfolge();
		assertTrue("Spielekonsole ist sichtbar",!spielkonsole.isVisible());
		assertTrue("Ziffernfolge wurde erweitert",(aktuelleZiffernlaenge-vorigeZiffernlaenge)==0);
		
	}
	
	@Test
	@Order(7)
	public void testNeuesSpiel() {
		steuerung.neues_Spiel();
		assertTrue("Startzeit nicht zurückgesetzt",startzeit < steuerung.startzeitInMs);
		assertTrue("Anzahl richtig geraten falsch", spielkonsole.laenge_Ziffernfolge() == 1);
		assertTrue("Spielekonsole ist nicht sichtbar", spielkonsole.isVisible());
	}
	
	

}

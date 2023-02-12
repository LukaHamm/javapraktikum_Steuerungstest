
/**
Projekt: Ziffernreihen Spiel 
File: Spielekonsole.java
Author: Lukas Hammer
Last changed: 21.01.2023
**/

import java.awt.Color;
import java.awt.SystemColor;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Spielkonsole fuer das Spiel "Ziffernfolge". Es besteht aus einem Feld von
 * neun Ziffernfeldern, die in verschiedenen Farben aufleuchten k�nnen. Der
 * Spieler kan die Zifferfelder mit der Maus anklicken, um die memorierte
 * Ziffernreihe einzugeben.
 */
@SuppressWarnings("serial")
public class Spielkonsole {
	private int anzahlZiffern;
	private Steuerung steuerung;// f�r die Spielsteuerung
	private boolean sichtbar = true;

	/**
	 * Erzeugt eine neue Spielkonsole. Die Abmessungen werden automatisch so
	 * eingestellt, dass die neun Ziffernfelder genug Platz haben. Die Spielkonsole
	 * erzeugt eine Steuerung, die erlaubt, das Spiel zu kontrollieren. Ist die
	 * Spielkonsole erzeugt, wird der Steuerung der Eintritt des Ereignisses "Spiel
	 * gestartet" �bermittelt.
	 */
	public Spielkonsole() {

	}

	/**
	 * 
	 * @return Die Spieldauer des jetzigen Spiels
	 */
	public int spielzeit() {
		return (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - steuerung.startzeitInMs);
	}

	/**
	 * Methode, um die Benutzeroberfläche der Spielekonsole zu verstecken (false)
	 * oder zu zeigen(true)
	 * 
	 * @param isSichtbar
	 */
	public void sichtbar(boolean isSichtbar) {
		this.sichtbar = isSichtbar;

	}

	/**
	 * 
	 * @return Laenge der derzeitigen Ziffernfolge
	 */
	public int laenge_Ziffernfolge() {

		return anzahlZiffern;
	}

	/**
	 * Die aktuelle Ziffernreihe wird um eine Ziffer verlaengert und ihre
	 * Praesentation gestartet. Dies bedeutet, dass die zugehoerigen Ziffernfelder
	 * nacheinander blau aufleuchten. Ist die Praesentation beendet, wird der
	 * Steuerung mitgeteilt, dass dieses Ereignis eingetreten ist.
	 */
	public void starte_Praesentation_Ziffernfolge() {
		anzahlZiffern++;
	}

	/**
	 * Die aktuelle Ziffernfolge wird geloescht und durch eine neue, noch leere
	 * ersetzt.
	 */
	public void beginne_neue_Ziffernfolge() {
		anzahlZiffern = 0;
	}

	/** Die n�chste Sollziffer wird f�r die n�chste �berpr�fung bereitgestellt. */
	public void naechste_Sollziffer() {
	}

	/**
	 * Teilt der Spielkonsole mit, dass der Spieler ein Ziffernfeld mit der Maus
	 * angeklickt hat. Die Spielkonsole leitet dieses Ereignis an seine Steuerung
	 * weiter.
	 * 
	 * @param ziffer Verweis auf das ausgew�hlte Ziffer-Objekt.
	 */
	public void Ziffer_ausgewaehlt(Ziffer ziffer) {
		steuerung.ziffer_ausgewaehlt(ziffer);
	}

	/**
	 * Es wird gepr�ft, ob die ausgewaehlte Ziffer korrekt ist. Die ausgewaehlte
	 * Ziffer wird mit der aktuellen Ziffer der Ziffernreihe verglichen.
	 * 
	 * @param ziffer Verweis auf das ausgewaehlte Ziffer-Objekt
	 * @return true, wenn die Ziffer mit der aktuellen uebereinstimmt.
	 */
	public boolean ausgewaehlte_Ziffer_korrekt(Ziffer ziffer) {
		int ziffer_ist = ziffer.wert();

		return ziffer_ist == 1;
	}

	/**
	 * Prueft, ob die gesamte Ziffernreihe richtig memoriert worden ist.
	 * 
	 * @return true, wenn die gesamte Ziffernreihe richtig memoriert worden ist.
	 */
	public boolean alle_Ziffern_memoriert() {
		return anzahlZiffern % 2 == 0;
	}

	/**
	 * Der Spielkonsole wird die Steuerung bekannt gemacht, mit der sie
	 * zusammenarbeiten soll.
	 * 
	 * @param steuerung Steuerung
	 */
	public void melde_an(Steuerung steuerung) {
		this.steuerung = steuerung;
	}

	public boolean isVisible() {
		return sichtbar;
	}

}
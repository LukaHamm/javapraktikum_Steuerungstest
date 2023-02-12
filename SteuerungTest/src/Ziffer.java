
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/** Stellt eine Ziffer graphisch in einem Feld dar. Das Zifferfeld kann in 
  drei verschiedenen Farben aufleuchten. Das Ziffernfeld reagiert auf 
  Mausklicks.*/
@SuppressWarnings("serial")
public class Ziffer
{   
   /** Groesse des Feldes, in der die Ziffer dargestellt wird [Pixel]*/
   public static final int groesse=50;
   private static int anzahl=0;
   private int ziffer;
   private Spielkonsole spielkonsole; // Spielkonsole, zu der das Ziffernfeld gehoert.
   
  /** Erzeugt ein Feld, das eine Ziffer darstellt. Das erste Feld stellt
      die Ziffer 1 dar, das zweite, das erzeugt wird, die Ziffer 2 usw.
      Wird das Ziffernfeld mit der linken Maustaste angeklickt, wird die
      Spielkonsole, zu der das Ziffernfeld gehoert, dar�ber informiert.
      @param spielkonsole Spielkonsole zu der das Ziffernfeld gehoert.*/
  public Ziffer(Spielkonsole spielkonsole)
  { 
	  anzahl++;
	  ziffer=anzahl;
  } 
  
  /** Laesst das Feld, das die Ziffer enthaelt, rot aufleuchten. */
  public void leuchte_rot_auf()
  { 
  }

  /** Laesst das Feld, das die Ziffer enthaelt, gruen aufleuchten. */
  public void leuchte_gruen_auf()
  { ;    
  }

  /** Laesst das Feld, das die Ziffer enthaelt, blau aufleuchten. */  
  public void leuchte_blau_auf()
  {     
  }
  
  
  public int wert(){return ziffer;}
  
}

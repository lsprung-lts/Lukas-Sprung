package sprung.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sprung.cipher.SubstitutionCipher;
/**
 * Diese JUnit Testklasse hat den gro�en Vorteil gegen�ber der Main Methode dass man EINZELNE Methoden Testen kann
 * Beim Erstellen der JUnit Testklasse kann man zwischen vielen Methoden entscheiden die schon von 
 * Anfang an in die Klasse implementiert werden sollen.
 * 
 * Ich habe mich nur f�r die Klasse setUp() entschieden --> Hier initialisiere ich mein Objekt (besserer �berblick)
 * 
 * Danach schreibe ich den Code um die einzelnen Methoden zu testen(fast wie in der Main Methode)
 * 
 * F�hrt man dann diese Testklasse aus "ploppt" ein Fenster auf indem man erkennen kann ob alles funktioniert hat = GR�NER BALKEN
 * hat es nicht funktioniert kommt ein ROTER BALKEN.
 * 
 * @author Luki
 * @date 30-03-2014
 */
public class Tester {
	private SubstitutionCipher tester;

	@Before
	public void setUp() throws Exception {
		tester = new SubstitutionCipher("qwertzuiop�asdfghjkl��yxcvbnm�");
	}

	@Test
	public void testSubstitutionCipher() {
		String text = "Hallo mein Name ist Lukas";
		String encr = tester.encrypt(text);
		String decr = tester.decrypt(encr);
		
		System.out.println(text);
		System.out.println(encr);
		System.out.println(decr);
	}

}

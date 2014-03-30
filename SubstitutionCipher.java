package sprung.cipher;
import javax.swing.JOptionPane;

/**
 * Diese Klasse Stellt eine allgemeine Substitutionsverschl�sselung dar.
 * 
 * @author Luki
 * @date 29-03-2014
 */
//Das gesammte Geheimalphabet muss an ein Objekt dieser Klasse im 
//KOnstruktor oder in der Methode setSecretAlphabet �bergeben werden
public class SubstitutionCipher extends MonoalphabeticCipher{
	public SubstitutionCipher(String secretalphabet) {
		super.setSecretAlphabet(secretalphabet);
	}
    
	/**
	 * Ich finde die Methode unn�tig, denn im Konstruktor kann
	 * ich einfach die set Methode aus der Superklasse aufrufen..
	 */
	public void setSecretAlphabet(String secretAlphabet){}
}

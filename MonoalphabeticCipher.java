package sprung.cipher;
import java.awt.List;


public class MonoalphabeticCipher implements Cipher{
	private String secreteAlphabet;
	private static final char[] standartal = "abcdefghijklmnopqrstuvwxyz����".toCharArray();
	// soll als Substitutionsschl�ssel genutzt werden ^
 

	/**
	 * Die folgenden 2 Methoden sind f�r die Ver- bzw. Entschl�sselung zust�ndig
	 * Als Parameter wird ein Text �bergeben der Mithilfe des Substitutionsschl�ssels(dem einzigen Attribut da oben)
	 * ver- bzw. entschl�sselt wird.
	 * 
	 * Weiters wird der text in KLeinbuchstaben zur�ckgegeben
	 * 
	 * Zeichen die NICHT im Substitutionsschl�ssel vorhanden sind WERDEn 1:1 �bernommen
	 */
	
	public String encrypt(String text) {
		text = text.toLowerCase();
		String encr = "";
		
		for(int i = 0; i < text.length();i++) {
			int stelle = new String(standartal).indexOf(text.charAt(i));
			if(stelle < 0){
				encr+= text.charAt(i);
			}else {
				encr+= secreteAlphabet.charAt(stelle);
			}
		}
		return encr;
	}
 
	@Override
	public String decrypt(String text) {
		text = text.toLowerCase();
		String decr = "";
		for(int i = 0; i < text.length();i++) {
			int stelle = new String(secreteAlphabet).indexOf(text.charAt(i));
			if(stelle < 0) {
				decr+= text.charAt(i);
			}else {
				decr+= standartal[stelle];
			}
		}
		return decr;
	}
	
	//Konstruktor
	public MonoalphabeticCipher() {
		
	}
	//Gibt das Geheimalphabet zur�c
	public String getSecretAlphabet() {
		return secreteAlphabet;
	}
	
	/**
	 * Stellt f�r Subklassen die M�glichkeit bereit das Attribut,
	 * sprich den Substitutionsschl�ssel zu �ndern.
	 * @return
	 */
	protected void setSecretAlphabet(String secreteAlphabet) {
		this.secreteAlphabet = secreteAlphabet;
	}
}

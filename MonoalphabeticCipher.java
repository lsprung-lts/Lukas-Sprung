package sprung.cipher;
import java.awt.List;


public class MonoalphabeticCipher implements Cipher{
	private String secreteAlphabet;
	private static final char[] standartal = "abcdefghijklmnopqrstuvwxyzäöüß".toCharArray();
	// soll als Substitutionsschlüssel genutzt werden ^
 

	/**
	 * Die folgenden 2 Methoden sind für die Ver- bzw. Entschlüsselung zuständig
	 * Als Parameter wird ein Text übergeben der Mithilfe des Substitutionsschlüssels(dem einzigen Attribut da oben)
	 * ver- bzw. entschlüsselt wird.
	 * 
	 * Weiters wird der text in KLeinbuchstaben zurückgegeben
	 * 
	 * Zeichen die NICHT im Substitutionsschlüssel vorhanden sind WERDEn 1:1 übernommen
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
	//Gibt das Geheimalphabet zurüc
	public String getSecretAlphabet() {
		return secreteAlphabet;
	}
	
	/**
	 * Stellt für Subklassen die Möglichkeit bereit das Attribut,
	 * sprich den Substitutionsschlüssel zu ändern.
	 * @return
	 */
	protected void setSecretAlphabet(String secreteAlphabet) {
		this.secreteAlphabet = secreteAlphabet;
	}
}

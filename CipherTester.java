
public class CipherTester {
	public static void main (String[] args) {
		MonoalphabeticCipher versuch = new MonoalphabeticCipher();
		versuch.setSecretAlphabet("qwertzuiop�asdfghjkl��yxcvbnm�");
		String schaun = "Hallo mein Name ist Lukas";
		String encr = versuch.encrypt(schaun);
		System.out.println(schaun);
		System.out.println(encr);
		String decr = versuch.decrypt(encr);
		System.out.println(decr);
	}
}

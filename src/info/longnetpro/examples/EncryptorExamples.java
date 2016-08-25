package info.longnetpro.examples;

import info.longnetpro.common.util.encryption.Cipher;
import info.longnetpro.common.util.encryption.Encryptor;

public class EncryptorExamples {

	public static void example1() {
		Cipher cipher = Cipher.TRIPPLEDES;
		Encryptor en = new Encryptor();
		String text = "Text String111";
		//en.setIvParameter(text);
		String encoded = en.encrypt(text, cipher);
		System.out.println(encoded);
		
		String decoded = en.decrypt(encoded, cipher);
		System.out.println(decoded);
	}

	public static void main(String[] args) {
		example1();
	}
}

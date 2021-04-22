package patterns.decorator.case2;

public class EncryptorB extends Encryptor{
	
	
	@Override
	public String encipher(String plaintext) {
		char[] charArray = plaintext.toCharArray();
		for(int i = 0; i < charArray.length; i++) {
			charArray[i] += 2;
		}
		String temp = String.valueOf(charArray);
		temp = super.encipher(temp);
		return temp;
	}

	@Override
	public String decipher(String ciphertext) {
		String temp = super.decipher(ciphertext);
		char[] charArray = temp.toCharArray();
		for(int i = 0; i < charArray.length; i++) {
			charArray[i] -= 2;
		}
		temp = String.valueOf(charArray);
		return temp;
	}
	
}

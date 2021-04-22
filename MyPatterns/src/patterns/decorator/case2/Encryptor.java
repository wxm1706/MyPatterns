package patterns.decorator.case2;

public abstract class Encryptor implements ICipher {
	private ICipher cipher;
	
	@Override
	public String encipher(String plaintext) {
		String temp = plaintext;
		if(cipher != null) {
			temp = cipher.encipher(plaintext);
		}
		return temp;
	}

	@Override
	public String decipher(String ciphertext) {
		String temp = ciphertext;
		if(cipher != null) {
			temp = cipher.decipher(ciphertext);
		}
		return temp;
	}

	public ICipher getCipher() {
		return cipher;
	}

	public void setCipher(ICipher cipher) {
		this.cipher = cipher;
	}

}

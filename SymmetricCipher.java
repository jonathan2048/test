public abstract class SymmetricCipher{
	abstract void encryption(String source, String destination);
	abstract void decryption(String source, String destination);

	protected KeyGenerator keygenerator = new KeyGenerator();
}
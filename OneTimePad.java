public class OneTimePad extends SymmetricCipher{
	public OneTimePad(){

	}
	public void encryption(String source, String destination){
		keygenerator.keyGenerate(destination,5566);
	}
	public void decryption(String source, String destination){
		
	}
}
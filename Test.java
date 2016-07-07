class Test{
	public static void main(String[] args) {
		OneTimePad g = new OneTimePad();
		g.encryption("declaration.txt","ciphertext.txt");
		g.decryption("ciphertext.txt","plaintext.txt");
	}
}
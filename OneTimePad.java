import java.io.RandomAccessFile;
public class OneTimePad extends SymmetricCipher{
	public OneTimePad(){

	}
	public void encryption(String source, String destination){

		int templength;
		byte[] readbuffer;
		byte[] writebuffer;
		byte[] keybuffer;

		try{
			RandomAccessFile sourcefile = new RandomAccessFile(source, "r");
			RandomAccessFile destinationfile = new RandomAccessFile(destination, "rw");
			
			templength = (int)sourcefile.length();
			keygenerator.keyGenerate(keyfilename, templength);
			RandomAccessFile keyfile = new RandomAccessFile(keyfilename, "r");

			while (templength > 0) {
				readbuffer = new byte[Math.min(BUFFER_SIZE,templength)];
				writebuffer = new byte[Math.min(BUFFER_SIZE,templength)];
				keybuffer = new byte[Math.min(BUFFER_SIZE,templength)];

				sourcefile.read(readbuffer);
				keyfile.read(keybuffer);
				for (int i = 0;i < Math.min(BUFFER_SIZE,templength);i++ ) {
					writebuffer[i] = (byte)(readbuffer[i] ^ keybuffer[i]);
				}
				destinationfile.write(writebuffer);
				templength = templength - BUFFER_SIZE;
			}

		} catch (Exception e) {
			System.out.println("file io error(in encryption).");
		}
	}
	public void decryption(String source, String destination){

		int templength;
		byte[] readbuffer;
		byte[] writebuffer;
		byte[] keybuffer;

		try{
			RandomAccessFile sourcefile = new RandomAccessFile(source, "r");
			RandomAccessFile keyfile = new RandomAccessFile(keyfilename, "r");
			RandomAccessFile destinationfile = new RandomAccessFile(destination, "rw");
			
			templength = (int)sourcefile.length();

			while (templength > 0) {
				readbuffer = new byte[Math.min(BUFFER_SIZE,templength)];
				writebuffer = new byte[Math.min(BUFFER_SIZE,templength)];
				keybuffer = new byte[Math.min(BUFFER_SIZE,templength)];
				
				sourcefile.read(readbuffer);
				keyfile.read(keybuffer);
				for (int i = 0;i < Math.min(BUFFER_SIZE,templength);i++ ) {
					writebuffer[i] = (byte)(readbuffer[i] ^ keybuffer[i]);
				}
				destinationfile.write(writebuffer);
				templength = templength - BUFFER_SIZE;
			}

		} catch (Exception e) {
			System.out.println("file io error(in decryption).");
		}
	}

	private int BUFFER_SIZE = 1000;
	private String keyfilename = "OneTimePadKey.txt";
}
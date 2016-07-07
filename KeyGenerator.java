import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.io.RandomAccessFile;
public class KeyGenerator{

	public KeyGenerator(){

	}
	public void keyGenerate(String filename,int keylength){
		keyfile = Paths.get(filename);
		templength = keylength;
		try{
			Files.deleteIfExists(keyfile);
			Files.createFile(keyfile);
			while(templength > 0){
				randombytes = new byte[Math.min(BUFFER_SIZE,templength)];
				random.nextBytes(randombytes);
				Files.write(keyfile, randombytes, StandardOpenOption.APPEND);
				templength = templength - BUFFER_SIZE;
			}
			
		}catch (Exception e) {
			System.out.println("file io error(in key generation).");
		}
		
	}

	private byte[] randombytes;
	private Path keyfile;
	private int templength;
	private int BUFFER_SIZE = 1000;
	private SecureRandom random = new SecureRandom();
}
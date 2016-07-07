public class RandomNumberGenerator{
	public void randomStream(int length){
		for (int i = 0;i < length; i++) {
			System.out.print((int)(Math.random()*2));
		}
		System.out.println();
	}
}
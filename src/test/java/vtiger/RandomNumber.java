package vtiger;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random ran=new Random();
		int value = ran.nextInt(500);
		System.out.println(value);
	}

}

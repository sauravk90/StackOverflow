package pageObjects;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int randomNum, minimum;
		// TODO Auto-generated method stub
		Random rand = new Random();
		for(int i = 1; i<51; i++){
		randomNum = 1 + rand.nextInt((49) + 1);
		System.out.println(randomNum);
		}
	}

}

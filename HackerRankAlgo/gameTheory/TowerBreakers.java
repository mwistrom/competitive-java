package gameTheory;

import java.util.*;

public class TowerBreakers {

	static int[] a;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int t0 = 0; t0 < t; t0++) {
			int n = in.nextInt();
			@SuppressWarnings("unused")
			int m = in.nextInt();
	
			System.out.println( n % 2 != 0 ? "1" : "2");
		}
		in.close();
	}

	
}
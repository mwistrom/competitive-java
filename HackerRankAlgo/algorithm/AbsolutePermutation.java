package algorithm;

import java.util.Scanner;

public class AbsolutePermutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();

			if (k == 0) {
				for (int i = 1; i <= n; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
				continue;
			}

			if (n % k != 0) {
				System.out.println(-1);
				continue;
			}

			int[] b = new int[n];
			for(int i = 0 ;i < n;i ++ ) {
			    b[i] = i + 1;
            }
			boolean[] m = new boolean[n];
			for (int i = 0; i < n; i++) {
				if( !m[i] && i + k < n && !m[i+k]) {
				    int temp = b[i];
				    b[i] = b[i + k];
				    b[i + k] = temp;
				    m[i] = true;
				    m[i + k] = true;
                }

			}

			boolean mo = false;
			for(boolean y : m) {
			    if( y == false) {
			        System.out.println(-1);
			        mo = true;
			        break;
                }
            }

            if (mo )
                continue;

			for (int x : b)
				System.out.print(x + " ");
			System.out.println(  );
		}
		in.close();
	}
}

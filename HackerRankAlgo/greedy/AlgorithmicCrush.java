package greedy;

import java.util.*;

public class AlgorithmicCrush {
	
	static Random rand = new Random(System.currentTimeMillis());
	
	static class Tup {
		Integer i;
		Integer v;

		Tup(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 3 + rand.nextInt(20);//in.nextInt();
		int m = 1 + rand.nextInt(40);//in.nextInt();

		int[] a_s = new int[n + 1];
		int[] a_e = new int[n + 1];
		
		long[] a = new long[n+1];
		
		for (int i = 0; i < m; i++) {
			int s = 1+rand.nextInt(n-2); //in.nextInt();
			int e = s + rand.nextInt(n-s);//in.nextInt();
			int d = rand.nextInt(10);//in.nextInt();

			a_s[s] += d;
			a_e[e] += d;
			
			for(int j = s; j <= e; j++ ) {
				a[j] += d;
			}
			
			System.out.println("Start : " + s + "\tEnd : " + e + "\tVal : " + d);
		}
		in.close();
		
		long fast_max = fast( n,m,a_s,a_e);
		System.out.println(fast_max);
		
		long slow_max = 0;
		for( long i : a) {
			System.out.print(i + " ");
			slow_max = Math.max(slow_max, i);
		}
		System.out.println();
		System.out.println(slow_max);
	}


	private static long fast(int n, int m, int[] a_s, int[] a_e) {
		Queue<Tup> start = new PriorityQueue<Tup>(m, new Comparator<Tup>() {
			@Override
			public int compare(Tup x, Tup y) {
				if (x.i < y.i)
					return -1;
				if (x.i == y.i)
					return 0;
				return 1;
			}
		});
		
		Queue<Tup> end = new PriorityQueue<Tup>(m, new Comparator<Tup>() {
			@Override
			public int compare(Tup x, Tup y) {
				if (x.i < y.i)
					return -1;
				if (x.i == y.i)
					return 0;
				return 1;
			}
		});

		for (int i = 0; i < n + 1; i++) {
			if (a_s[i] > 0) {
				start.add(new Tup(i, a_s[i]));
			}
			if (a_e[i] > 0) {
				end.add(new Tup(i, a_e[i]));
			}
		}
		
		long val = 0;
		long max = 0;
		Tup n_add = start.poll();
		Tup n_end = end.poll();

		while (true) {
			System.out.println(n_add.i + "\t" + n_end.i + "\t" + val);
			if (n_add.i <= n_end.i) {
				val += n_add.v;
				max = Math.max(max, val);
				if (start.size() == 0) {
					System.out.println("Break");				
					break;
				}
				else
					n_add = start.poll();
			} else if (n_add.i == n_end.i) {
				val += n_add.v - n_end.v;
				max = Math.max(max, val);
				if (start.size() == 0)
					break;
				else {
					n_add = start.poll();
					n_end = end.poll();
				}
			} else {
				val -= n_end.v;
				n_end = end.poll();
			}
		}
		return max;
	}
}
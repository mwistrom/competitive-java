package interview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Q4 {
    public static MyScanner in = new MyScanner();
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
    public static MyViewer view = new MyViewer();

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        private boolean randomInput = false;
        private Random rand;

        void randomInput(boolean r) {
            randomInput = r;
            rand = new Random(System.currentTimeMillis());
            //rand = new Random(42);
        }

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int nextInt(int val) {
            return randomInput ? val : Integer.parseInt(next());
        }

        int nextInt(int low, int high) {
            if (randomInput) {
                return rand.nextInt(high - low + 1) + low;
            } else {
                return Integer.parseInt(next());
            }
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] arrayInt(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            return a;
        }

        int[] arrayInt(int n, int low, int high) {
            int[] a = new int[n];
            if (randomInput) {
                for (int i = 0; i < n; i++) {
                    a[i] = rand.nextInt(high - low + 1) + low;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
            }
            return a;
        }

        ArrayList<Integer> list(int n) {
            ArrayList<Integer> a = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }
            return a;
        }

        ArrayList<Integer> list(int n, int low, int high) {
            ArrayList<Integer> a = new ArrayList<Integer>(n);
            if (randomInput) {
                for (int i = 0; i < n; i++) {
                    a.add(rand.nextInt(high - low + 1) + low);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    a.add(in.nextInt());
                }
            }
            return a;
        }

        long[] arrayLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            return a;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<ArrayList<Integer>> randomTree(int n) {
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 1; i < n; i++) {
                int par = rand.nextInt(i);
                edges.get(par).add(i);
            }
            return edges;
        }
    }

    static class MyViewer {
        static boolean print = true;

        public void on() {
            print = true;
        }

        public void off() {
            print = false;
        }

        public <T extends List> void list(T a) {
            if (!print) return;
            out.print("List: [" + a.get(0));
            for (int i = 1; i < a.size(); i++) {
                out.print(", " + a.get(i));
            }
            out.println("] Len: " + a.size());
        }

        public <T> void array(T[] a) {
            if (!print) return;
            out.print("Array: [" + a[0]);
            for (int i = 1; i < a.length; i++) {
                out.print(", " + a[i]);
            }
            out.println("] Len: " + a.length);
        }

        public void array(boolean[] a) {
            if (!print) return;
            out.print("boolean[] Len: " + a.length + " [");
            for (boolean x : a) {
                out.print(x + ", ");
            }
            out.println("\b\b]");
        }

        public void array(int[] a) {
            if (!print) return;
            out.print("int[] Len: " + a.length + " [");
            for (int x : a) {
                out.print(x + ", ");
            }
            out.println("\b\b]");
        }

        public void array(long[] a) {
            if (!print) return;
            out.print("long Array: [");
            for (long x : a) {
                out.print(x + ", ");
            }
            out.println("\b\b] Len: " + a.length);
        }

        public void matrix(int[][] a, int cutoff) {
            if (cutoff == 0)
                cutoff = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (i < cutoff) {
                    printMatrixRow(a[i], cutoff);
                } else {
                    out.println("     ...");
                    printMatrixRow(a[a.length - 1], cutoff);
                    break;
                }
            }
        }

        public void matrix(long[][] a, long cutoff) {
            if (cutoff == 0)
                cutoff = Long.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (i < cutoff) {
                    printMatrixRow(a[i], cutoff);
                } else {
                    out.println("     ...");
                    printMatrixRow(a[a.length - 1], cutoff);
                    break;
                }
            }
        }

        public void matrix(boolean[][] a, int cutoff) {
            if (cutoff == 0)
                cutoff = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (i < cutoff) {
                    printMatrixRow(a[i], cutoff);
                } else {
                    out.println("     ...");
                    printMatrixRow(a[a.length - 1], cutoff);
                    break;
                }
            }
        }

        private void printMatrixRow(int[] a, int cutoff) {
            for (int j = 0; j < a.length; j++) {
                if (j < cutoff) {
                    out.printf("%6d  ", a[j]);
                } else {
                    out.printf(" ... %6d", a[a.length - 1]);
                    break;
                }
            }
            out.println();
        }

        private void printMatrixRow(long[] a, long cutoff) {
            for (int j = 0; j < a.length; j++) {
                if (j < cutoff) {
                    out.printf("%6d  ", a[j]);
                } else {
                    out.printf(" ... %6d", a[a.length - 1]);
                    break;
                }
            }
            out.println();
        }

        private void printMatrixRow(boolean[] a, int cutoff) {
            for (int j = 0; j < a.length; j++) {
                if (j < cutoff) {
                    out.print(a[j] ? "T " : "F ");
                } else {
                    out.print(" ... " + (a[a.length - 1] ? "T" : "F"));
                    break;
                }
            }
            out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        {
            int[][] a = {{0, 0, 99, 99, 99}, {99, 0, 0, 0, 99}, {99, 99, 99, 0, 99}, {99, 99, 99, 0, 99}, {99, 99, 99, 0, 0}};

            int ans = chipMoving(a);
            out.println(ans);
        }
        {
            int[][] a = {{4, 11, 6, 16, 6, 9, 3, 2, 10, 14},
                    {1, 7, 8, 11, 16, 3, 18, 13, 5, 12},
                    {10, 12, 10, 2, 15, 0, 18, 11, 13, 7},
                    {14, 15, 15, 15, 9, 5, 11, 11, 7, 4},
                    {5, 9, 15, 19, 4, 4, 11, 4, 14, 8},
                    {5, 5, 15, 2, 15, 15, 14, 10, 19, 19},
                    {8, 9, 2, 3, 18, 12, 15, 10, 10, 3},
                    {8, 2, 1, 11, 4, 3, 16, 7, 8, 13},
                    {17, 2, 17, 10, 17, 13, 16, 14, 8, 5},
                    {10, 4, 9, 3, 13, 10, 5, 4, 3, 10}};

            int ans = chipMoving(a);
            out.println(ans);
        }
        {
            int[][] a = {{19,11,13,0,8,1,18,12}};

            int ans = chipMoving(a);
            out.println(ans);
        }
    }

    static int chipMoving(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        int[][][] dp = new int[rows][cols][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;

        for (int i = 1; i < rows; i++) {
            dp[i][0][0] = 1000000000;
            dp[i][0][1] = dp[i-1][0][1] + grid[i][0];
        }

        for (int i = 1; i < cols; i++) {
            dp[0][i][1] = 1000000000;
            dp[0][i][0] = dp[0][i - 1][0] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j][0] = Math.min(dp[i][j - 1][0], dp[i][j - 1][1] + 10) + grid[i][j];
                dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i - 1][j][0] + 10) + grid[i][j];
            }
        }

        return Math.min(dp[rows - 1][cols - 1][0], dp[rows - 1][cols - 1][1]);
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class ClassifyStrings {
    public static MyScanner in = new MyScanner();
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
    public static MyViewer view = new MyViewer();
    public static Random rand = new Random(System.currentTimeMillis());

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
        CF cf = new CF();

        String[] test;
        test = new String[]{


                "?????aa?aaa???bbb???bbb??",
                "aa?bbbb",
                "aa?bbb?a?bbbb",
                "??aa??aa??a?aaa?aa?bbbb??????????????bbbbb????????????????",

                "?????aa??bbbb???bb",
                "?a?a",
                "aa??bbbb",

                "a",
                "height?height?",
                "a?b"
        };

        for (String t : test) {
            System.out.println(cf.classifyStrings(t));
        }

    }

    static class CF {
        String classifyStrings(String s) {

            boolean mg = mg(0, 0, 0, s);
            boolean mb = mb(0, 0, 0, s);

            //System.out.println(mg + "  " + mb);

            if( !mg && mb)
                return "bad";
            if( mb && mg)
                return "mixed";
            if( mb )
                return "bad";
            return "good";
        }

        boolean mg(int crun, int vrun, int i, String s) {
            if (i == s.length()) {
                if (vrun > 2 || crun > 4)
                    return false;
                return true;
            }

            char ch = s.charAt(i);
            if (ch != '?' && "aeiou".indexOf(ch) >= 0) {
                if (vrun == 2)
                    return false;
                return mg(0, vrun + 1, i + 1, s);
            } else if (ch != '?' && "aeiou".indexOf(ch) < 0) {
                if (crun == 4)
                    return false;
                return mg(crun + 1, 0, i + 1, s);
            } else {
                boolean v = false;
                if (vrun < 2)
                    v = mg(0, vrun + 1, i + 1, s);
                boolean c = false;
                if (crun < 4)
                    c = mg(crun + 1, 0, i + 1, s);
                return v || c;
            }
        }

        boolean mb(int crun, int vrun, int i, String s) {
            if (crun > 4 || vrun > 2)
                return true;
            if (i == s.length() ) {
                return false;
            }

            char ch = s.charAt(i);
            if (ch != '?' && "aeiou".indexOf(ch) >= 0) {
                if (vrun == 2)
                    return true;
                return mb(0, vrun + 1, i + 1, s);
            } else if (ch != '?' && "aeiou".indexOf(ch) < 0) {
                if (crun == 4)
                    return true;
                return mb(crun + 1, 0, i + 1, s);
            } else {
                boolean v = mb(0, vrun + 1, i + 1, s);
                boolean c = mb(crun + 1, 0, i + 1, s);

                return v || c;
            }
        }
    }
}


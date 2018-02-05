import java.io.*;
import java.util.*;

public class ComposeExpression {
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

        cf.composeExpression("3456237494", 37);

    }

    static class CF {
        String[] composeExpression(String digits, int target) {
            long startTime = System.nanoTime();
            ArrayList<String> ret = new ArrayList<String>();

            if (digits.charAt(0) == '0') {
                ArrayList<String> dp = dp(digits.substring(1));
                for (String dps : dp) {
                    ret.add("0" + dps);
                }
            } else {
                for (int i = 1; i <= digits.length(); i++) {
                    String num = digits.substring(0, i);
                    ArrayList<String> dp = dp(digits.substring(i));
                    for (String dps : dp) {
                        ret.add(num + dps);
                    }
                }
            }

            System.out.println((System.nanoTime() - startTime) / 1000000.0);

            ArrayList<String> a = new ArrayList<>();
            for (String x : ret) {
                //System.out.println(height);
                if (!x.matches(".*[^0-9].*")) {
                    if (Long.parseLong(x) == target)
                        a.add(x.replace(" ", ""));
                } else if (evaluate(x) == target) {
                    a.add(x.replace(" ", ""));
                }
            }

            Collections.sort(a);
            System.out.println((System.nanoTime() - startTime) / 1000000.0);
            if (a.size() == 0)
                return new String[]{};
            return a.toArray(new String[a.size()]);
        }

        ArrayList<String> dp(String s) {
            if (s.length() == 0) {
                ArrayList<String> x = new ArrayList<String>();
                x.add("");
                return x;
            }

            ArrayList<String> ret = new ArrayList<String>();

            if (s.charAt(0) == '0') {
                ArrayList<String> dp = dp(s.substring(1));
                for (String dps : dp) {
                    ret.add(" + 0" + dps);
                }
                dp = dp(s.substring(1));
                for (String dps : dp) {
                    ret.add(" - 0" + dps);
                }
                dp = dp(s.substring(1));
                for (String dps : dp) {
                    ret.add(" * 0" + dps);
                }
                return ret;
            }
            for (int i = 1; i <= s.length(); i++) {
                String num = s.substring(0, i);
                ArrayList<String> dp = dp(s.substring(i));
                for (String dps : dp) {
                    ret.add(" + " + num + dps);
                }
                dp = dp(s.substring(i));
                for (String dps : dp) {
                    ret.add(" - " + num + dps);
                }
                dp = dp(s.substring(i));
                for (String dps : dp) {
                    ret.add(" * " + num + dps);
                }
            }
            return ret;
        }

        public static int evaluate(String expression) {
            char[] tokens = expression.toCharArray();
            Stack<Integer> values = new Stack<Integer>();
            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] == ' ')
                    continue;

                if (tokens[i] >= '0' && tokens[i] <= '9') {
//                    StringBuffer sbuf = new StringBuffer();
//                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
//                        sbuf.append(tokens[i++]);
//                    values.push(Integer.parseInt(sbuf.toString()));

                    int x = 0;
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                        x = x * 10 + tokens[i++] - '0';
                    }
                    values.push(x);

                } else if (tokens[i] == '+' || tokens[i] == '-' ||
                        tokens[i] == '*' ) {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.push(tokens[i]);
                }
            }

            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            return values.pop();
        }

        public static boolean hasPrecedence(char op1, char op2) {
            if ((op1 == '*') && (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        public static int applyOp(char op, int b, int a) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
            }
            return 0;
        }
    }
}


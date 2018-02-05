import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class LongestCommonSubstring2 {
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

//        String s = "fefcafcdedeceadbbdaacdbdcdaeb";
//        String t = "efdeacdedecab";
//
//        s = "abcdxyz";
//        t = "xyzabcd";
//
//        s = "ABCDGH";
//        t = "ACDGHR";
//
//        s = "ABC";
//        t = "ABCD";
//
//        s = "CHZVFRKMLNOZJK";
//        t = "PQPXRJXKITZYXACBHHKICQCOENDTOMFGDWDWFCGPXIQVKUYTDLCGDEWHTACIOHORDTQKVWCSGSPQOQMSBOAGUWN";
//
//        String s= "AAABACABACBCACBCCBABCCACABABACABCABACBCC";
//        String t = "BCBBCAAACCCBBABBACCBCBBBAACBBCCAAAACCAAB";
//
//        System.out.println(cf.longestCommonSubstring(s, t));
//        System.out.println(slow(s,t));

        for (int i = 0; i < 1000; i++) {
            String t = randString(5000);
            String s = randString2(4000);

//            System.out.println(s);
//            System.out.println(t);


            int fast = cf.longestCommonSubstring(s, t);

            int slow = slow(s, t, fast);
            System.out.println("Slow:" + slow + "     Fast: " + fast);
            if (slow != fast)
                break;
        }
    }

    private static int slow(String s, String t, int goodLen) {
        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        int start = Math.min( goodLen+1, s.length());

        for (int len = goodLen + 1; len >= goodLen; len--) {
            System.out.println("Slow Try: " + len);
            for (int i = 0; i + len <= s.length(); i++) {
                String sub = s.substring(i, i + len);
                int idx = t.indexOf(sub);
                if (idx >= 0) {
                    System.out.println("Slow:  Begin: " + i + "    len: " + len + "   idx: " + idx + "   " + sub);
                    return len;
                }
            }
        }
        return 0;
    }

    private static String randString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char) (rand.nextInt(3) + 'A'));
        }
        return sb.toString();
    }

    private static String randString2(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char) (rand.nextInt(3) + 'G'));
        }
        return sb.toString();
    }


    private static String createStringFromSub(String s, int n) {
        String t = s.substring(0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.abs(n - s.length()); i++) {
            sb.append((char) (rand.nextInt(2) + 'A'));
        }

        t = sb.toString() + t;
        sb = new StringBuilder();
        for (int i = 0; i < Math.abs(n - s.length()); i++) {
            sb.append((char) (rand.nextInt(2) + 'A'));
        }
        t = t + sb.toString();
        return t;
    }

    private static String longString(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (rand.nextInt(2) + 'G'));
        }
        return sb.toString();
    }

    static class CF {

        final static long PRIME_BASE = 256;
        final static long PRIME_MOD = 2770513;
        int longestCommonSubstring(String t, String s) {
            int tlen = t.length();
            int slen = s.length();

            int hi = Math.min(slen, tlen) + 1;
            int lo = -1;
            int mid;
            while (lo + 1 < hi) {
                mid = (lo + hi) / 2;
                //System.out.println("Lo: " + lo + "  Hi: " + hi + "  Mid (Length): " + mid);

                long power = powerHash(mid);
                HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();

                long hash = hash(t, mid);
                //System.out.println("Put: " + t.substring(0, mid) + "      " + hash);

                put(m, hash, 0);
                for (int i = mid; i < tlen; i++) {
                    hash = (hash + PRIME_MOD - (power * t.charAt(i - mid)) % PRIME_MOD) % PRIME_MOD;
                    hash = (hash * PRIME_BASE + t.charAt(i)) % PRIME_MOD;

                    //System.out.println("Put: " + t.substring(i - mid + 1, i) + "      " + hash);
                    put(m, hash, i - mid + 1);
                }

                hash = hash(s, mid);

                // System.out.println("Check : " + s.substring(0, mid) + "     " + hash);
                boolean found = check(t, m, hash, s, 0, mid);

                if (!found) {
                    for (int i = mid; i < slen; i++) {
                        hash = (hash + PRIME_MOD - (power * s.charAt(i - mid)) % PRIME_MOD) % PRIME_MOD;
                        hash = (hash * PRIME_BASE + s.charAt(i)) % PRIME_MOD;

                        //System.out.println("Check : " + s.substring(start - mid + 1, start) + "     " + hash + "   " + m.get(hash));
                        found = check(t, m, hash, s, i - mid + 1, mid);
                        if (found)
                            break;
                    }
                }

                if (!found) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            return lo;
        }

        private long powerHash(int mid) {
            long power = 1;
            for (int i = 1; i <= mid - 1; i++) {
                power = (power * PRIME_BASE) % PRIME_MOD;
            }
            return power;
//            POWER = 1;
//            for (int i = 1; i <= M - 1; i++)
//                POWER = (PRIME_BASE * POWER) % PRIME_MOD;
        }

        static long hash(String s, int len) {
            long ret = 0;
            for (int i = 0; i < len; i++) {
                ret = (ret * PRIME_BASE + s.charAt(i)) % PRIME_MOD;
            }
            return ret;
        }

        private boolean check(String t, HashMap<Integer, ArrayList<Integer>> m, long h, String s, int start, int len) {
            int hash = (int) h;
            if (m.get(hash) == null)
                return false;
            for (int x : m.get(hash)) {
                boolean checks = true;
                for (int i = 0; i < len; i++) {
                    if (t.charAt(x + i) != s.charAt(start + i)) {
                        checks = false;
                        break;
                    }
                }
                if (checks)
                    return true;
            }
            return false;
        }

        private void put(HashMap<Integer, ArrayList<Integer>> m, long hash, int i) {
            int h = (int) hash;
            if (m.get(h) == null)
                m.put(h, new ArrayList<Integer>());
            m.get(h).add(i);
        }

    }
}




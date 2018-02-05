import java.io.*;
import java.util.*;

public class FindSubstrings {
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
        CF2 cf2 = new CF2();
        CF3 cf3 = new CF3();
//
//        String[] words = {"abccab"};
//        String[] parts = {"a", "ab", "bab", "bc", "bca", "c", "caa"};
//
//        String[] a = cf3.findSubstrings(words, parts);
//        for (String height : a)
//            System.out.println(height);

        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
        String[] parts = {"a", "mel", "lon", "el", "An"};

        String[] a = cf3.findSubstrings(words, parts);
        for (String x : a)
            System.out.println(x);

//        String[] words = {};
//        String[] parts = {};
//
//        String[] a = cf.findSubstrings(words, parts);
//        for( String height:a)
//            System.out.println(height);

//        String[] words = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "ba", "baa", "baaa", "baaaa", "baaaaa", "baaaaaa"};
//        String[] parts = {"a", "aa", "aaa", "aaaa", "aaaaa"};
//
//        String[] a = cf.findSubstrings(words, parts);
//        for (String height : a)
//            System.out.println(height);

//        for (int reps = 0; reps < 1; reps++) {
//
//            int lenWords = rand.nextInt(100);
//            int lenParts = rand.nextInt(100);
//
//            String[] words = new String[lenWords];
//            String[] parts = new String[lenParts];
//
//            HashSet<String> phs = new HashSet<>();
//            for (int i = 0; i < lenWords; i++) {
//                String s = "";
//                for (int j = 0; j < 20; j++) {
//                    s = s + String.valueOf((char) (rand.nextInt(5) + 'a'));
//                }
//                words[i] = s;
//            }
//
//            for (int i = 0; i < lenParts; i++) {
//                String s;
//                do {
//                    s = "";
//                    int len = rand.nextInt(4) + 1;
//
//                    for (int j = 0; j < len; j++) {
//                        s = s + String.valueOf((char) (rand.nextInt(5) + 'a'));
//                    }
//                } while (phs.contains(s));
//                phs.add(s);
//                parts[i] = s;
//            }
//
//        for (String w : words) {
//            System.out.println(w);
//        }
//
//        for (String w : parts) {
//            System.out.println(w);
//        }
//
//            String[] ac = cf.findSubstrings(words, parts);
//            String[] brute = cf2.findSubstrings(words, parts);
//
//            for (int i = 0; i < ac.length; i++) {
//                if (!ac[i].equals(brute[i])) {
//                    System.out.println("BAD:    " + ac[i] + "   " + brute[i]);
//                }
//            else
//                System.out.println("GOOD:   " + ac[i] + "   " + brute[i]);
//            }
//    }
//
//        String[] words = {"eabbaaacaecddcdecbdd",
//                "eaccdaacebeceadebeca"};
//        String[] parts = { "acd","c"};
//
//        String[] ac = cf.findSubstrings(words, parts);
//        String[] brute = cf2.findSubstrings(words, parts);
//
//        for (int i = 0; i < ac.length; i++) {
//            if (!ac[i].equals(brute[i])) {
//                System.out.println("BAD:    " + ac[i] + "   " + brute[i]);
//            } else
//                System.out.println("GOOD:   " + ac[i] + "   " + brute[i]);
//        }

    }

    static class CF {
        String[] findSubstrings(String[] words, String[] parts) {
            AhoCorasick ahoCorasick = new AhoCorasick(1000000);
            for (String part : parts) {
                ahoCorasick.addString(part);
            }

            ahoCorasick.print();

            String[] ret = new String[words.length];

            for (int w = 0; w < words.length; w++) {
                String word = words[w];
                int pos = -1;
                int maxLen = -1;
//                System.out.println(word);
                int node = 0;
//                List<Integer> positions = new ArrayList<>();
//                List<Integer> length = new ArrayList<>();
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    node = ahoCorasick.transition(node, ch);
                    if (ahoCorasick.nodes[node].leaf && ahoCorasick.nodes[node].depth > maxLen) {
                        maxLen = ahoCorasick.nodes[node].depth;
                        pos = i + 1;
                    }
                }
                if (pos >= 0) {
//                    System.out.println(word.substring(0, pos-maxLen) + "[" + word.substring(pos-maxLen, pos) + "]" +
//                            word.substring(pos));
                    ret[w] = word.substring(0, pos - maxLen) + "[" + word.substring(pos - maxLen, pos) + "]" +
                            word.substring(pos);
                } else {
                    //System.out.println(word);
                    ret[w] = words[w];
                }
//                System.out.println(positions);
//                System.out.println(length);
            }
            // return new String[]{};
            return ret;
        }

        static final int ALPHABET_SIZE = 65;

        public class Node {
            int parent;
            char charFromParent;
            int suffLink = -1;
            int[] children = new int[ALPHABET_SIZE];
            int[] transitions = new int[ALPHABET_SIZE];
            boolean leaf;
            int depth = -100;

            Node() {
                Arrays.fill(children, -1);
                Arrays.fill(transitions, -1);
            }

            private void print() {
                System.out.println("Parent  : " + parent);
                System.out.println("Char    : " + charFromParent);
                System.out.println("Suffix  : " + suffLink);
                System.out.println("In Dict : " + leaf);
                System.out.println("Children: ");
                for (int i = 0; i < children.length; i++) {
                    if (children[i] != -1)
                        System.out.print((i + ":" + children[i] + "  "));
                }
                System.out.println();
                System.out.println("Transistions: ");
                for (int i = 0; i < transitions.length; i++) {
                    if (transitions[i] != -1)
                        System.out.print(i + ":" + transitions[i] + "  ");
                }
                System.out.println();
            }
        }

        public class AhoCorasick {
            Node[] nodes;
            int nodeCount;
            ArrayList<ArrayList<String>> out;

            public AhoCorasick(int maxNodes) {
                out = new ArrayList<>();
                for (int i = 0; i < maxNodes; i++) {
                    out.add(new ArrayList<>());
                }
                nodes = new Node[maxNodes];
                // create root
                nodes[0] = new Node();
                nodes[0].suffLink = 0;
                nodes[0].parent = -1;
                nodes[0].depth = 0;
                nodeCount = 1;
            }

            public void print() {
                for (Node x : nodes) {
                    x.print();
                }
            }

            public void addString(String s) {
                int cur = 0;
                for (char ch : s.toCharArray()) {
                    int c = ch - 'A';
                    if (nodes[cur].children[c] == -1) {
                        nodes[nodeCount] = new Node();
                        nodes[nodeCount].parent = cur;
                        nodes[nodeCount].charFromParent = ch;
                        nodes[nodeCount].depth = nodes[cur].depth + 1;
                        nodes[cur].children[c] = nodeCount++;
                    }
                    cur = nodes[cur].children[c];
                }
                nodes[cur].leaf = true;
                out.get(cur).add(s);
                return;
            }

            public int suffLink(int nodeIndex) {
                Node node = nodes[nodeIndex];
                if (node.suffLink == -1)
                    node.suffLink = node.parent == 0 ? 0 : transition(suffLink(node.parent), node.charFromParent);
                return node.suffLink;
            }

            public int transition(int nodeIndex, char ch) {
                int c = ch - 'A';
                Node node = nodes[nodeIndex];
                if (node.transitions[c] == -1) {
                    if (node.children[c] != -1) {
                        node.transitions[c] = node.children[c];
                    } else {
                        node.transitions[c] = (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
                    }
                }
                return node.transitions[c];
            }
        }
    }

    static class CF2 {
        String[] findSubstrings(String[] words, String[] parts) {
            String[] ret = new String[words.length];

            for (int w = 0; w < words.length; w++) {
                String word = words[w];
                int pos = 10000000;
                int len = -1;
                for (int j = 0; j < parts.length; j++) {
                    String part = parts[j];
                    if (part.length() < len)
                        continue;
                    int idx = word.indexOf(part);
                    if (idx >= 0 && part.length() > len) {
                        len = part.length();
                        pos = idx;
                    } else if (idx >= 0 && part.length() == len && idx < pos) {
                        pos = idx;
                    }
                }
                if (len >= 0) {
                    ret[w] = word.substring(0, pos) + "[" + word.substring(pos, pos + len) + "]" +
                            word.substring(pos + len);
                } else {
                    ret[w] = words[w];
                }
            }
            return ret;
        }
    }

    static class CF3 {

        final int MAXS = 100000;
        final int MAXC = 64;

        ArrayList<HashSet<Integer>> out = new ArrayList<>();
        int[] f;
        int[][] g;
        int numKeys;

        String[] findSubstrings(String[] words, String[] parts) {
            for (int i = 0; i < MAXS; i++) {
                out.add(new HashSet<>());
            }
            f = new int[MAXS];
            g = new int[MAXS][MAXC];
            buildMatchingMachine(parts);

            String[] ret = new String[words.length];

            for (int w = 0; w < words.length; w++) {
                String word = words[w];
                int pos = -1;
                int maxLen = -1;

                int currentState = 0;
                for (int i = 0; i < word.length(); ++i) {
                    currentState = findNextState(currentState, word.charAt(i));

                    for (int j: out.get(currentState)) {
                        if( parts[j].length() > maxLen) {
                            maxLen = parts[j].length();
                            pos = i + 1;
                        }
                    }
                }
                if (pos >= 0) {
                    ret[w] = word.substring(0, pos - maxLen) + "[" + word.substring(pos - maxLen, pos) + "]" +
                            word.substring(pos);
                } else {
                    ret[w] = words[w];
                }
            }
            return ret;
        }

        int buildMatchingMachine(String arr[]) {
            numKeys = arr.length;
            for(int i = 0 ;i < g.length; i ++ ) {
                Arrays.fill(g[i], -1);
            }

            int states = 1;

            for (int i = 0; i < numKeys; ++i) {
                String word = arr[i];
                int currentState = 0;

                // Insert all characters of current word in arr[]
                for (int j = 0; j < word.length(); ++j) {
                    int ch = word.charAt(j) - 'A';
                    if (g[currentState][ch] == -1)
                        g[currentState][ch] = states++;

                    currentState = g[currentState][ch];
                }

                out.get(currentState).add(i);
            }

            for (int ch = 0; ch < MAXC; ++ch)
                if (g[0][ch] == -1)
                    g[0][ch] = 0;

            Arrays.fill(f, -1);

            Queue<Integer> q = new LinkedList<>();

            for (int ch = 0; ch < MAXC; ++ch) {
                if (g[0][ch] != 0) {
                    f[g[0][ch]] = 0;
                    q.add(g[0][ch]);
                }
            }

            while (!q.isEmpty()) {

                int state = q.remove();
                for (int ch = 0; ch < MAXC; ++ch) {
                    if (g[state][ch] != -1) {
                        int failure = f[state];

                        while (g[failure][ch] == -1)
                            failure = f[failure];

                        failure = g[failure][ch];
                        f[g[state][ch]] = failure;

                        out.get(g[state][ch]).addAll(out.get(failure));

                        q.add(g[state][ch]);
                    }
                }
            }

            return states;
        }

        int findNextState(int currentState, char nextInput) {
            int answer = currentState;
            int ch = nextInput - 'A';

            // If goto is not defined, use failure function
            while (g[answer][ch] == -1)
                answer = f[answer];

            return g[answer][ch];
        }
    }
}
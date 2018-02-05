package interview.DFSandBFS;

import java.util.Stack;

class LongestPath {
    public static void main(String[] args) {
       LongestPath lp = new LongestPath();
       System.out.println(lp.longestPath("a\f\tb\f\t\tc.txt"));
    }

    int longestPath(String fileSystem) {
        String[] sp = fileSystem.split("\f");
        for (String p : sp) {
            System.out.println(p);
        }

        Stack<Integer> st = new Stack<>();
        int[] dirLength = new int[sp.length];
        boolean[] isFile = new boolean[sp.length];
        for (int node = 0; node < sp.length; node++) {
            int node_count = 0;
            //while (sp[node].charAt(2 * node_count) - 92 == 0 && sp[node].charAt(2 * node_count + 1) - 116 == 0)
            while (sp[node].charAt(node_count) - 9 == 0 )
                node_count++;
            if (node_count == 0) {
                dirLength[node] = sp[node].length();
                isFile[node] = sp[node].indexOf(".") >= 0;
                st.push(node);
            }
        }

        while (!st.isEmpty()) {
            int node = st.pop();
            int next = node + 1;

            int node_count = 0;
            //while (sp[node].charAt(2 * node_count) - 92 == 0 && sp[node].charAt(2 * node_count + 1) - 116 == 0)
            while (sp[node].charAt(node_count) - 9 == 0 )
                node_count++;

            while (next < sp.length) {
                int count = 0;
                //while (sp[next].charAt(2 * count) - 92 == 0 && sp[next].charAt(2 * count + 1) - 116 == 0)
                while (sp[next].charAt(count) - 9 == 0 )
                    count++;

                if (count <= node_count) {
                    break;
                }

                dirLength[next] = dirLength[node] + sp[next].length() - (count) + 1;

                if (sp[next].indexOf(".") < 0) {
                    st.push(next);
                } else {
                    isFile[next] = true;
                }
                next++;
            }
        }

        int max = 0;
        for (int i = 0; i < dirLength.length; i++) {
            System.out.println(i + "  " + isFile[i] + "   " + dirLength[i]);
            if (isFile[i] && dirLength[i] > max) {
                max = dirLength[i];
            }
        }
        return max;
    }
}
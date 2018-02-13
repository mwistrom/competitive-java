package recursion;

import java.io.*;
import java.util.*;

public class ThePowerSum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int n = in.nextInt();

        int ans = dp(x - 1, n, 2) + dp(x, n, 2);
        System.out.println(ans);
    }

    private static int dp(int x, int n, int pow) {
        if( x < 0)
            return 0;
        if( x == 0)
            return 1;
        int p = 1;
        for(int i = 0 ;i < n; i++)
            p = p * pow;
        if( x - p < 0)
            return 0;
        return dp( x - p, n, pow + 1) + dp(x, n, pow+1);
    }
}
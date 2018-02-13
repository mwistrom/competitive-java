package tasks;

// Don't place your source in a package

import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int sum = 0;
        int min = 1000;
        int max = -1;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            max = Math.max(a, max);
            min = Math.min(a, min);
            sum += a;
        }

        sum = sum - max - min;

        System.out.print(sum / (n -2));
    }
}
package tasks;
// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Encipherment {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();

        StringBuilder sb = new StringBuilder();
        for( char c : s.toCharArray()) {
            int x = c - 'a';
            sb.append( p.charAt(x));
        }

        System.out.print(sb.toString());
    }
}
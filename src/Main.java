//https://www.codechef.com/problems/LEPERMUT

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bi = getBufferedReader();
        String line;
        line=bi.readLine();
        int t=getIntegerFromString(line);
        for (int i = 0; i < t; i++) {
            line=bi.readLine();
            int n=getIntegerFromString(line);
            line=bi.readLine();
            String a[]=getSplitSpace(line);
            int a1[]=new int[n];
            for (int j = 0; j < a.length; j++) {
                a1[j]=getIntegerFromString(a[j]);
            }
            isGoodPermutation(a1);
        }
    }

    private static void isGoodPermutation(int[] a) {
        if(a.length==0 || a.length==1)
            System.out.println("YES");
        else {
            if(getLocalInversions(a)==getInversions(a))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static int getInversions(int[] a) {
        return getInversionCount(a, 0, a.length-1, (a.length-1)/2);
    }

    private static int getInversionCount(int[] a, int l, int r, int m) {
        return 0;
    }

    private static int getLocalInversions(int[] a) {
        int result=0;
        for (int i = 1; i < a.length; i++) {
            if(a[i]>a[i-1]) result++;
        }
        return result;
    }

}

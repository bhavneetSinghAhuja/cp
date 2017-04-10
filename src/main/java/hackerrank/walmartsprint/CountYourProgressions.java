package hackerrank.walmartsprint;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by bhavneet.ahuja on 30/10/16.
 */
public class CountYourProgressions {
    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bi = getBufferedReader();
        String line=bi.readLine();
        int n =getIntegerFromString(line);
        int a[]=new int[n];
        for (int i = 0; i <n; i++) {
            line=bi.readLine();
            a[i]=getIntegerFromString(line);
        }
        System.out.println(printAp1(a));
    }

    private static int printAp1(int[] a) {
        int result=0;
        result+=1+ a.length+(a.length*(a.length-1))/2;
        int n =a.length;
        int count=0;
        for (int i = 0; i < (n - 2); i++) {
            for (int j = i+1; j < n-1; j++) {
                int d=a[j]-a[i];
                count=0;
                for (int k = j+1; k < n; k++) {
                    if (a[k]-a[j]==d) {count++;}
                }
                result+=count;
            }
        }
        return result;
    }


}

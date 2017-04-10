package hackerrank.walmartsprint;

import hackerearth.walmart.TestClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by bhavneet.ahuja on 30/10/16.
 */
public class EmmaAndCamera {
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
        int n=getIntegerFromString(line);
        line=bi.readLine();
        int x=getIntegerFromString(line);
        int frames= (int) (Math.pow(2, n) -1);
        System.out.println(Math.abs(frames-x));
    }
}

package google.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by bhavneet.ahuja on 09/04/17.
 */
public class BathroomStalls {
    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s+");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static HashSet<String> allSubsets = new HashSet<>();

    private static final String token = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = getBufferedReader();
        String line = br.readLine();
        int t = getIntegerFromString(line);
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            System.out.println("Case #" + (i + 1) + ": " + getLeftAndRightDistance(line));
        }
    }

    private static String getLeftAndRightDistance(String line) {
        String lines[]=getSplitSpace(line);
        Integer n=getIntegerFromString(lines[0]);
        Integer k=getIntegerFromString(lines[1]);
        Integer maxDiff=Integer.MIN_VALUE;
        Integer maxL=Integer.MIN_VALUE;
        Integer maxR=Integer.MIN_VALUE;

        return null;
    }
}

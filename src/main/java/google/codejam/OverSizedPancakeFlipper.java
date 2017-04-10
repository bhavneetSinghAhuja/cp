package google.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by bhavneet.ahuja on 08/04/17.
 */
public class OverSizedPancakeFlipper {

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
            String lines[] = getSplitSpace(line);
            System.out.println("Case #"+(i+1)+": " + minNumberOfFlip(new StringBuilder(lines[0]), getIntegerFromString(lines[1])));
        }
    }

    private static String minNumberOfFlip(StringBuilder pancakeRow, int flipperSize) {
        int flipperStart = 0;
        int flipperEnd = flipperSize - 1;
        int flipCount=0;
        while (flipperEnd < pancakeRow.length()) {
            int sadFaceIndex=pancakeRow.indexOf("-");
            if(sadFaceIndex==-1) return String.valueOf(flipCount);
            flipperStart=sadFaceIndex;
            flipperEnd=flipperStart+flipperSize-1;
            if(!(flipperEnd<pancakeRow.length())) return "IMPOSSIBLE";
            for (int i = flipperStart; i <=flipperEnd; i++) {
                if (pancakeRow.charAt(i)=='+') pancakeRow.setCharAt(i,'-');
                else pancakeRow.setCharAt(i,'+');
            }
            flipCount++;
        }
        return null;
    }
}

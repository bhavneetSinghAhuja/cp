package google.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created by bhavneet.ahuja on 08/04/17.
 */
public class TidyNumber {
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
            System.out.println("Case #" + (i + 1) + ": " + getLastTidyNumber(line));
        }
    }

    private static String getLastTidyNumber(String line) {
        Integer n;
        if (line.length() == 1) return line;
        if (line.length() > 9) return getLastTidyNumberBigInt(line);
        else {
            n = getIntegerFromString(line);
            while (true && n>9) {
                boolean flag = true;
                String s = n.toString();
                int i = 1;
                while (flag && i < s.length()) {
                    if ((s.charAt(i - 1) - '0') > (s.charAt(i) - '0')) flag = false;i++;
                }
                if (flag) return String.valueOf(n);
                n--;
            }
        }
        return String.valueOf(n);
    }

    private static String getLastTidyNumberBigInt(String line) {
        BigInteger n = new BigInteger(line);
        while (!allDigitNonDecreasing(n)) {
            n.subtract(BigInteger.valueOf(1));
        }
        return n.toString();
    }

    private static boolean allDigitNonDecreasing(BigInteger n) {
        boolean flag = true;
        String s = n.toString();
        int i = 1;
        while (flag && i < s.length()) {
            if ((s.charAt(i - 1) - '0') > (s.charAt(i) - '0')) flag = false;
        }
        return flag;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavneet.ahuja on 14/06/16.
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParantheses {
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
        int n=getIntegerFromString(line);
        System.out.println(generateParentheses(n));
    }

    private static List<String> generateParentheses(int n) {
        List<String> result=new ArrayList<String>();
        generateParenthesesUtil(n, result, "", 0,0);
        return result;
    }

    private static void generateParenthesesUtil(int n, List<String> result, String s, int openBraces, int closedBraces) {
        if(openBraces==n && closedBraces==n){
            result.add(s); return;
        }
        if (openBraces==n && closedBraces<n){
            s+=")";
        }
        else{
            if(openBraces==closedBraces){
                s+="(";
            }

        }
    }
}

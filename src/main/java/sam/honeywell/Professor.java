package sam.honeywell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class Professor {
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
        BufferedReader br=getBufferedReader();
        String line=br.readLine();
        Integer n=getIntegerFromString(line);
        line=br.readLine();
        String[] lines=getSplitSpace(line);
        line=br.readLine();
        Integer q=getIntegerFromString(line);

        for (int i = 0; i < q; i++) {
            line=br.readLine();
            String pair[]=getSplitSpace(line);
            Integer left=Integer.parseInt(pair[0]);
            Integer right=Integer.parseInt(pair[1]);
            lines=swap(lines,left-1, right-1);
        }
        printOutput(lines);
    }

    private static void printOutput(String[] lines) {
        String result="";
        for (int i = 0; i < lines.length; i++) {
            result=result+lines[i]+" ";
        }
        System.out.println(result.trim());
    }

    private static String[] swap(String[] arr, Integer left, Integer right) {
        int n=arr.length;
        if(n%2==1){
            if (right > (n/2)) right=n-right-1;
        }
        else{
            if(right> (n/2 -1)) right=n - 2 - right;
        }
        for (int i = left; i <= right; i++) {
            String temp=arr[i];
            arr[i]=arr[arr.length - i - 1];
            arr[arr.length - i - 1]=temp;
        }
        return arr;
    }

    class Pair{
        Integer first;
        Integer second;
    }
}

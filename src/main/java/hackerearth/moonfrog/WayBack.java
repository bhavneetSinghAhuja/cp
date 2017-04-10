package hackerearth.moonfrog;
/**
 * Created by bhavneet.ahuja on 05/11/16.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WayBack {

    public static final String BEGIN = "Begin";
    public static final String LEFT = "Left";
    public static final String RIGHT = "Right";

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
        String line=bi.readLine();
        int n=getIntegerFromString(line);

        String a[]=new String[n];
        for (int i = 0; i < n; i++) {
            line=bi.readLine();
            a[i]=line;
        }

        for (int i = 1; i < n; i++) {
            if(a[i].contains(BEGIN)){
                System.out.println("error");
            }
            else if (a[i].contains(LEFT)){
                a[i-1]=RIGHT+a[i-1].substring(a[i-1].indexOf(" "), a[i-1].length());
            }
            else if(a[i].contains(RIGHT)){
                a[i-1]=LEFT+a[i-1].substring(a[i-1].indexOf(" "), a[i-1].length());
            }
        }
        a[n-1]=BEGIN+ a[n-1].substring(a[n-1].indexOf(" "), a[n-1].length());

        for (int i = n-1; i >=0 ; i--) {
            System.out.println(a[i]);
        }
    }



}

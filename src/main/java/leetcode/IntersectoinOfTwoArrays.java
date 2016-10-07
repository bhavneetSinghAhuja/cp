package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bhavneet.ahuja on 14/06/16.
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectoinOfTwoArrays {

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
        String a1[]=getSplitSpace(line);
        line=bi.readLine();
        String b1[]=getSplitSpace(line);
        int a[]=getIntegerArrayFromStringArray(a1);
        int b[]=getIntegerArrayFromStringArray(b1);
        System.out.println(intersection(a,b));
    }

    private static int[] intersection(int[] a, int[] b) {
        int result[] = new int[a.length<b.length?a.length:b.length];
        int count=0;
        Arrays.sort(a);
        Arrays.sort(b);
        int[] c,d;
        if(a.length<b.length){
            c=a;
            d=b;
        }
        else{
            c=b;
            d=a;
        }
        int i=0,j=0;
        while(i<c.length && j<d.length){
            if(c[i]==d[j]){
                if(count>0){
                    if(result[count-1]!=c[i]){
                        count++;
                        result[count-1]=c[i];
                    }
                }
                else{
                    count++;
                    result[count-1]=c[i];
                }
                i++;j++;
            }
            else if(c[i]>d[j]){
                j++;
            }
            else{
                i++;
            }
        }
        int[] res=new int[count];
        for (int k = 0; k < count; k++) {
            res[k]=result[k];
        }
        return res;
    }

    private static int[] getIntegerArrayFromStringArray(String[] a1) {
        int a[]=new int[a1.length];
        for (int i = 0; i < a1.length; i++) {
            a[i]=Integer.parseInt(a1[i]);
        }
        return a;
    }
}

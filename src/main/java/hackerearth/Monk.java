package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Monk {
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
        String a[]=getSplitSpace(line);
        Integer b[]=new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i]=getIntegerFromString(a[i]);
        }
        line=br.readLine();
        int n=getIntegerFromString(line);
        int[][] c=new int[n][4];
        for (int i = 0; i < n; i++) {
            line=br.readLine();
            String s[]=getSplitSpace(line);
            for (int j = 0; j < 4; j++) {
                c[i][j]=getIntegerFromString(s[j]);
            }
        }
        System.out.println(printResultDp(n, b,c));
    }

    private static String printResultDp(int n, Integer[] b, int[][] c) {

        int[] first=new int[n];
        for (int i = 0; i < n; i++) {
            first[i]=c[i][0];
        }

        Monk.findTargetSumSubsets(first, b[0], "", 0);

        if (allSubsets.size()==0) return "NO";
        for (String subset : allSubsets) {
            String[] s=getSplitSpace(subset);
            boolean[] flag=new boolean[]{true,true,true,true};
            int indexes[]=new int[s.length];
            for (int i = 0; i < s.length; i++) {
                indexes[i] =getIntegerFromString(s[i]);
            }
            for (int i = 1; i < 4; i++) {
                int sum=0;
                for (int j = 0; j < indexes.length; j++) {
                    sum+=c[indexes[j]][i];
                }
                if(sum!=b[i]) flag[i]=false;
            }
            if(flag[1] && flag [2] && flag[3]) return "YES";
        }

        return "NO";
    }

    public static void findTargetSumSubsets(int[] input, int target, String ramp, int index) {

        if(index > (input.length - 1)) {
            if(getSum(ramp,input) == target) {
                allSubsets.add(ramp);
            }
            return;
        }

        //First recursive call going ahead selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp + index + token, index + 1);
        //Second recursive call going ahead WITHOUT selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp, index + 1);
    }

    private static int getSum(String intString, int[] input) {
        int sum = 0;
        StringTokenizer sTokens = new StringTokenizer(intString, token);
        while (sTokens.hasMoreElements()) {
            sum += input[Integer.parseInt((String) sTokens.nextElement())];
        }
        return sum;
    }


    private static String printResult(int n, Integer[] diet, int[][] fruits) {
        for (int i = 0; i < 4; i++) {
            int sum=0;
            for (int j = 0; j < n; j++) {
                sum+=fruits[j][i];
            }
            if(sum<diet[i]) return "NO";
        }
        return "YES";
    }
}

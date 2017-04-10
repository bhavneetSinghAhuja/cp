package google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TidyNumbers2 {


    Boolean verifycurrent(String s) {
        if (s.length() == 1)
            return true;
        else
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) > s.charAt(i + 1))
                    return false;

            }
        return true;
    }

    String removeZero(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                return s.substring(i);
        }
        return "0";
    }

    String calString(char[] c, int index9, int length) {

        for (int i = index9; i < length; i++)
            c[i] = '9';
        return String.valueOf(c);
    }

    String compareString(String s1, String s2) {
        if (s1.compareTo(s2) > 0)
            return s1;
        else
            return s2;
    }

    String tidynum(String s) {
        int length = s.length();
        char[] c;
        c = s.toCharArray();
        char[] c1 = new char[length];
        String max = "0";
        int index9 = 0;
        int num;
        char temp;
        for (int i = length - 1; i >= 0; i--) {
            if (c[i] != '0') {
                num = c[i] - 1;
                c1[i] = (char) num;
                //System.out.println("   c1[i]   "+c1[i]);
                temp = c1[i];
                index9 = i + 1;
                int j = 0;
                for (j = i - 1; j >= 0; j--) {
                    // System.out.println("i"+i+" j"+j);
                    if (c[j] != '0')

                    {
                        if (temp > c[j])
                            temp = c[j];

                        //temp=(char)Math.min(temp,c[j]);
                        c1[j] = temp;
                        // System.out.println("   c1[i]   "+c1[i]);
                    } else {
                        break;
                    }
                }
                if (j >= 0)
                    continue;
                else {
                    String cmp = calString(c1, index9, length);
                    //System.out.println("cmppp "+cmp+"   "+max);
                    max = compareString(max, cmp);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        String s;
        TidyNumbers2 ob = new TidyNumbers2();
        for (int i = 0; i < N; i++) {
            String stemp = br.readLine();
            if (ob.verifycurrent(stemp))
                System.out.println("Case #" + (i + 1) + ":" + " " + stemp);
            else
                System.out.println("Case #" + (i + 1) + ":" + " " + ob.removeZero(ob.tidynum(stemp)));
        }
    }
}
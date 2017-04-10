package twitter;

import java.util.Arrays;

/**
 * Created by bhavneet.ahuja on 13/11/16.
 */
public class HackingTime {
//    static String decrypt(String encrypted_message){
//        String end="Your"
//    }
//
//    static String calculateKey(String key){
//
//    }

    // return the longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String s) {

        // form the N suffixes
        int N  = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }

        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
        String s = "2512208251220";
        s = s.replaceAll("\\s+", " ");
        String s1=lrs(s);
        System.out.println("'" + s1 + "'");
        int first=s.indexOf(s1);
        int second= s.indexOf(s1, s1.indexOf(s1) +1);
        System.out.println(s.substring(first, second));
        String orig="Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
        String s2=orig.substring(0, orig.indexOf("-"));
//        System.out.println(numberOfChar(s2));
    }



//    private static int numberOfChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i))
//        }
//    }
}

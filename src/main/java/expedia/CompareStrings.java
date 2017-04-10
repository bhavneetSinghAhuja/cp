package expedia;

/**
 * Created by bhavneet.ahuja on 15/03/17.
 */
public class CompareStrings {
    public static void main(String[] args) {
        String s1="bhabhavneet";
        String s2="bhav";
        System.out.println(containsString(s1,s2));
    }

    private static boolean containsString(String s1, String s2) {
        if(s1==null || s2==null || s1.isEmpty() || s2.isEmpty() || (s1.length() < s2.length())) return false;

        return compareStringNaive(s1,s2);
    }

    private static boolean compareStringNaive(String s1, String s2) {
        for (int i = 0; i < s1.length();) {
            int j=0;
            while(j<s2.length()){
                if(s1.charAt(i)==s2.charAt(j)){
                    j++;
                }
                else break;
                i++;
            }
            if (j==s2.length()) return true;
        }
        return false;
    }
}

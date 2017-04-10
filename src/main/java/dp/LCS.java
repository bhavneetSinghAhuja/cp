//package dp;
//
//import java.util.*;
//
///**
// * Created by bhavneet.ahuja on 15/11/16.
// * http://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
// */
//public class LCS {
//
//    public static final String AAA = "aaa";
//    public static final String AB = "ab";
//    public static final String ABCABCAA = "abcabcaa";
//    public static final String ACBACBA = "acbacba";
//
//    public static int findLCS(String s1, String s2){
//        int result=findLCSUtil(s1,0,s2,0);
//        System.out.println(result);
//        return result;
//    }
//
//    public static int findLCSDP(String s1, String s2){
//        if(s1.length()==0 || s2.length()==0) return 0;
//
//        int m=s1.length();
//        int n=s2.length();
//        int a[][]=new int[m+1][n+1];
//
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if(i==0 || j==0) {
//                    a[i][j]=0;
//                }
//                else if(s1.charAt(i-1)==s2.charAt(j-1))
//                    a[i][j]=1+a[i-1][j-1];
//                else a[i][j]=max(a[i-1][j],a[i][j-1]);
//            }
//        }
//        return a[m][n];
//    }
//
//    private static int findLCSUtil(String s1, int m, String s2, int n) {
//        if(m>=s1.length() || n>=s2.length()) return 0;
//
//        if(s1.charAt(m)==s2.charAt(n)){
//            return 1+findLCSUtil(s1,m+1, s2, n+1);
//        }
//        else return max(findLCSUtil(s1, m+1, s2,n), findLCSUtil(s1,m,s2,n+1));
//    }
//
//    private static int max(int left, int right) {
//        if(left>right) return left;
//        else return right;
//    }
//
//    public static void main(String[] args) {
////        findLCS(AAA, AB);
////        System.out.println(findLCSDP(AAA,AB));
////        printAllLCS(ABCABCAA, ACBACBA);
//        printAllLCSDP(ABCABCAA,ACBACBA);
//    }
//
//    private static int printAllLCSDP(String s1, String s2) {
//        if(s1.length()==0 || s2.length()==0) return 0;
//        int m=s1.length();
//        int n=s2.length();
//        String a[][]=new String[m+1][n+1];
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if(i==0 || j==0) {
//                    a[i][j]="";
//                }
//                else if(s1.charAt(i-1)==s2.charAt(j-1))
//                    a[i][j]=a[i-1][j-1]+s1.charAt(i-1);
//                else {
//                    if(a[i-1][j].length()>a[i][j-1].length())
//                    a[i][j]=a[i-1][j];
//                    else a[i][j]=a[i][j-1];
//                }
//            }
//        }
//    }
//
//    private static void printAllLCS(String s1, String s2) {
//        Set<String> allLCS= new HashSet<>();
//        List<String> result=new ArrayList<>();
//        String s="";
//        findAllLCS(s1, 0, s2, 0, s, allLCS);
//        Integer max=Integer.MIN_VALUE;
//        for (String s3 : allLCS) {
//            if(s3.length()>max) max=s3.length();
//        }
//        for (String s3 : allLCS) {
//            if(s3.length()==max) result.add(s3);
//        }
//        Collections.sort(result);
//        result.forEach(System.out::println);
//    }
//
//    private static void findAllLCS(String s1, int m, String s2, int n, String currentLCS, Set<String> allLCS) {
//        if(m>=s1.length() || n>= s2.length()) {
//            allLCS.add(currentLCS);
//            return;
//        }
//        if (s1.charAt(m)==s2.charAt(n)){
//            String s=currentLCS+s1.charAt(m);
//            findAllLCS(s1,m+1, s2, n+1,s, allLCS);
//        }
//        else {
//            findAllLCS(s1,m+1, s2, n, currentLCS, allLCS);
//            findAllLCS(s1,m,s2,n+1, currentLCS, allLCS);
//        }
//    }
//}

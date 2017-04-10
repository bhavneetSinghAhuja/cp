package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w24/challenges/apple-and-orange
 * Created by bhavneet.ahuja on 10/10/16.
 */
public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int numberOfApples=0,numberOfOranges=0;
        int temp;
        for(int apple_i=0; apple_i < m; apple_i++){
            temp = in.nextInt();
            temp+=a;
            if(temp>=s && temp<=t)
                numberOfApples++;
        }

        for(int orange_i=0; orange_i < n; orange_i++){
            temp= in.nextInt();
            temp+=b;
            if(temp>=s && temp<=t)
                numberOfOranges++;
        }
        System.out.println(numberOfApples);
        System.out.println(numberOfOranges);
    }

}

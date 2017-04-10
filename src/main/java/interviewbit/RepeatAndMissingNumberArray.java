package interviewbit;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by bhavneet.ahuja on 01/03/17.
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * You are given a read only array of n integers from 1 to n.
 * <p>
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * <p>
 * Return A and B.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Note that in your output A should precede B.
 */
public class RepeatAndMissingNumberArray {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
//        Integer n=a.size();

        BitSet temp = new BitSet(a.size());
        Integer first = null, second = null;
        for (Integer integer : a) {
            if (temp.get(integer - 1)) first = integer;
            else temp.set(integer - 1);
        }

        for (int i = 0; i < temp.size(); i++) {
            if (!temp.get(i)) {
                second = i + 1;
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        return result;
    }

    public ArrayList<Integer> repeatedNumberWithoutExtraSpace(final List<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();
        double s1 = 0, s2, s3 = 0, s4 = 0;
        Integer n = input.size();
        for (Integer e : input) {
            s1 += e;
        }
        s2 = (n * (n + 1)) / 2;
        double d1 = s1 - s2;
        double d2;
        for (Integer e : input) {
            s3 = (s3 + ((e % d1) * (e % d1)) % d1) % d1;
        }
        s3 = s3 % d1;

        for (int i = 1; i <= n; i++) {
            s4 = (s4 + ((i % d1) * (i % d1)) % d1) % d1;
        }
        s4 = s4 % d1;
        d2 = (s3 - s4) % d1;
        result.add((int) ((d1 + d2) / 2));
        result.add((int) ((d2 - d1) / 2));
        return result;
    }

    public static void main(String[] args) {
        RepeatAndMissingNumberArray object = new RepeatAndMissingNumberArray();
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(3);
        System.out.println(object.repeatedNumber(input).toString());
        System.out.println(object.repeatedNumberWithoutExtraSpace(input).toString());
    }
}

//IB's solution

//    public class Solution {
// DO NOT MODIFY THE LIST
//        public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
//
//            ArrayList<Integer> res = new ArrayList<>();
//
//            Collections.sort(A);
//            int n = A.size();
//            int rep = -1;
//            int miss = -1;
//            long sum = A.get(0);
//
//            for (int i = 1; i < n; i++) {
//                if (A.get(i).intValue() == A.get(i - 1).intValue()) {
//                    rep = A.get(i);
//                }
//                sum += A.get(i);
//            }
//
//            miss = (int) ((1L * n * (1L * n + 1)) / 2 - sum + rep);
//
//            res.add(rep);
//            res.add(miss);
//
//            return res;
//
//        }
//    }




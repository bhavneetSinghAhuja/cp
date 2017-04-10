package interviewbit;

import java.util.ArrayList;

/**
 * Created by bhavneet.ahuja on 02/03/17.
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> temp1=new ArrayList<>();
        int temp, carry=1;
        for (int i = (a.size()-1); i >=0 ; i--) {
            temp=a.get(i);
            temp=temp+carry;
            if(temp>9){
                carry=temp/10;
                temp=temp%10;
            }
            else carry=0;
            temp1.add(temp);
        }
        if (carry>0) temp1.add(carry);
        ArrayList<Integer> result=new ArrayList<>();
        for (int i = (temp1.size()-1); i >=0 ; i--) {
            result.add(temp1.size() - 1 - i,temp1.get(i));
        }
        while(true){
            if(result.get(0)!=0) break;
            else result.remove(0);
        }
        return result;
    }

    public static void main(String[] args) {
        AddOneToNumber addOneToNumber=new AddOneToNumber();
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(addOneToNumber.plusOne(a).toString());
    }
}

//IB solution
//public class Solution {
//    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
//
//        int size;
//        int carry = 1;
//        int num;
//
//        size = A.size();
//
//        for (int i = size - 1; i >= 0; i--) {
//
//            num = A.get(i);
//            num += carry;
//            carry = 0;
//
//            if (num == 10) {
//                num = 0;
//                carry = 1;
//            }
//
//            A.set(i, num);
//
//        }
//
//        ArrayList<Integer> res = new ArrayList<Integer>();
//
//        if (carry == 1)
//            res.add(1);
//
//        for (int x : A) {
//            if (x == 0 && res.size() == 0)
//                continue;
//            res.add(x);
//        }
//
//        return res;
//
//    }
//}


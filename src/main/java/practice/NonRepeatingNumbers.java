package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**Given a range find all the numbers with non repeating digits
 * Created by bhavneet.ahuja on 30/09/16.
 */
public class NonRepeatingNumbers {
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
        Integer first=getIntegerFromString(line);
        line=bi.readLine();
        Integer second=getIntegerFromString(line);
        List<Integer> numbers=new ArrayList<>();
        findNonRepeatingNumbers(numbers, first, second);
        System.out.println("output");
        numbers.forEach(System.out::println);
    }

    private static void findNonRepeatingNumbers(List<Integer> numbers, Integer first, Integer second) {
        for(int i=1; i<=9;i++){
            Set<Integer> digit = null;
            findNonRepeatingNumbersUtil(numbers, first, second,i,digit);
        }
    }

    private static void findNonRepeatingNumbersUtil(List<Integer> numbers, Integer first, Integer second, Integer number, Set<Integer> digit) {
        if(number>second) return;
        if(number>=first && number <=second) numbers.add(number);
        if(number<10){
            digit=new HashSet<>();
            digit.add(number);
        }

//        Set<Integer> digit=constructDigit(number);
        for (int i = 0; i < 10; i++) {
            if (!digit.contains(i)) {
                digit.add(i);
                findNonRepeatingNumbersUtil(numbers, first, second, number * 10 + i, digit);
            }
        }
        return;
    }

    private static Set<Integer> constructDigit(Integer number) {
        Set<Integer> result=new HashSet<>();
        while(number>0){
            int rem=number%10;
            result.add(rem);
            number=number/10;
        }
        return result;
    }
}

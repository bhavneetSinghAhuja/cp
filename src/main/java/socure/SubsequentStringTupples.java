package socure;


import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavneet.ahuja on 20/01/17.
 */
public class SubsequentStringTupples {
    public static void main(String[] args) {
        String test1="aaabccaa";
        String test2="a";
//        printSubsequentTupples(test1);
//        printSubsequentTupples(test2);
        List<Pair<Character, Integer>> result=new ArrayList<>();
        for (int i = 0; i < test1.length(); i++) {
            result=callback(test1.charAt(i),result);
        }
        printResult(result);
    }

    private static void printResult(List<Pair<Character, Integer>> result) {
        for (Pair<Character, Integer> characterIntegerPair : result) {
            System.out.println("character="+characterIntegerPair.getValue0()+" value="+characterIntegerPair.getValue1());
        }
    }

    private static void printSubsequentTupples(String str) {
        List<Pair<Character, Integer>> result=new ArrayList<>();
        int i=0;
        Pair<Character, Integer> pair = null;
        while(i<str.length()){
            if(i==0){
                pair=new Pair<>(str.charAt(i), 1);
            }
            else if (pair.getValue0()==str.charAt(i)){
                pair=new Pair<>(pair.getValue0(), pair.getValue1()+1);
            }
            else{
                result.add(pair);
                pair=new Pair<>(str.charAt(i), 1);
            }
            i++;
        }
        result.add(pair);

        printResult(result);
    }
    private static List<Pair<Character, Integer>> callback(Character current, List<Pair<Character, Integer>> state){
        Pair<Character, Integer> newPair;
        if (state.size()==0){
            newPair=new Pair<>(current,1);
        }
        else if(current==state.get(state.size()-1).getValue0()){
            Pair<Character, Integer> pair=state.get(state.size()-1);
            newPair=new Pair<>(current, pair.getValue1()+1);
            state.remove(state.size()-1);

        }
        else {
            newPair=new Pair<>(current,1);
        }
        state.add(newPair);
        return state;
    }
}

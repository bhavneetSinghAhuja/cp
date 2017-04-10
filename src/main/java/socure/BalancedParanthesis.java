package socure;

import java.util.Stack;

/**
 * Created by bhavneet.ahuja on 20/01/17.
 */
public class BalancedParanthesis {
    public static void main(String[] args) {
        String test1 = "(a)(b)(c)";//true
        String test2 = "(){}[]";//true
        String test3 = "(])";//false
        String test4 = "([)]";//false
        String test5 = ")(((({{{[]}}}))))";
//        System.out.println(checkBalancedParanthesis(test1));
//        System.out.println(checkBalancedParanthesis(test2));
//        System.out.println(checkBalancedParanthesis(test3));
//        System.out.println(checkBalancedParanthesis(test4));
        System.out.println(checkBalancedParanthesis(test5));
    }

    private static boolean checkBalancedParanthesis(String str) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                characterStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (characterStack.size()==0) return false;
                Character character = characterStack.pop();
                if (c == ')') {
                    if (!(character == '(')) return false;
                } else if (c == '}') {
                    if (!(character == '{')) return false;
                } else if (c == ']')
                    if (!(character == '[')) return false;
            }
        }

        if (characterStack.size() != 0) return false;
        return true;
    }
}

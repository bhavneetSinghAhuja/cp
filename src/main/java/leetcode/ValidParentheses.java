package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by bhavneet.ahuja on 14/06/16.
 */
public class ValidParentheses {
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
        System.out.println(isValid(line));
    }

    private static boolean isValid(String line) {
        Stack<Character> st=new Stack<Character>();
        for (int i = 0; i < line.length(); i++) {
            if(st.empty()) st.push(line.charAt(i));
            else{Character character=line.charAt(i);
                if(character.compareTo(')')==0){
                    Character ch=st.pop();
                    if(ch!='(') return false;
                }
                else if(character.compareTo(']')==0){
                    Character ch=st.pop();
                    if(ch!='[') return false;
                }
                else if(character.compareTo('}')==0){
                    Character ch=st.pop();
                    if(ch!='{') return false;
                }
                else st.push(character);
            }
        }
        if(st.empty()) return true;
        return false;
    }
}

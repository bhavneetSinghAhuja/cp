package expedia;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bhavneet.ahuja on 16/03/17.
 */
public class SudokuChecker {
    public static void main(String[] args) {
        int a[][] = new int[9][9];// false
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j]=j;
            }
        }
        System.out.println(checkValidSudoku(a));
    }

    private static boolean checkValidSudoku(int[][] a) {
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if (checkValidBlock(a,i,j)) return false;
            }
        }

        //TODO Other validations
        return true;
    }

    private static boolean checkValidBlock(int[][] a, int i, int j) {
        Set<Integer> content=new HashSet<>();
        for (int k = i; k < (i+3); k++) {
            for (int l = j; l <(j+3) ; l++) {
                if (content.contains(a[k][l])) return false;
                content.add(a[k][l]);
            }
        }
        return checkOneToNince(content);
    }

    private static boolean checkOneToNince(Set<Integer> content) {
        for (int i = 1; i < 10; i++) {
            if (!content.contains(i)) return false;
        }
        return true;
    }
}

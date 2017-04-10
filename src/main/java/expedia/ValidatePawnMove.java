package expedia;

/**
 * Created by bhavneet.ahuja on 16/03/17.
 * Usecase
 * 1) Forward 2 steps or 1 step, empty chessboard.
 * 2) Diagonal 1 step leading or non leading diagonal
 * 3) If reached last row which is 8th since down to up is what we are dealing with, after that no valid move
 * 4) Can't go below row 2
 */
public class ValidatePawnMove {
    public static void main(String[] args) throws Exception {
        Integer currentX = 2, currentY =2 , targetX = 3, targetY = 3;

        // 0 0 0 0
        // -1 -1 -1 -1
        // -1 -1 3 3
        // 2 2 3 3
        // 0 1 -1 1
        // 0 1 -1 2
        // 0 1 1 2
        // 0 1 2 2
        // 7 1 8 1
        //7 1 8 2
        // 7 1 8 1
        // 7 7 7 8
        // 2 2 1 1
        // 1 1 1 1 //TODO to be handled

        System.out.println(validatePawnMove(currentX, currentY, targetX, targetY));
    }

    private static boolean validatePawnMove(Integer currentX, Integer currentY, Integer targetX, Integer targetY) throws Exception {
        if (currentX < 1 || currentX > 7 || currentY < 0 || currentY > 7)
            throw new Exception("Incorrect location of pawn");

        if (targetX >7 || targetY >7) return false; //Crossing upper boundaries along vertical axis

        //Checking lower boundaries along vertical axis
        if (!(targetY > currentY)) return false;

        //Checking horizontal boundaries
        if (targetX <0  || targetX > 7) return false;


        if (Math.abs(targetX-currentX)>1) return false;

        if (Math.abs(targetY - currentY) > 2) return false;

        //If diagonal move then vertical axis move should not be greater than 1

        if (Math.abs(targetX - currentX) ==1){
            if (Math.abs(targetY - currentY) > 1) return false;
        }

        return true;
    }
}

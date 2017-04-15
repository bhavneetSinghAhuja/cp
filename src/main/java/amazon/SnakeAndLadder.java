package amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bhavneet.ahuja on 15/04/17.
 * Find out min number of moves to make to reach the end in the Snakes and Ladder game.
 */
public class SnakeAndLadder {
    public static void main(String[] args) {
        int moves[] = new int[101];
        for (int i = 0; i < 101; i++)
            moves[i] = -1;

        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        System.out.println(snakeAndLadder.getMinDiceMoves(moves));
    }

    private int getMinDiceMoves(int[] moves) {
        Boolean[] visited = new Boolean[moves.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        Query q = new Query();
        q.currentIndex = 0;
        q.currentMoves = 0;

        Queue<Query> queryQueue = new LinkedList<>();
        queryQueue.add(q);
        Query qe = null;
        while (!queryQueue.isEmpty()) {
            qe = queryQueue.remove();
            if (qe.currentIndex == (moves.length - 1)) break;

            if (!visited[qe.currentIndex]) {
                for (int i = (qe.currentIndex + 1); i <= (qe.currentIndex + 6); i++) {
                    Query qp = new Query();
                    qp.currentMoves = qe.currentMoves + 1;
                    if (moves[qe.currentIndex] == -1)
                        qp.currentIndex = i;
                    else qp.currentIndex = moves[qe.currentIndex];
                    visited[qe.currentIndex]=true;
                    queryQueue.add(qp);
                }
            }
        }
        return qe.currentMoves;
    }


    class Query {
        int currentIndex;
        int currentMoves;
    }
}

package hackerrank;

import java.util.*;

public class DiamondRing {
    public static void main(String[] args) {
        int maze[][] = {{0,1,1},
                {1,0,-1},
                {1,1,1}
        };
        System.out.println(collect_max(maze));
    }

    static int collect_max(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int result=0;
        result = solveMaze(mat, rows, cols);
        return result;
    }

    private static int solveMaze(int[][] mat, int rows, int cols) {
        Map<Integer, List<Triplet>> possibleResults=new HashMap<>();
        List<Triplet> possiblePath=new ArrayList<>();
        Integer max, res=0;
        if(mat[0][0]==1)res=res-1;
        if(mat[rows-1][cols-1]==1)res=res-1;
        long startTime = System.nanoTime();

        solveMazeUtil(mat, 0, 0 , rows, cols, possiblePath, possibleResults);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(duration);
        if(possibleResults.size()==0) return 0;
        max=findMax(possibleResults);
        Triplet source=new Triplet(0,0,mat[0][0]);
        Triplet destination=new Triplet(rows-1,cols-1, mat[rows-1][cols-1]);
        if(!(possibleResults.get(max).contains(source) && possibleResults.get(max).contains(destination)))
            return 0;
        res=res+max;
        for (Triplet triplet : possibleResults.get(max)) {
            if(triplet.first==0 && triplet.second==0){continue;}
            else if(triplet.first==rows-1 && triplet.second==cols-1){continue;}
            else
                mat[triplet.first][triplet.second]=0;
        }
        possibleResults.clear();
        possiblePath.clear();

        solveMazeUtil(mat, 0, 0 , rows, cols, possiblePath, possibleResults);
        max=findMax(possibleResults);
        if(!(possibleResults.get(max).contains(source) && possibleResults.get(max).contains(destination)))
            return res;
        res=res+max;
        return res;
    }

    private static Integer findMax(Map<Integer, List<Triplet>> possibleResults) {
        Integer result=0;
        for (Integer integers : possibleResults.keySet()) {
            if(integers>result) result=integers;
        }
        return result;
    }

    private static void solveMazeUtil(int[][] mat, int x, int y, int rows, int cols, List<Triplet> possiblePath, Map<Integer, List<Triplet>> possibleResults) {
        if(!(x<rows)) return;
        if(!(y<cols)) return;
        if (mat[x][y]==-1) return;
        List<Triplet> possiblePaths=new ArrayList<>(possiblePath);
        if(x==rows-1 && y==cols-1){
            possiblePaths.add(new Triplet(x,y,mat[x][y]));
            addPath(possiblePaths, possibleResults);
            return;
        }
        if(mat[x][y]!=-1)
        {
            possiblePaths.add(new Triplet(x,y, mat[x][y]));
        }

        solveMazeUtil(mat,x+1,y,rows,cols,possiblePaths,possibleResults);
        solveMazeUtil(mat,x,y+1,rows,cols,possiblePaths,possibleResults);
    }

    private static void addPath(List<Triplet> possiblePath, Map<Integer, List<Triplet>> possibleResults) {
        Integer sum=0;
        for (Triplet triplet : possiblePath) {
            sum+=triplet.value;
        }

        possibleResults.put(sum, possiblePath);
    }

    static class Triplet {
        Integer first;
        Integer second;
        Integer value;

        public Triplet(Integer first, Integer second, Integer value){
            this.first=first;
            this.second=second;
            this.value=value;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Triplet)) return false;
            final Triplet other = (Triplet) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$first = this.first;
            final Object other$first = other.first;
            if (this$first == null ? other$first != null : !this$first.equals(other$first)) return false;
            final Object this$second = this.second;
            final Object other$second = other.second;
            if (this$second == null ? other$second != null : !this$second.equals(other$second)) return false;
            final Object this$value = this.value;
            final Object other$value = other.value;
            if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
            return true;
        }

        protected boolean canEqual(Object other) {
            return other instanceof Triplet;
        }
    }
}
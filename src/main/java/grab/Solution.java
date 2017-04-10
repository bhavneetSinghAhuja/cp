package grab;

/**
 * Created by bhavneet.ahuja on 20/03/17.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] a=new int[]{4,5,1,1,1,1,4,3,1};
        System.out.println(solution.solution(a));
    }
    public int solution(int[] a) {
        if(a.length < 5 ) return 0;
        Double[] b=new Double[a.length];
        Double[] c=new Double[a.length];
        b[0]=0.0;
        for (int i = 1; i < a.length; i++) {
            b[i]=b[i-1]+a[i-1];
        }
        c[a.length-1]=0.0;
        for (int i = (a.length-2); i >= 0 ; i--) {
            c[i]=c[i+1] + a[i+1];
        }

        int i=1,j=a.length-2;
        Double s1=0.0, s2=0.0;
        while(i<(j+1)){
            if(allThreeEqual(b[i], c[j], b[j]-b[i+1])) return 1;
            else if (b[i] < c[j]) i++;
            else j--;
        }

     return 0;
    }

    private boolean allThreeEqual(Double n1, Double n2, Double n3) {
        if(n1.compareTo(n2)==0 && n2.compareTo(n3)==0) return true;
        return false;
    }
}

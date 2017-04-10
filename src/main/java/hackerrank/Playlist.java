package hackerrank;

/**
 * Created by bhavneet.ahuja on 08/10/16.
 */
public class Playlist {
    static int playlist(String[] songs, int k, String q)
    {
        int i =f(songs,k,q);
        int j=b(songs,k,q);
        return i<j?i:j;
    }

    static int f(String songs[], int k, String q)
    {
        int i=1;
        int j=k+1;
        int fl = -1;
        while(j<songs.length)
        {
            if(songs[j].equals(q)){
                fl =1;
                break;
            }
            if(i==songs.length)
                break;

            if(j==songs.length-1)
                j=0;
            else
                j++;
            i++;
        }
        return (fl==1)?i:-1;

    }

    static int b(String songs[], int k, String q)
    {
        int i1= 1;
        int j1=k-1;
        int fl1=-1;
        while(j1<=songs.length)
        {
            if(songs[j1].equals(q)){
                fl1 =1;
                break;
            }
            if(i1==songs.length)
                break;

            if(j1==0)
                j1=songs.length -1;
            else
                j1--;
            i1++;


        }

        return (fl1==1)?i1:-1;
    }
}

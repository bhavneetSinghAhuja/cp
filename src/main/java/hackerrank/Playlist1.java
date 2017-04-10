package hackerrank;

/**
 * Created by bhavneet.ahuja on 08/10/16.
 */
public class Playlist1 {
    public static void main(String[] args) {
        String[] s={"a","b","c","d","e"};
        System.out.println(playlist(s,1,"e"));
    }

    static int playlist(String[] songs, int k, String q)
    {
        if(songs.length==1) return 0;
        Node[] nodes = new Node[songs.length];
        for (int i = 0; i < songs.length; i++) {
            nodes[i]=new Node(songs[i],i);
        }
        for (int i = 0; i < nodes.length; i++) {
            if(!(i==0 || i==nodes.length-1)){
                nodes[i].prev=nodes[i-1];
                nodes[i].next=nodes[i+1];
            }
        }
        nodes[0].next=nodes[1];
        nodes[0].prev=nodes[nodes.length-1];

        nodes[nodes.length-1].next=nodes[0];
        nodes[nodes.length-1].prev=nodes[nodes.length-2];
        int right=findRight(nodes, k, q);
        int left=findLeft(nodes, k, q);

        if(left<right) return left;
        else return right;

    }

    private static int findLeft(Node[] nodes, int k, String q) {
        Node root=nodes[k];
        int count=1;
        Node nextNode=root.prev;
        while(!q.equals(nextNode.s)){
            count++;
            nextNode=nextNode.prev;
        }
        return count;
    }

    private static int findRight(Node[] nodes, int k, String q) {
        Node root=nodes[k];
        int count=1;
        Node nextNode=root.next;
        while(!q.equals(nextNode.s)){
            count++;
            nextNode=nextNode.next;
        }
        return count;
    }

    static class Node{
        String s;
        int index;
        Node prev, next;
        public Node(String s, int index){
            this.s=s;
            this.index=index;
            prev=null;
            next=null;
        }
    }
}

package amazon;

import java.util.Queue;

/**
 * Created by bhavneet.ahuja on 11/04/17.
 * 
 * Given a Binary tree where each node as a value. and Weight of tree = Sum of weight of all nodes. and Weight of node = level of node X value of the node. each level (even +) and if odd (-) You have to maximize the weight of tree by rearranging the tree node
 */
public class BinaryTreeWeight {
    private static Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {
        
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
//        maximiseTree();
    }

//    private static void maximiseTree() {
//        Queue<Node> q=new Q
//    }
}

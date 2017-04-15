package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by bhavneet.ahuja on 11/04/17.
 * <p>
 * Given a Binary tree where each node as a value. and Weight of tree = Sum of weight of all nodes. and Weight of node = level of node X value of the node. each level (even +) and if odd (-) You have to maximize the weight of tree by rearranging the tree node
 */
public class BinaryTreeWeight {
    private static Node root;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root = maximiseTree(root);
        System.out.println(printWeightOfTree(root));
    }

    private static int printWeightOfTree(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);
        int result = 0;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                level++;
                if (!q.isEmpty())
                    q.add(null);
            }
            else {
                if (level%2==0)
                result += level * temp.data;
                else
                    result=result - level * temp.data;
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return result;
    }

    private static Node maximiseTree(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int odd = 0;
        q.add(root);
        q.add(null);
        boolean flag = false;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (flag) flag = false;
                else flag = true;
                if (!q.isEmpty())
                    q.add(null);
            } else {
                if (!flag)
                    odd++;
                list.add(temp.data);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }

        Collections.sort(list);
        int oddIndex = odd - 1;
        int evenIndex = odd;
        q.clear();
        q.add(root);
        q.add(null);
        flag = false;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (flag) flag = false;
                else flag = true;
                if (!q.isEmpty())
                    q.add(null);
            } else {
                if (flag) {
                    temp.data = list.get(evenIndex);
                    evenIndex++;
                } else {
                    temp.data = list.get(oddIndex);
                    oddIndex--;
                }
                list.add(temp.data);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        return root;
    }
}

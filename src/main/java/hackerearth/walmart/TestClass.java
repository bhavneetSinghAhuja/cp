package hackerearth.walmart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TestClass {
    public static final int DEFAULT = -1;
    Integer junctions;
    Integer queues;
    Node root;
    Map<Integer, Node> nodeMap=new HashMap<>();
    Set<Node> leafNodeSet;

    class Node {
        Node parent= null;
        Node lchild=null;
        Node rchild=null;
        Integer junctionId=DEFAULT;
        Integer numberOfPeopleToParent=DEFAULT;
        Integer depth=DEFAULT;
        SortedSet<String> paths=new TreeSet<>();

        public Node(Integer junctionId) {
            this.junctionId = junctionId;
        }
    }

    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        TestClass tc=new TestClass();
        BufferedReader bi = getBufferedReader();
        tc.evaluate(bi);
    }

    private void evaluate(BufferedReader bi) throws Exception {
        constructTree(bi);
        leafNodeSet =findLeafNodes();
        setPathForLeafNodes(leafNodeSet);
        root= findRoot();
        findDepthOfAll();
        mergeTree();
    }

    private void setPathForLeafNodes(Set<Node> leafNodeSet) {
        for(Node node : leafNodeSet){
            node.paths.add(String.valueOf(node.junctionId));
        }
    }

    private void findDepthOfAll() {
        setDepth(root);
    }

    private void setDepth(Node root) {
        Queue q = new LinkedList<Node>();
        int levelNodes;
        if(root==null) return;
        int count=1;
        q.add(root);
        while(!q.isEmpty()){
            levelNodes = q.size();
            while(levelNodes>0){
                Node n = (Node)q.remove();
                n.depth=count;
                if(n.lchild!=null) q.add(n.lchild);
                if(n.rchild!=null) q.add(n.rchild);
                levelNodes--;
            }
            count++;
        }
    }

    private Node findRoot() {
        Node node = null;
        for(Map.Entry<Integer, Node> entry: nodeMap.entrySet()){
            if(entry.getValue().parent==null)
                node=entry.getValue();
        }
        return node;
    }

    private void mergeTree() {
        Comparator<Node> nodeComparator=new NodeComparator();
        PriorityQueue<Node> nodePriorityQueue= new PriorityQueue<>(nodeComparator);
        nodePriorityQueue.addAll(nodeMap.values());

        while(nodePriorityQueue.size()>0){
            Node currentNode=nodePriorityQueue.poll();
            if(currentNode.parent==null){
                System.out.println(root.numberOfPeopleToParent+1);
                SortedSet<String> paths=new TreeSet<>();
                paths.addAll(root.paths);
                paths.forEach(System.out::println);
            }
            else{

                //find sibling node
                Node siblingNode;
                if(currentNode.parent.lchild==currentNode)
                    siblingNode=currentNode.parent.rchild;
                else
                    siblingNode=currentNode.parent.lchild;

                //calculate time units
                if(siblingNode==null){
                    currentNode.parent.numberOfPeopleToParent+=currentNode.numberOfPeopleToParent;
                    for(String path: currentNode.paths){
                        currentNode.parent.paths.add(path+" -> "+currentNode.parent.junctionId);
                        currentNode.paths.remove(path);
                        currentNode.parent.paths.remove(path);
                    }
                    //free up the nodes
                }
                else{
                    int l,r;
                    l=currentNode.numberOfPeopleToParent;
                    r=siblingNode.numberOfPeopleToParent;
                    if(l==r){
                        currentNode.parent.numberOfPeopleToParent+=2*l;

                        for(String path: currentNode.paths){
                            currentNode.parent.paths.add(path+" -> "+currentNode.parent.junctionId);
                        }
                        for(String path: siblingNode.paths){
                            currentNode.parent.paths.add(path+" -> "+siblingNode.parent.junctionId);
                        }
                    }
                    else{
                        Node min=min(currentNode,siblingNode);
                        currentNode.parent.numberOfPeopleToParent+=(2*min(l,r)+1);
                        currentNode.parent.paths.addAll(min.paths);
                        for(String path: currentNode.parent.paths){
                            currentNode.parent.paths.add(path+" -> "+min.parent.junctionId);
                            currentNode.paths.remove(path);
                            currentNode.parent.paths.remove(path);
                        }
                    }
                    nodeMap.remove(siblingNode.junctionId);
                }

                nodePriorityQueue.remove(siblingNode);
                Node parent=currentNode.parent;
                parent.lchild=null;
                parent.rchild=null;

            }
            nodeMap.remove(currentNode.junctionId);
        }

    }

    private Node min(Node currentNode, Node siblingNode) {
        if(currentNode.numberOfPeopleToParent<siblingNode.numberOfPeopleToParent)
            return currentNode;
        else
            return siblingNode;
    }

    private Integer min(int l, int r) {
        if(l<r)
            return l;
        else return r;
    }

    private Set<Node> findLeafNodes() {
     return nodeMap.values().stream().filter(n-> n.lchild==null && n.rchild==null).collect(Collectors.toSet());
    }

    private void constructTree(BufferedReader bi) throws Exception {
        String line;
        line=bi.readLine();
        junctions=getIntegerFromString(line);
        line=bi.readLine();
        queues=getIntegerFromString(line);
        for (int i = 0; i < queues; i++) {
            line=bi.readLine();
            String[] edge=getSplitSpace(line);
            Integer start=getIntegerFromString(edge[0]);
            Integer end=getIntegerFromString(edge[1]);
            Integer n=getIntegerFromString(edge[2]);
            Node startNode, endNode;

            //construct child node
            if(nodeMap.containsKey(start)){
                startNode=nodeMap.get(start);
            }
            else{
                startNode=new Node(start);
            }
            nodeMap.put(start, startNode);

            //construct parent node
            if(nodeMap.containsKey(end)){
                endNode=nodeMap.get(end);
            }
            else {
                endNode= new Node(end);
            }
            nodeMap.put(end, endNode);

            setChildNode(start, end, n, startNode);
            setParentNode(start, end, endNode);
        }
    }

    private void setChildNode(Integer start, Integer end, Integer n, Node startNode) {
        startNode.numberOfPeopleToParent=n;
        startNode.parent=nodeMap.get(end);
        nodeMap.put(start, startNode);
    }

    private void setParentNode(Integer start, Integer end, Node node) {
        Node startNode=nodeMap.get(start);
        if(!(node.lchild == startNode || node.rchild==startNode)){
            if (node.lchild == null){
                node.lchild = startNode;
            }
            else if (node.rchild == null){
                node.rchild = startNode;
            }
            nodeMap.put(end, node);
        }
    }

    private class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n2.depth.compareTo(n1.depth);
        }
    }
}

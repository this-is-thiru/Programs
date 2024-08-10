package algos.tree;

public class Node {
    public Node left;
    public int data;
    public Node right;
    public int hd; // Horizontal Division

    public Node(Node left, int data, Node right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
    }
}

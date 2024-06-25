package coding_mafia;

public class CommonAncestor {
    public static void main(String[] args) {

        int[] input = {8, 5, 10, 2, 6, -1, -1, -1, -1, -1, 7, -1, -1};

        BST bst = new BST(input[0]);

        for (int num : input) {
            if (num != -1) {
                bst.insert(num);
            }
        }

        bst.printAll();

        int commonAncestor = bst.commonAncestor(2, 10);
        System.out.println("Common Ancestor of 2, 10 is: " + commonAncestor);
    }
}

class BST {

    private final Node root;

    public BST(int data) {
        this.root = new Node(null, data, null);
    }

    public void insert(int data) {
        insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(null, data, null);
        }

        if (data > node.data) {
            node.right = insert(node.right, data);
        } else if (data < root.data) {
            node.left = insert(node.left, data);
        }
        return node;
    }

    public void printAll() {
        System.out.print("In Order: ");
        print(root);
        System.out.println();
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.print(node.data + " ");
        print(node.right);
    }

    public int commonAncestor(int num1, int num2) {
        return commonAncestor(root, num1, num2);
    }

    private int commonAncestor(Node node, int num1, int num2) {
        if (node == null) {
            return -1;
        }

        if (node.data == num1) {
            return num1;
        }
        if (node.data == num2) {
            return num2;
        }

        int left = commonAncestor(node.left, num1, num2);
        int right = commonAncestor(node.right, num1, num2);

        if (left != -1 && right != -1) {
            return node.data;
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}


class Node {
    public Node left;
    public int data;
    public Node right;

    public Node(Node left, int data, Node right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }
}
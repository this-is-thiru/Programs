package temp;

class Node {
    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    int data;
    Node left;
    Node right;
}

public class Temp1 {
    public static void main(String[] args) {
        Node nodeL1 = new Node(-2, null, null);
        Node nodeR1 = new Node(3, null, null);

        Node nodeL2 = new Node(-4, null, null);
        Node nodeL3 = new Node(-5, null, null);
        nodeL1.left = nodeL2;
        nodeL1.right = nodeL3;

        Node nodeR2 = new Node(-6, null, null);
        Node nodeR3 = new Node(2, null, null);
        nodeR1.left = nodeR2;
        nodeR1.right = nodeR3;

        Node root = new Node(1, nodeL1, nodeR1);

        Temp1 temp1 = new Temp1();
        int tempLeft = temp1.calculateSubTreeSum(root.left);
        int tempRight = temp1.calculateSubTreeSum(root.right);

        int ans = Math.max(tempLeft, tempRight);
        System.out.println(ans);
    }

    private int calculateSubTreeSum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Integer.MIN_VALUE;
        if (node.left != null) {
            leftSum = calculateSubTreeSum(node.left);
        }

        int rightSum = Integer.MIN_VALUE;
        if (node.right != null) {
            rightSum = calculateSubTreeSum(node.right);
        }

        int currentSum = leftSum + rightSum + node.data;
        if (currentSum > leftSum && currentSum > rightSum) {
            return currentSum;
        }

        if (leftSum > rightSum) {
            return leftSum;
        }
        return rightSum;
    }
}
//           1
//        /       \
//      -2         3
//      / \         / \
//     -4   -5       -6  2

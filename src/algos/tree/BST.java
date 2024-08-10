package algos.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BST {

    private Node root;

    public BST() {
    }

    private void insert(int num) {
        root = insert(root, num);
    }

    private Node insert(Node currentNode, int num) {
        if (currentNode == null) {
            return new Node(num);
        }

        if (num < currentNode.data) {
            currentNode.left = insert(currentNode.left, num);
        } else if (num > currentNode.data) {
            currentNode.right = insert(currentNode.right, num);
        }

        return currentNode;
    }

    public void heightOfTree() {
        int heightOfTree = heightOfTree(root);
        System.out.println("Height of tree is "+ heightOfTree);
    }

    private int heightOfTree(Node currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int leftHeight = heightOfTree(currentNode.left);
        int rightHeight = heightOfTree(currentNode.right);

        int currentMaxHeight = Math.max(leftHeight, rightHeight);
        return currentMaxHeight + 1;
    }

    public void printNodesInEachRow() {
        System.out.println("Printing nodes of each row in tree...");
        levelOrder(root);
        System.out.println();
    }

    public void levelOrder(Node currentNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        queue.add(null);

        int row = 1;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp == null) {
                if (queue.peek() == null) {
                    System.out.println(" -> row" + row);
                    return;
                } else {
                    queue.add(null);
                    System.out.println(" -> row" + row);
                    row++;
                    continue;
                }
            }

            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void printTopView() {
        System.out.println("Printing top view of tree...");
        List<Integer> ans = topView(root);
        ans.forEach(data -> System.out.print(data + " "));
        System.out.println();
    }

    private List<Integer> topView(Node currentNode) {
        if (currentNode == null) {
            return null;
        }

        Map<Integer, Integer> levelNodes = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                queue.add(temp.right);
            }

            levelNodes.putIfAbsent(temp.hd, temp.data);
        }

        return levelNodes.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public void printBottomView() {
        System.out.println("Printing bottom view of tree...");
        List<Integer> ans = bottomView(root);
        ans.forEach(data -> System.out.print(data + " "));
        System.out.println();
    }

    private List<Integer> bottomView(Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        Map<Integer, Integer> levelNodes = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                queue.add(temp.right);
            }

            levelNodes.put(temp.hd, temp.data);
        }

        return levelNodes.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }


    public void printLeftView() {
        System.out.println("Printing left view of tree...");
        List<Node> levelNodes = new ArrayList<>();
        leftView(root, levelNodes, 0);
        levelNodes.stream().map(node -> node.data).forEach(data -> System.out.print(data + " "));
        System.out.println();
    }

    private void leftView(Node currentNode, List<Node> levels, int level) {
        if (currentNode == null) {
            return;
        }

        if (levels.size() <= level) {
            levels.add(currentNode);
        }

        leftView(currentNode.left, levels, level + 1);
        leftView(currentNode.right, levels, level + 1);
    }

    public void printRightView() {
        System.out.println("Printing right view of tree...");
        List<Node> levelNodes = new ArrayList<>();
        rightView(root, levelNodes, 0);
        levelNodes.stream().map(node -> node.data).forEach(data -> System.out.print(data + " "));
        System.out.println();
    }

    private void rightView(Node currentNode, List<Node> levels, int level) {
        if (currentNode == null) {
            return;
        }

        if (levels.size() <= level) {
            levels.add(currentNode);
        }

        rightView(currentNode.right, levels, level + 1);
        rightView(currentNode.left, levels, level + 1);
    }

    public void printInOrder() {
        System.out.println("-> In Order traversal of tree...");
        System.out.print("  -> Recursive: ");
        inOrderRecursive(root);
        System.out.println();
        System.out.print("  -> Iterative: ");
        inOrderIterative(root);
        System.out.println();
    }

    private void inOrderRecursive(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        inOrderRecursive(currentNode.left);
        System.out.print(currentNode.data + " ");
        inOrderRecursive(currentNode.right);
    }

    private void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node temp = root;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                inOrder.add(temp.data);
                temp = temp.right;
            }
        }
        inOrder.forEach(num -> System.out.print(num + " "));
    }

    public void printPreOrder() {
        System.out.println("-> Pre Order traversal of tree...");
        System.out.print("  -> Recursive: ");
        preOrderRecursive(root);
        System.out.println();
        System.out.print("  -> Iterative: ");
        preOrderIterative(root);
        System.out.println();
    }

    private void preOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        List<Integer> preOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            preOrder.add(temp.data);

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        preOrder.forEach(num -> System.out.print(num + " "));
    }

    private void preOrderRecursive(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.print(currentNode.data + " ");
        preOrderRecursive(currentNode.left);
        preOrderRecursive(currentNode.right);
    }

    public void printPostOrder() {
        System.out.println("-> Post Order traversal of tree...");
        System.out.print("  -> Recursive: ");
        postOrderRecursive(root);
        System.out.println();
        System.out.print("  -> Iterative1: ");
        postOrderIterative1(root);
        System.out.print("  -> Iterative2: ");
        postOrderIterative2(root);
        System.out.println();
    }

    private void postOrderRecursive(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        postOrderRecursive(currentNode.left);
        postOrderRecursive(currentNode.right);
        System.out.print(currentNode.data + " ");
    }

    private void postOrderIterative1(Node root) {
        if (root == null) {
            return;
        }

        List<Integer> postOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node temp = stack.peek().right;

                if (temp == null) {
                    temp = stack.pop();
                    postOrder.add(temp.data);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        postOrder.add(temp.data);
                    }
                } else {
                    current = temp;
                }
            }
        }
        postOrder.forEach(num -> System.out.print(num + " "));
    }

    private void postOrderIterative2(Node root) {
        if (root == null) {
            return;
        }

        List<Integer> postOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            if (temp.left != null) {
                stack.push(temp.left);
            }

            if (temp.right != null) {
                stack.push(temp.right);
            }
            postOrder.add(temp.data);
        }
        Collections.reverse(postOrder);
        postOrder.forEach(num -> System.out.print(num + " "));
    }


    private void isBalancedTree() {
        boolean isBalancedTree = isBalancedTree(this.root) != -1;
        String message = isBalancedTree ? "Balanced" : "Not a Balanced";
        System.out.println("This Tree is a " + message + " Tree");
    }

    private int isBalancedTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = this.isBalancedTree(root.left);
        int rightHeight = this.isBalancedTree(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void diameterOfTree() {
        int[] diameter = new int[1];

        diameterOfTree(this.root, diameter);
        System.out.println("Diameter of the tree is: " + diameter[0]);
    }

    private int diameterOfTree(Node root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int leftHeight = this.diameterOfTree(root.left, diameter);
        int rightHeight = this.diameterOfTree(root.right, diameter);

        int tempDiameter = leftHeight + rightHeight;
        diameter[0] = Math.max(diameter[0], tempDiameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void maximumPathSum() {
        int maximumPathSum = maximumPathSum(this.root);
        System.out.println("Maximum Path sum of the tree is: " + maximumPathSum);
    }

    private int maximumPathSum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = this.maximumPathSum(root.left);
        int rightHeight = this.maximumPathSum(root.right);

        return Math.max(leftHeight, rightHeight) + root.data;
    }

    private void compareBinaryTree(BST root2) {

        boolean isIdentical = compareBinaryTree(root, root2.root);
        String message = isIdentical ? "Identical" : "Non-Identical";
        System.out.println("-> Given two trees are " + message);
    }

    private boolean compareBinaryTree(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return compareBinaryTree(root1.left, root2.left) && compareBinaryTree(root1.right, root2.right);
    }

    private static BST getTree() {
        BST bst = new BST();

        bst.insert(22);
        bst.insert(30);
        bst.insert(12);
        bst.insert(25);
        bst.insert(40);
        bst.insert(8);
        bst.insert(20);
        bst.insert(2);
        bst.insert(70);
        return bst;
    }

    private static BST getTreeDiff() {
        BST bst = new BST();

        bst.insert(22);
        bst.insert(30);
        bst.insert(12);
        bst.insert(25);
        bst.insert(40);
        bst.insert(8);
        bst.insert(20);
        bst.insert(2);
        return bst;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        BST bst = getTree();

        bst.printInOrder();
        bst.printPreOrder();
        bst.printPostOrder();
        bst.printNodesInEachRow();
        bst.printLeftView();
        bst.printRightView();
        bst.printBottomView();
        bst.printTopView();
        bst.heightOfTree();
        bst.isBalancedTree();
        bst.diameterOfTree();
        bst.maximumPathSum();

        BST bst1 = getTreeDiff();
        bst.compareBinaryTree(bst1);
    }
}

/*
        22                                  22
       /  \                                /  \
     12    30                             12    30
    / \    / \                           / \    / \
   8  20  25  40                        8  20  25  40
  /             \                      /
 2               70                   2
*/

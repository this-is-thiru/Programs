package algos.tree;

import java.util.*;

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
        System.out.println("Height of tree is " + heightOfTree);
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
        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(currentNode, 0, 0));
        int row = 0;
        while (!queue.isEmpty()) {
            Helper cur = queue.poll();
            Node temp = cur.node;

            if (cur.level == row) {
                System.out.println();
                row = cur.level+1;
            }
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(new Helper(temp.left, 0, cur.level + 1));
            }
            if (temp.right != null) {
                queue.add(new Helper(temp.right, 0, cur.level + 1));
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

        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(currentNode, 0));

        while (!queue.isEmpty()) {
            Helper cur = queue.poll();
            Node temp = cur.node;

            if (temp.left != null) {
                queue.add(new Helper(temp.left, cur.hd - 1));
            }

            if (temp.right != null) {
                queue.add(new Helper(temp.right, cur.hd + 1));
            }

            levelNodes.putIfAbsent(cur.hd, temp.data);
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

        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(currentNode, 0));

        while (!queue.isEmpty()) {
            Helper cur = queue.poll();
            Node temp = cur.node;

            if (temp.left != null) {
                queue.add(new Helper(temp.left, cur.hd - 1));
            }

            if (temp.right != null) {
                queue.add(new Helper(temp.right, cur.hd + 1));
            }

            levelNodes.put(cur.hd, temp.data);
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

    private void widthOfTree() {
        int widthOfTree = widthOfTree(this.root);
        System.out.println(" -> Width of the tree is: " + widthOfTree);
    }

    private int widthOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Helper> queue = new LinkedList<>();
        Helper helper = new Helper(root, 0, 0);
        queue.add(helper);

        int prevNumber = 0;
        int prevLevel = 0;
        int ans = 0;
        while (!queue.isEmpty()) {
            Helper temp = queue.poll();

            if (temp.level > prevLevel) {
                prevLevel = temp.level;
                prevNumber = temp.number;
            }

            ans = Math.max(temp.number - prevNumber+1 , ans);

            if (temp.node.left != null) {
                Helper left = new Helper(temp.node.left, 2 * temp.number+1, temp.level + 1);
                queue.add(left);
            }

            if (temp.node.right != null) {
                Helper right = new Helper(temp.node.right, (2 * temp.number) + 2, temp.level + 1);
                queue.add(right);
            }
        }
        return ans;
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

    public void boundaryElements() {
        if (root == null) {
            System.out.println("-> Root of tree is null.");
        }

        List<Integer> boundaryElements = new ArrayList<>();
        if (isNotLeafNode(root)) {
            boundaryElements.add(root.data);
        }

        addLeftNodes(root, boundaryElements);
        addLeafNodes(root, boundaryElements);
        addRightNodes(root, boundaryElements);

        System.out.print("-> Boundary view of the tree is: ");
        boundaryElements.forEach(ele -> System.out.print(ele + " "));
        System.out.println();
    }

    private boolean isNotLeafNode(Node node) {
        if (node.left == node.right) {
            return node.left != null;
        }
        return true;
    }

    private void addLeftNodes(Node root, List<Integer> numbers) {
        Node cur = root.left;

        while (cur != null) {
            if (isNotLeafNode(cur)) {
                numbers.add(cur.data);
            }

            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    private void addLeafNodes(Node node, List<Integer> numbers) {
        if (node == null) {
            return;
        }

        if (!isNotLeafNode(node)) {
            numbers.add(node.data);
        }

        addLeafNodes(node.left, numbers);
        addLeafNodes(node.right, numbers);
    }

    private void addRightNodes(Node root, List<Integer> numbers) {
        Node cur = root.right;

        Stack<Integer> stack = new Stack<>();

        while (cur != null) {
            if (isNotLeafNode(cur)) {
                stack.push(cur.data);
            }

            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        while (!stack.isEmpty()) {
            numbers.add(stack.pop());
        }
    }

    public void commonAncestor(int num1, int num2) {
        int ancestor = commonAncestor(root, num1, num2);
        String msg = ancestor == -1 ? "No ancestor found for these nodes" : "Common ancestor is: " + ancestor;
        System.out.println("-> " + msg);
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

//        bst.printInOrder();
//        bst.printPreOrder();
//        bst.printPostOrder();
//        bst.printNodesInEachRow();
//        bst.printLeftView();
//        bst.printRightView();
//        bst.printBottomView();
//        bst.printTopView();
//        bst.heightOfTree();
//        bst.isBalancedTree();
//        bst.diameterOfTree();
        bst.widthOfTree();
//        bst.maximumPathSum();
//        bst.boundaryElements();
//        bst.commonAncestor(8, 20);

        BST bst1 = getTreeDiff();
        bst.compareBinaryTree(bst1);
    }
}

class Helper {
    Node node;
    int number, level;
    int hd;

    Helper(Node node, int number, int level) {
        this.node = node;
        this.number = number;
        this.level = level;
    }

    Helper(Node node, int hd) {
        this.node = node;
        this.hd = hd;
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

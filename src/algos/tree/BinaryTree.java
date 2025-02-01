package algos.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static List<Integer> zigzag(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        List<Pair> list = new ArrayList<>();
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            list.add(pair);
            maxLevel = Math.max(maxLevel, pair.level + 1);
            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.level + 1));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.level + 1));
            }
        }

        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < maxLevel; i++) {
            temp.add(new ArrayList<>());
        }

        for (Pair pair : list) {
            temp.get(pair.level).add(pair.node.data);
        }

        List<Integer> ans = new ArrayList<>();
        boolean isReverse = false;
        for (List<Integer> list1 : temp) {
            ans.addAll(isReverse ? list1.reversed() : list1);
            isReverse = !isReverse;
        }

        return ans;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> ans = zigzag(root);
        System.out.println(ans);
    }
}

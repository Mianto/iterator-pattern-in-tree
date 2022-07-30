package testUtil;

import Tree.BinaryTree;

public class CreateBinaryTree {
    public static BinaryTree<Integer> createUnbalancedBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.addNode(1);
        binaryTree.addNode(12);
        binaryTree.addNode(8);
        binaryTree.addNode(16);
        binaryTree.addNode(2);
        binaryTree.addNode(6);
        binaryTree.addNode(4);
        return binaryTree;
    }

    public static BinaryTree<Integer> createBalancedBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(3);
        binaryTree.addNode(1);
        binaryTree.addNode(8);
        binaryTree.addNode(6);
        binaryTree.addNode(10);
        return binaryTree;
    }
}

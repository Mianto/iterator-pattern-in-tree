import Tree.BinaryTree;
import Tree.Node;

import java.util.Iterator;

public class MainClass {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.addNode(1);
        binaryTree.addNode(12);
        binaryTree.addNode(8);
        binaryTree.addNode(16);
        binaryTree.addNode(2);
        binaryTree.addNode(6);
        binaryTree.addNode(4);


        Iterator<Node<Integer>> preorderIterator = binaryTree.getPreorderIterator();
        while (preorderIterator.hasNext()) {
            Node<Integer> next = preorderIterator.next();
            System.out.println(next);
        }

//        BinaryTree.BinaryTree<Double> btd = new BinaryTree.BinaryTree<>();
//        btd.addNode(12.8);
//        btd.addNode(8.2);
//        btd.addNode(16.1);
//        btd.addNode(11.2);
//        btd.addNode(2.2);
//        btd.addNode(6.6);
//        btd.addNode(4.9);
//
//        Iterator<BinaryTree.Node<Double>> treePreorderIterator = btd.getPreorderIterator();
//        while (treePreorderIterator.hasNext()) {
//            BinaryTree.Node<Double> next = treePreorderIterator.next();
//            System.out.println(next);
//        }
    }
}

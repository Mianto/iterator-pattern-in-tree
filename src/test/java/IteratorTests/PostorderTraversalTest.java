package IteratorTests;

import Tree.BinaryTree;
import Tree.Node;
import org.junit.jupiter.api.Test;
import testUtil.CreateBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PostorderTraversalTest {
    @Test
    public void hasNext_shouldReturnFalseForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> postorderIterator = bt.getPostorderIterator();
        assertFalse(postorderIterator.hasNext(), "shouldReturnFalseForAnEmptyTree");
    }

    @Test
    public void next_shouldReturnNullForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> postorderIterator = bt.getPostorderIterator();
        assertNull(postorderIterator.next());
    }

    @Test
    public void hasNext_shouldReturnTrueForTreeWithSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> postorderIterator = bt.getPostorderIterator();
        assertTrue(postorderIterator.hasNext());
    }

    @Test
    public void next_shouldReturnNodeForTreeWithSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> postorderIterator = bt.getPostorderIterator();
        Node<Integer> nodeFromIterator = postorderIterator.next();
        assertEquals(nodeFromIterator.getValue(), 0);
        assertNull(nodeFromIterator.getLeft());
        assertNull(nodeFromIterator.getRight());
    }

    @Test
    public void shouldReturnNodeInCorrectOrder_unBalancedTree() {
        BinaryTree<Integer> binaryTree = CreateBinaryTree.createUnbalancedBinaryTree();
        List<Integer> expectedOrderList = Arrays.asList(4, 6, 2, 8, 16, 12, 1);
        List<Integer> actualList = new ArrayList<>();

        Iterator<Node<Integer>> postorderIterator = binaryTree.getPostorderIterator();
        while (postorderIterator.hasNext()) {
            Node<Integer> curr = postorderIterator.next();
            actualList.add(curr.getValue());
        }
        assertEquals(actualList, expectedOrderList);
    }

    @Test
    public void shouldReturnNodeInCorrectOrder_balancedTree() {
        BinaryTree<Integer> binaryTree = CreateBinaryTree.createBalancedBinaryTree();
        List<Integer> expectedOrderList = Arrays.asList(1, 3, 2, 6, 10, 8, 4);
        List<Integer> actualList = new ArrayList<>();

        Iterator<Node<Integer>> postorderIterator = binaryTree.getPostorderIterator();
        while (postorderIterator.hasNext()) {
            Node<Integer> curr = postorderIterator.next();
            actualList.add(curr.getValue());
        }
        assertEquals(actualList, expectedOrderList);
    }

}

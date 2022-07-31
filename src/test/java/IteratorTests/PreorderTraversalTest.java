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

class PreorderTraversalTest {
    @Test
    public void hasNext_shouldReturnFalseForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> preorderIterator = bt.getPreorderIterator();
        assertFalse(preorderIterator.hasNext(), "shouldReturnFalseForAnEmptyTree");
    }

    @Test
    public void next_shouldReturnNullForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> preorderIterator = bt.getPreorderIterator();
        assertNull(preorderIterator.next());
    }

    @Test
    public void hasNext_shouldReturnTrueForTreeWithSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> preorderIterator = bt.getPreorderIterator();
        assertTrue(preorderIterator.hasNext());
    }

    @Test
    public void next_shouldReturnNodeForTreeWithSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> preorderIterator = bt.getPreorderIterator();
        Node<Integer> nodeFromIterator = preorderIterator.next();
        assertEquals(nodeFromIterator.getValue(), 0);
        assertNull(nodeFromIterator.getLeft());
        assertNull(nodeFromIterator.getRight());
    }

    @Test
    public void shouldReturnNodeInCorrectOrder() {
        BinaryTree<Integer> binaryTree = CreateBinaryTree.createUnbalancedBinaryTree();
        List<Integer> expectedOrderList = Arrays.asList(1, 12, 8, 2, 6, 4, 16);
        List<Integer> actualList = new ArrayList<>();
        Iterator<Node<Integer>> preorderIterator = binaryTree.getPreorderIterator();
        while (preorderIterator.hasNext()) {
            Node<Integer> curr = preorderIterator.next();
            actualList.add(curr.getValue());
        }
        assertEquals(actualList, expectedOrderList);
    }
}
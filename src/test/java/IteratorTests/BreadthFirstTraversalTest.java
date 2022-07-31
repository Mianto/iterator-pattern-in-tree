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

public class BreadthFirstTraversalTest {
    @Test
    public void hasNext_shouldReturnFalseForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> bfsIterator = bt.getBreadthFirstIterator();
        assertFalse(bfsIterator.hasNext());
    }

    @Test
    public void hasNext_shouldReturnNullForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> bfsIterator = bt.getBreadthFirstIterator();
        assertFalse(bfsIterator.hasNext());
    }

    @Test
    public void hasNext_shouldReturnTrueForTreeContainingSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> bfsIterator = bt.getBreadthFirstIterator();
        assertTrue(bfsIterator.hasNext());
    }

    @Test
    public void next_shouldReturnNodeForTreeContainingSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> bfsIterator = bt.getBreadthFirstIterator();
        Node<Integer> node = bfsIterator.next();
        assertNotNull(node, "A valid node should be returned");
        assertEquals(node.getValue(), 0);
        assertNull(node.getLeft());
        assertNull(node.getRight());
    }

    @Test
    public void twoNext_shouldReturnNullInSecondTimeForSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> bfsIterator = bt.getBreadthFirstIterator();
        bfsIterator.next();
        assertNull(bfsIterator.next());
    }

    @Test
    public void shouldReturnNodesInCorrectOrder_forUnbalanced() {
        BinaryTree<Integer> binaryTree = CreateBinaryTree.createUnbalancedBinaryTree();
        List<Integer> sortedList = Arrays.asList(1, 12, 8, 16, 2, 6, 4);
        List<Integer> actualList = new ArrayList<>();
        Iterator<Node<Integer>> bfsIterator = binaryTree.getBreadthFirstIterator();
        while (bfsIterator.hasNext()) {
            Node<Integer> node = bfsIterator.next();
            actualList.add(node.getValue());
        }
        assertEquals(sortedList, actualList);
    }
}

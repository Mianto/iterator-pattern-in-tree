import Tree.BinaryTree;
import Tree.Node;
import org.junit.jupiter.api.Test;
import testUtil.CreateBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InorderTraversalTest {
    @Test
    public void hasNext_shouldReturnFalseForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> inorderIterator = bt.getInorderIterator();
        assertFalse(inorderIterator.hasNext());
    }

    @Test
    public void hasNext_shouldReturnNullForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> inorderIterator = bt.getInorderIterator();
        assertFalse(inorderIterator.hasNext());
    }

    @Test
    public void hasNext_shouldReturnTrueForTreeContainingSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> inorderIterator = bt.getInorderIterator();
        assertTrue(inorderIterator.hasNext());
    }

    @Test
    public void next_shouldReturnNodeForTreeContainingSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> inorderIterator = bt.getInorderIterator();
        Node<Integer> node = inorderIterator.next();
        assertNotNull(node, "A valid node should be returned");
        assertEquals(node.getValue(), 0);
        assertNull(node.getLeft());
        assertNull(node.getRight());
    }

    @Test
    public void twoNext_shouldReturnNullInSecondTimeForSingleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        Iterator<Node<Integer>> inorderIterator = bt.getInorderIterator();
        inorderIterator.next();
        assertNull(inorderIterator.next());
    }

    @Test
    public void shouldReturnNodesInSortedOrder_forUnbalanced() {
        BinaryTree<Integer> binaryTree = CreateBinaryTree.createUnbalancedBinaryTree();
        List<Integer> sortedList = Arrays.asList(1, 2, 4, 6, 8, 12, 16);
        List<Integer> actualList = new ArrayList<>();
        Iterator<Node<Integer>> inorderIterator = binaryTree.getInorderIterator();
        while (inorderIterator.hasNext()) {
            Node<Integer> node = inorderIterator.next();
            actualList.add(node.getValue());
        }
        assertEquals(sortedList, actualList);
    }

    @Test
    public void shouldReturnNodesInSortedOrder_forBalancedTree() {
        BinaryTree<Integer> binaryTree = CreateBinaryTree.createBalancedBinaryTree();
        List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 6, 8, 10);
        List<Integer> actualList = new ArrayList<>();
        Iterator<Node<Integer>> inorderIterator = binaryTree.getInorderIterator();
        while (inorderIterator.hasNext()) {
            Node<Integer> node = inorderIterator.next();
            actualList.add(node.getValue());
        }
        assertEquals(sortedList, actualList);
    }
}

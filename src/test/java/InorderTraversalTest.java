import Tree.BinaryTree;
import Tree.Node;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
}

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PreorderTraversalTest {
    @Test
    public void hasNext_shouldReturnFalseForAnEmptyTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Iterator<Node<Integer>> preorderIterator = bt.getPreorderIterator();
        assertFalse(preorderIterator.hasNext(), "shouldReturnFalseForAnEmptyTree");
    }



}
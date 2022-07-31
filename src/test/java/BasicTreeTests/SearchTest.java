package BasicTreeTests;

import Tree.BinaryTree;
import org.junit.jupiter.api.Test;
import testUtil.CreateBinaryTree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @Test
    public void shouldReturnFalseInNullTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertFalse(bt.searchForNode(5));
    }

    @Test
    public void shouldReturnFalseWhenNodeIsAbsent_singleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        assertFalse(bt.searchForNode(5));
    }

    @Test
    public void shouldReturnTrueWhenNodeIsPresent_singleNode() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addNode(0);
        assertTrue(bt.searchForNode(0));
    }

    @Test
    public void shouldReturnTrueWhenNodeIsPresent() {
        BinaryTree<Integer> bt = CreateBinaryTree.createUnbalancedBinaryTree();
        assertTrue(bt.searchForNode(4));
        assertTrue(bt.searchForNode(16));
        assertTrue(bt.searchForNode(8));
    }

    @Test
    public void shouldReturnFalseWhenNodeIsPresent() {
        BinaryTree<Integer> bt = CreateBinaryTree.createUnbalancedBinaryTree();
        assertFalse(bt.searchForNode(5));
        assertFalse(bt.searchForNode(11));
        assertFalse(bt.searchForNode(7));
    }

}

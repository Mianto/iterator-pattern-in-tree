package Tree;

import Tree.BinaryTreeIterators.BreadthFirstTreeIterator;
import Tree.BinaryTreeIterators.InorderTreeIterator;
import Tree.BinaryTreeIterators.PostorderTreeIterator;
import Tree.BinaryTreeIterators.PreorderTreeIterator;

import java.util.Iterator;

public class BinaryTree<T extends Number> {
    private Node<T> root;

    public BinaryTree() {

    }

    public void addNode(T value) {
        root = addNodeToTree(root, value);
    }

    public Boolean searchForNode (T value) { return searchNodeInTree(root, value); }

    public Iterator<Node<T>> getPreorderIterator() {
        return new PreorderTreeIterator<>(root);
    }

    public Iterator<Node<T>> getInorderIterator() { return new InorderTreeIterator<>(root); }

    public Iterator<Node<T>> getPostorderIterator() {
        return new PostorderTreeIterator<>(root);
    }

    public Iterator<Node<T>> getBreadthFirstIterator() { return new BreadthFirstTreeIterator<>(root); }

    private Node<T> addNodeToTree(Node<T> current, T value) {
        if ( current == null ) return new Node<>(value);
        T nodeVal = current.getValue();
        if (nodeVal.doubleValue() < value.doubleValue())
            current.setRight(addNodeToTree(current.getRight(), value));
        else if (nodeVal.doubleValue() > value.doubleValue())
            current.setLeft(addNodeToTree(current.getLeft(), value));
        else
            return current;
        return current;
    }

    private Boolean searchNodeInTree(Node<T> curr, T value) {
        if (curr == null) return false;
        T nodeVal = curr.getValue();
        if (nodeVal.doubleValue() == value.doubleValue()) return true;
        if (nodeVal.doubleValue() < value.doubleValue()) { return searchNodeInTree(curr.getRight(), value); }
        else { return searchNodeInTree(curr.getLeft(), value); }
    }
}

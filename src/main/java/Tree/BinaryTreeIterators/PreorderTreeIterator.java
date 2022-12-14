package Tree.BinaryTreeIterators;

import Tree.Node;

import java.util.Iterator;
import java.util.Stack;

public class PreorderTreeIterator<T extends Number> implements Iterator<Node<T>> {

    private final Stack<Node<T>> nodeStack;

    public PreorderTreeIterator(Node<T> root) {
        this.nodeStack = new Stack<>();
        if (root != null) {
            nodeStack.push(root);
        }
    }

    @Override public boolean hasNext() {
        return !nodeStack.empty();
    }

    @Override public Node<T> next() {
        if (!hasNext()) return null;
        Node<T> tmpNode = nodeStack.peek();
        nodeStack.pop();
        if (tmpNode.getRight() != null) nodeStack.push(tmpNode.getRight());
        if (tmpNode.getLeft() != null) nodeStack.push(tmpNode.getLeft());
        return tmpNode;
    }
}

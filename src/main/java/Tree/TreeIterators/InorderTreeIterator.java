package Tree.TreeIterators;

import Tree.Node;

import java.util.Iterator;
import java.util.Stack;

public class InorderTreeIterator<T extends Number> implements Iterator<Node<T>> {
    Stack<Node<T>> stack;

    public InorderTreeIterator(Node<T> root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    }

    @Override public boolean hasNext() {
        return !stack.empty();
    }

    @Override public Node<T> next() {
        if (!hasNext()) return null;
        Node<T> node = stack.peek();
        stack.pop();
        return node;
    }
}

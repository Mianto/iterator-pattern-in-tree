package Tree.TreeIterators;

import Tree.Node;

import java.util.Iterator;
import java.util.Stack;

public class InorderTreeIterator<T extends Number> implements Iterator<Node<T>> {
    Stack<Node<T>> stack;
    Node<T> curr;

    public InorderTreeIterator(Node<T> root) {
        stack = new Stack<>();
        curr = root;
    }

    @Override public boolean hasNext() { return !stack.empty() || curr != null; }

    @Override public Node<T> next() {
        if (!hasNext()) return null;

        while(curr != null) {
            stack.push(curr);
            curr = curr.getLeft();
        }

        Node<T> node = stack.pop();

        curr = node.getRight();
        return node;
    }
}

package Tree.BinaryTreeIterators;

import Tree.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTreeIterator<T extends Number> implements Iterator<Node<T>> {

    private final Queue<Node<T>> queue;
    public BreadthFirstTreeIterator(Node<T> root) {
        queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
    }

    @Override public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override public Node<T> next() {
        if (!hasNext()) return null;
        Node<T> tempNode = queue.poll();
        if (tempNode == null) { return null; };
        if (tempNode.getLeft() != null) { queue.add(tempNode.getLeft()); }
        if (tempNode.getRight() != null) { queue.add(tempNode.getRight()); }
        return tempNode;
    }
}

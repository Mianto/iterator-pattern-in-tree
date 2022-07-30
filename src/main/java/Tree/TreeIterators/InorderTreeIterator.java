package Tree.TreeIterators;

import Tree.Node;

import java.util.Iterator;

public class InorderTreeIterator<T extends Number> implements Iterator<Node<T>> {
    public InorderTreeIterator() {
    }

    @Override public boolean hasNext() {
        return false;
    }

    @Override public Node<T> next() {
        return null;
    }
}

package Tree.TreeIterators;

import Tree.Node;

import java.util.Iterator;
import java.util.Stack;

public class PostorderTreeIterator<T extends Number> implements Iterator<Node<T>> {

    Stack<Node<T>> stack;
    public PostorderTreeIterator(Node<T> root) {
        postOrder(root);
        stack = new Stack<>();
        if (root != null) stack.push(root);
    }

    @Override public boolean hasNext() {
        return !stack.empty();
    }

    @Override public Node<T> next() {
        if (!hasNext()) return null;
        Node<T> node = stack.pop();
        if(node.getLeft() != null) stack.push(node.getLeft());
        if(node.getRight() != null) stack.push(node.getRight());
        return node;
    }

    public void postOrder(Node<T> root) {
        if (root == null) return;
        if (root.getLeft() != null) postOrder(root.getLeft());
        if (root.getRight() != null) postOrder(root.getRight());
        System.out.println(root.getValue());
    }
}


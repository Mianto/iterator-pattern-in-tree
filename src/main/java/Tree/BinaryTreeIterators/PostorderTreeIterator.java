package Tree.BinaryTreeIterators;

import Tree.Node;

import java.util.Iterator;
import java.util.Stack;

public class PostorderTreeIterator<T extends Number> implements Iterator<Node<T>> {

    Stack<Node<T>> stack1;
    Stack<Node<T>> stack2;

    public PostorderTreeIterator(Node<T> root) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        if (root != null) {
            stack1.push(root);
            populateSecondStack();
        }
    }

    @Override public boolean hasNext() {
        return !stack2.empty();
    }

    @Override public Node<T> next() {
        if (!hasNext()) return null;
        return stack2.pop();
    }

    private void populateSecondStack() {
        while (!stack1.empty()) {
            Node<T> temp = stack1.pop();
            stack2.push(temp);

            if (temp.getLeft() != null) stack1.push(temp.getLeft());
            if (temp.getRight() != null) stack1.push(temp.getRight());
        }
    }
}


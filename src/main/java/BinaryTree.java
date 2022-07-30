import java.util.DuplicateFormatFlagsException;
import java.util.Iterator;

public class BinaryTree<T extends Number> {
    private Node<T> root;

    public BinaryTree() {

    }

    public void addNode(T value) {
        root = addNodeToTree(root, value);
    }

    private Node<T> addNodeToTree(Node<T> current, T value) {
        if ( current == null ) return new Node<>(value);
        T nodeVal = current.getValue();
        if (nodeVal.intValue() < value.intValue())
            current.setRight(addNodeToTree(current.getRight(), value));
        else if (nodeVal.intValue() > value.intValue())
            current.setLeft(addNodeToTree(current.getLeft(), value));
        else
            return current;
        return current;
    }
    
    public Iterator<Node<T>> getPreorderIterator() {
        return new PreorderTreeIterator<T>(root);
    }
}

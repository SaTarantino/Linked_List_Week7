package linkedList.list;

import linkedList.node.SingleLinkNode;

public class SingleLinkList<T> extends BasicList<SingleLinkNode<T>,T> implements List<T> {

    private SingleLinkNode<T> aNode;

    @Override
    public void add(int index, T value) throws ListAccessError {

        if (index == 0) {
            SingleLinkNode<T> node = new SingleLinkNode<T>(value);
            node.setNext(getRoot());
            setRoot(node);
            return;
        }

        SingleLinkNode<T> previousNode = getNode(index - 1);
        SingleLinkNode<T> newNode = new SingleLinkNode<T>(value, previousNode.getNext());
        previousNode.setNext(newNode);
    }

    @Override
    public T remove(int index) throws ListAccessError {
        if (index == 0) {
            SingleLinkNode<T> node = getRoot();
            setRoot((SingleLinkNode)getRoot().getNext());
            return node.getValue();
        }

        SingleLinkNode<T> currentNode = getNode(index - 1);
        SingleLinkNode<T> nextNode = (SingleLinkNode<T>) currentNode.getNext();

        if (nextNode == null)
            throw new ListAccessError("Index out of boundaries");

        currentNode.setNext((SingleLinkNode<T>) nextNode.getNext());
        nextNode.setNext(null);

        return nextNode.getValue();
    }

    @Override
    public T get(int index) throws ListAccessError {
        return getNode(index).getValue();
    }

    public SingleLinkNode<T> getNode(int index) throws ListAccessError {

        if (isEmpty())
            throw new ListAccessError("Empty list.");

        if (index < 0)
            throw new ListAccessError("Negative index.");

        SingleLinkNode<T> node = getRoot();

        while (index != 0 && node != null) {
            node = node.getNext();
            index--;
        }

        if (node == null)
            throw new ListAccessError("Invalid node, index out of boundaries");

        return node;
    }
}


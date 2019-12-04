package linkedList.list;

import linkedList.node.ListNode;
import linkedList.node.SingleLinkNode;

public class SingleLinkList<T> extends BasicList<SingleLinkNode<T>,T> implements List<T> {

    SingleLinkNode<T> head;

    @Override
    public void add(int index, T value) throws ListAccessError {

        SingleLinkNode<T> node;
        node = null;
        node.setNext(null);

        if (isEmpty()) {
            head = node;
        }
        else {
            SingleLinkNode<T> n = head;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(node);
        }
    }

    @Override
    public T remove(int index) throws ListAccessError {
        return null;
    }

    @Override
    public T get(int index) throws ListAccessError {
        return getNode(index).getValue();
    }

    public ListNode<T> getNode(int index) throws ListAccessError {

        if (isEmpty())
            throw new ListAccessError("Empty list.");

        if (index < 0)
            throw new ListAccessError("Negative index.");

        ListNode<T> node = getRoot();

        while (index != 0 && node != null) {
            node = node.getNext();
            index--;
        }

        if (node == null)
            throw new ListAccessError("Invalid node");

        return node;
    }

//    public void show() {
//        SingleLinkNode node = head;
//
//        while (node.getNext() != null) {
//            System.out.println(node.getValue());
//            node = node.getNext();
//        }
//    }
//
//    public static void main(String[] args) throws ListAccessError {
//        SingleLinkList list = new SingleLinkList();
//
//        list.add(0, 18);
//        list.add(1, 40);
//        list.add(2, 20);
//
//        list.show();
//    }
}


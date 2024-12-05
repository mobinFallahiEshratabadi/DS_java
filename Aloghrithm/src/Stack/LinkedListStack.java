package Stack;

import LinkedList.DoublyLinkedList;

public class LinkedListStack {
    DoublyLinkedList D = new DoublyLinkedList();

    public void push(int value) {
        D.addFront(value);
    }

    @Override
    public String toString() {
        return D.toString();
    }

    public int Pop() {
        return (int) D.RemoveFromFront();
    }
}

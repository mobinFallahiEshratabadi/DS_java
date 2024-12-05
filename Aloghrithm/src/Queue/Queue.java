package Queue;

import LinkedList.SingleNode;

import java.util.NoSuchElementException;

public class Queue {
    private SingleNode front;
    private SingleNode rear;
    private int length;

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enQueue(int value) {
        SingleNode temp = new SingleNode(value, null);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }

        rear = temp;
        length++;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int result = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.value;
    }

    public int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return rear.value;
    }
}

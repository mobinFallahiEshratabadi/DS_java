package LinkedList;

public class DoublyNode {
    public int value;
    public DoublyNode next;
    public DoublyNode past;

    public DoublyNode(int value, DoublyNode next, DoublyNode past) {
        this.next = next;
        this.value = value;
        this.past = past;
    }

    @Override
    public String toString() {
            return String.valueOf(value);
    }
}

package LinkedList;

public class SingleNode {
    public int value;
    public SingleNode next;

    public SingleNode(int value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

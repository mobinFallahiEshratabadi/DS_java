package LinkedList;

public class AddTwoSLL {
    public SingleLinkedList add(SingleNode a, SingleNode b) {
        SingleLinkedList merged = new SingleLinkedList();
        SingleNode dummy = new SingleNode(0, null);
        merged.addFront(dummy.value);
        int carry = 0;
        SingleNode tail = merged.first;
        while (a != null || b != null) {
            int x = (a != null) ? a.value : 0;
            int y = (b != null) ? b.value : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new SingleNode(sum % 10, null);
            tail = tail.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }

        if (carry > 0) {
            tail.next = new SingleNode(carry, null);
        }

        merged.first = merged.first.next;
        return merged;
    }
}

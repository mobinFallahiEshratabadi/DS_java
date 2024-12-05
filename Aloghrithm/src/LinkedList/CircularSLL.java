package LinkedList;

public class CircularSLL {
    private ListNode last;
    private int length;

    private static class ListNode {
        private ListNode next;
        private int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public CircularSLL() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCSLL() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void display() {
        if (last == null) {
            return;
        }

        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.value + " ");
            first = first.next;
        }
        System.out.println(first.value);
    }

    public void insertFirst(int value) {
        ListNode temp = new ListNode(value);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void insertLast(int value) {
        ListNode temp = new ListNode(value);

        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }

        length++;
    }

    int removeFirst() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException("CSLL is already empty");
        }

        ListNode temp = last.next;
        int result = temp.value;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }

        length--;
        return result;
    }


    public static void main(String[] args) throws NoSuchFieldException {
        CircularSLL csll = new CircularSLL();
        csll.createCSLL();
        csll.display();
        csll.insertLast(20);
        csll.display();
        csll.removeFirst();
        csll.display();
    }
}

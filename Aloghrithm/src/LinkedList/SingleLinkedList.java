package LinkedList;

public class SingleLinkedList {
    SingleNode first = null;


    /*Node newNode = new Node(value, null);if(first == null) {first=newNode;return;}
      Node cur = first;
      while (cur.next != null) {cur = cur.next;}cur.next = newNode; */
    public void addFront(int value) {
        first = new SingleNode(value, first);
    }

    public void addBack(int value) {
        SingleNode newSingleNode = new SingleNode(value, null);
        SingleNode last_cur = null;
        SingleNode cur = first;
        while (cur != null) {
            last_cur = cur;
            cur = cur.next;
        }
        assert last_cur != null;
        last_cur.next = newSingleNode;
    }

    public void addPosition(int value, int position) {
        SingleNode newSingleNode = new SingleNode(value, null);

        if (position == 1) {
            addFront(value);
        } else {
            SingleNode perCur = first;
            int count = 1;
            while (count < position - 1) {
                perCur = perCur.next;
                count++;
            }
            SingleNode cur = perCur.next;
            newSingleNode.next = cur.next;
            perCur.next = newSingleNode;
        }
    }

    public int length() {
        var cur = first;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        return count;
    }

    public SingleNode getFirst() {
        return first;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        SingleNode cur = first;
        while (cur != null) {
            s.append(cur.value).append("->");
            cur = cur.next;
        }
        s.append("null");
        return s.toString();
    }
}


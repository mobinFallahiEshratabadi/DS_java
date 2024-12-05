package LinkedList;

public class Index {
    public SingleNode index(SingleLinkedList node, int index) {
        var cur = node.first;

        while (cur != null && index > 0) {
            cur = cur.next;
            index--;
        }

        if (index == 0) return cur;
        else return null;
    }
}

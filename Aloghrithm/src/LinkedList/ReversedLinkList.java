package LinkedList;

public class ReversedLinkList {
    public void reversedSingle(SingleLinkedList node) {
        if (node.first == null || node.first.next == null) return;

        SingleNode perPerCur = null;
        SingleNode perCur = node.first;
        SingleNode cur = perCur.next;

        while (cur.next != null) {
            perCur.next = perPerCur;
            perPerCur = perCur;
            perCur = cur;
            cur = cur.next;
        }
        perCur.next = perPerCur;
        cur.next = perCur;
        node.first = cur;
    }
}

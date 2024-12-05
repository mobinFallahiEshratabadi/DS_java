package LinkedList;

public class Find {
    // single =
    public SingleNode findSingle(SingleLinkedList node, int value) {
        SingleNode cur = node.first;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public SingleNode findNthFromEnd(SingleLinkedList node, int number) {
        number = node.length() - number;
        if (number < 1)
            return null;


        SingleNode cur = node.first;
        while (number > 0) {
            cur = cur.next;
            number--;
        }
        return cur;
        /* or use this one
        Node refNode = node.first;Node mainNode = node.first;int count=0; while(count<n) {refNode = refNode.next;count++}
        while(refNode != null) { refNode = refNode.next;mainNode=mainNode.next;{
        return mainNode;     **this is better**
         */
    }

    // double =
    public DoublyNode findFromFront(DoublyLinkedList node, int value) {
        DoublyNode cur = node.getFirst();
        while (cur != null) {
            if (cur.value == value) return cur;
            cur = cur.next;
        }

        return null;
    }

    public DoublyNode findFromBack(DoublyLinkedList node, int value) {
        DoublyNode cur = node.getLast();
        while (cur != null) {
            if (cur.value == value) return cur;
            cur = cur.past;
        }

        return null;
    }
}

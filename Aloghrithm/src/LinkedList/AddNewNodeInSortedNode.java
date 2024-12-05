package LinkedList;

public class AddNewNodeInSortedNode {
    public void add(SingleLinkedList node, int value) {
        SingleNode newSingleNode = new SingleNode(value, null);
        SingleNode cur = node.first;

        while (cur.next != null) {
            if (cur.value < value && cur.next.value > value) {
                newSingleNode.next = cur.next;
                cur.next = newSingleNode;
                return;
            }
            cur = cur.next;
        }

        cur.next = newSingleNode;
    }
}

package LinkedList;

public class Delete {
    // sll
    public void deleteSingle(SingleLinkedList node, int value) {
        var cur = node.first;
        SingleNode lastCur = null;

        while (cur != null) {
            if (cur.value == value) {
                if (cur != node.first) {
                    lastCur.next = cur.next;
                } else {
                    node.first = cur.next;
                }
            }
            lastCur = cur;
            cur = cur.next;
        }

    }

    public void deleteSLLFront(SingleLinkedList node) {
        if (node.first != null) node.first = node.first.next;
    }

    public void deleteSLLBack(SingleLinkedList node) {
        if (node.first != null) {
            SingleNode cur = node.first;

            if (cur.next == null) {
                node.first = null;
                return;
            }

            SingleNode perCur = null;
            while (cur.next != null) {
                perCur = cur;
                cur = cur.next;
            }

            perCur.next = null;
        }
    }

    public void deleteSLLPosition(SingleLinkedList node, int position) {
        if (node.first != null) {
            if (position == 1) {
                node.first = node.first.next;
            } else {
                SingleNode perCur = node.first;
                int count = 1;
                while (count < position - 1) {
                    perCur = perCur.next;
                    count++;
                }
                SingleNode cur = perCur.next;
                perCur.next = cur.next;
                cur.next = null;
            }
        }
    }

    public void removeDuplicatesFromSortedLinkedSLL(SingleLinkedList node) {
        if (node.first == null) return;
        SingleNode cur = node.first;

        while (cur.next != null) {
            if (cur.value == cur.next.value) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    // dll

    public void deleteDLLFirst(DoublyLinkedList node) {
        var cur = node.getFirst();

        if (cur != null) {
            if (cur == node.getLast()) {
                node.setFirst(null);
                node.setLast(null);
            } else {
                node.setFirst(cur.next);
                cur.next.past = null;
            }
        }
    }

    public void deleteDllLast(DoublyLinkedList node) {
        var cur = node.getLast();

        if (cur != null) {
            if (cur == node.getFirst()) {
                node.setFirst(null);
                node.setLast(null);
            } else {
                node.setLast(cur.past);
                cur.past.next = null;
            }
        }
    }
}


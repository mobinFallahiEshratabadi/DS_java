package LinkedList;

public class DoublyLinkedList {
    private DoublyNode last, first;

    public DoublyLinkedList() {
        last = first = null;
    }

    public DoublyNode getLast() {
        return last;
    }

    public void setLast(DoublyNode last) {
        this.last = last;
    }

    public DoublyNode getFirst() {
        return first;
    }

    public void setFirst(DoublyNode first) {
        this.first = first;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("null<->");
        DoublyNode cur = first;
        while (cur != null) {
            s.append(cur.value).append("<->");
            cur = cur.next;
        }
        s.append("null");
        return s.toString();
    }

    public void addFront(int value) {
        DoublyNode newNode = new DoublyNode(value, null, null);
        if (first == last && first == null) {
            newNode.next = last;
            newNode.past = first;
            last = first = newNode;
        } else {
            newNode.next = first;
            newNode.past = null;
            first.past = newNode;
            first = newNode;
        }
    }

    public void addBack(int value) {
        DoublyNode newNode = new DoublyNode(value, null, null);
        if (first == last && first == null) {
            newNode.next = last;
            newNode.past = first;
            last = first = newNode;
        } else {
            newNode.past = last;
            newNode.next = null;
            last.next = newNode;
            last = newNode;
        }
    }

    public void addNextTo(DoublyLinkedList list, int pastOf, int value) {
        DoublyNode add = new DoublyNode(value, null, null);
        Find f = new Find();
        DoublyNode pastNode = f.findFromFront(list, pastOf);
        if (pastNode != null) {
            add.next = pastNode.next;
            pastNode.next.past = add;
            add.past = pastNode;
            pastNode.next = add;
        }
    }

    public Object RemoveFromFront() {
        DoublyNode cur = first;
        
        if (cur != null) {
            if (cur == last) {
                setFirst(null);
                setLast(null);
            } else {
                setFirst(cur.next);
                cur.next.past = null;
            }
            return cur.value;
        }
        return null;
    }
}

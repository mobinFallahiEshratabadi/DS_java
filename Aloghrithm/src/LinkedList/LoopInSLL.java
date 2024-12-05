package LinkedList;

public class LoopInSLL {
    public boolean detect(SingleLinkedList node) {
        SingleNode frontSingleNode = node.first;
        SingleNode backSingleNode = node.first;

        while (frontSingleNode != null && frontSingleNode.next != null) {
            frontSingleNode = frontSingleNode.next.next;
            backSingleNode = backSingleNode.next;

            if (backSingleNode == frontSingleNode) {
                return true;
            }
        }
        return false;
    }

    public SingleNode firstOfLoop(SingleLinkedList node) {
        SingleNode frontSingleNode = node.first;
        SingleNode backSingleNode = node.first;

        while (frontSingleNode != null && frontSingleNode.next != null) {
            frontSingleNode = frontSingleNode.next.next;
            backSingleNode = backSingleNode.next;

            if (backSingleNode == frontSingleNode) {
                return getStartingNode(node, backSingleNode);
            }
        }
        return null;
    }

    private SingleNode getStartingNode(SingleLinkedList node, SingleNode backSingleNode) {
        SingleNode temp = node.first;
        while (temp != backSingleNode) {
            backSingleNode = backSingleNode.next;
            temp = temp.next;
        }

        return temp;
    }

    public void remove(SingleLinkedList node) {
        SingleNode frontSingleNode = node.first;
        SingleNode backSingleNode = node.first;

        while (frontSingleNode != null && frontSingleNode.next != null) {
            frontSingleNode = frontSingleNode.next.next;
            backSingleNode = backSingleNode.next;

            if (backSingleNode == frontSingleNode) {
                removeLoop(node, backSingleNode);
                return;
            }
        }
    }

    private void removeLoop(SingleLinkedList node, SingleNode backSingleNode) {
        SingleNode temp = node.first;
        while (temp.next != backSingleNode.next) {
            backSingleNode = backSingleNode.next;
            temp = temp.next;
        }
        backSingleNode.next = null;
    }
}

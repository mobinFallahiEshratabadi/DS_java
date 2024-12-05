package LinkedList;

public class MergeSortedSLL {
    public SingleLinkedList merge(SingleNode singleNode1, SingleNode singleNode2) {
       /* SingleLinkedList mergeList = new SingleLinkedList();

        while (node1 != null || node2 != null) {
            if (node1 == null) {
                mergeList.addBack(node2.value);
                node2 = node2.next;
            } else if (node2 == null) {
                mergeList.addBack(node1.value);
                node1 = node1.next;
            } else {
                if (mergeList.first == null) {
                    if (node1.value > node2.value) {
                        mergeList.addFront(node2.value);
                        node2 = node2.next;
                    } else {
                        mergeList.addFront(node1.value);
                        node1 = list1.next;
                    }
                } else {
                    if (node1.value > node2.value) {
                        mergeList.addBack(node2.value);
                        node2 = node2.next;
                    } else {
                        mergeList.addBack(node1.value);
                        node1 = node1.next;
                    }
                }
            }
        }

        return mergeList;*/
        SingleLinkedList merged = new SingleLinkedList();
        SingleNode dummy = new SingleNode(0, null);
        merged.addFront(dummy.value);
        while (singleNode1 != null && singleNode2 != null) {
            if (singleNode1.value <= singleNode2.value) {
                merged.addBack(singleNode1.value);
                singleNode1 = singleNode1.next;
            } else {
                merged.addBack(singleNode2.value);
                singleNode2 = singleNode2.next;
            }
        }

        if (singleNode1 == null) {
            while (singleNode2 != null) {
                merged.addBack(singleNode2.value);
                singleNode2 = singleNode2.next;
            }
        } else {
            while (singleNode1 != null) {
                merged.addBack(singleNode1.value);
                singleNode1 = singleNode1.next;
            }
        }
        merged.first = merged.first.next;
        return merged;
    }

    private void add(SingleNode list1, SingleNode list2, SingleLinkedList mergeList) {
        if (mergeList.first == null) {
            if (list1.value > list2.value) {
                mergeList.first = list2;
                list2 = list2.next;
            } else {
                mergeList.first = list1;
                list1 = list1.next;
            }
            return;
        }
        if (list1.value > list2.value) {
            mergeList.addBack(list2.value);
            list2 = list2.next;
        } else {
            mergeList.addBack(list1.value);
            list1 = list1.next;
        }
    }
}

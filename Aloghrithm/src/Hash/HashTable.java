package Hash;

import java.util.Objects;

public class HashTable {
    public HashNode[] buckets;
    public int numOfBuckets;
    public int size;

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        buckets = new HashNode[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is null !!");
        }
        int bucketIndex = getBucketsIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (key.equals(head.key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int getBucketsIndex(Integer key) {
        return key % numOfBuckets;
    }

    public String get(Integer key) {
        int bucketIndex = getBucketsIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (key.equals(head.key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key) {
        int bucketIndex = getBucketsIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;
        while (head != null) {
            if (key.equals(head.key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) {return null;}
        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }

        return head.value;
    }
}

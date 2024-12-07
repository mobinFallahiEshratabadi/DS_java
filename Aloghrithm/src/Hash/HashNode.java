package Hash;

public class HashNode {
    public Integer key; // can be generic
    public String value; // can be generic
    public HashNode next;

    public HashNode(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}

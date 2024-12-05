package Tree;

public class TreeNode {
    public int value; // generic type
    public TreeNode left;
    public TreeNode right;
    public boolean threaded = false;

    public TreeNode(int value) {
        this.value = value;
    }
}

package AVLTree;

public class AVLNode {
    public int value;
    public AVLNode leftChild;
    public AVLNode rightChild;
    public int height;

    public AVLNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return "Value = " + this.value;
    }
}

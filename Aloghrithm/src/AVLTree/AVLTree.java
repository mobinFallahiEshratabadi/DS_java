package AVLTree;

public class AVLTree {
    public AVLNode root;

    public AVLTree(AVLNode root) {
        this.root = root;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else {
            node.rightChild = insert(node.rightChild, value);
        }

        setHeight(node);
        return balance(node);
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0) {
                node.leftChild = rotateLeft(node.leftChild);
            }
            return rotateRight(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0) {
                node.rightChild = rotateRight(node.rightChild);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(AVLNode node) {
        return height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }
}
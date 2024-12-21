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

    public boolean search(AVLNode node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return search(node.leftChild, value);
        } else {
            return search(node.rightChild, value);
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private AVLNode delete(AVLNode node, int value) {
        if (node == null) return null;

        if (value < node.value) {
            node.leftChild = delete(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = delete(node.rightChild, value);
        } else {
            if (node.leftChild == null) return node.rightChild;
            if (node.rightChild == null) return node.leftChild;

            AVLNode minNode = findMin(node.rightChild);
            node.value = minNode.value;
            node.rightChild = delete(node.rightChild, minNode.value);
        }

        setHeight(node);
        return balance(node);
    }

    private AVLNode findMin(AVLNode node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
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
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;

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

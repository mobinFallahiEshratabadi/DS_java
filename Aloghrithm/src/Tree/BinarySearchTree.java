package Tree;

// the left subtree of nodes contains only nodes which values less than the node value
// the right subtree of nodes contains only nodes which values more than the node value

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.value) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int key) {
        if (root == null || key == root.value) {
            return root;
        }

        if (key < root.value) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        boolean left = isValid(root.left, min, root.value);
        if (left) {
            return isValid(root.right, root.value, max); // isValid right
        }
        return false;

    }
}

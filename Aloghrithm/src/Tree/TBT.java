package Tree;

public class TBT {
    public TreeNode root;
    public TreeNode prev = null;

    public TBT(TreeNode root) {
        this.root = root;
    }

    public void convertToPreThreaded() {
        convertToThreadedPre(root, null);
    }

    private TreeNode convertToThreadedPre(TreeNode node, TreeNode predecessor) {
        if (node == null) {
            return predecessor;
        }

        if (predecessor != null && predecessor.right == null) {
            predecessor.right = node;
            predecessor.threaded = true;
        }

        TreeNode rightSubtree = node.right;

        predecessor = convertToThreadedPre(node.left, node);

        return convertToThreadedPre(rightSubtree, predecessor);
    }

    public void preOrderTraversal() {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.value + " ");

            if (current.left != null) {
                current = current.left;
            } else if (current.threaded) {
                current = current.right;
            } else {
                current = null;
            }
        }
    }

    public void createInorderThreadedTree(TreeNode root) {
        if (root == null) {
            return;
        }
        createInorderThreadedTree(root.left);

        if (prev != null && prev.right == null) {
            prev.right = root;
            prev.threaded = true;
        }

        prev = root;

        createInorderThreadedTree(root.right);
    }

    public void inorderTraversal() {
        TreeNode current = root;

        while (current.left != null) {
            current = current.left;
        }

        while (current != null) {
            System.out.print(current.value + " ");

            if (current.threaded) {
                current = current.right;
            } else {
                current = current.right;
                while (current != null && current.left != null) {
                    current = current.left;
                }
            }
        }
    }

    public void createPostOrderThreadedTree(TreeNode root) {
        if (root == null) {
            return;
        }

        createPostOrderThreadedTree(root.left);

        createPostOrderThreadedTree(root.right);

        if (root.right == null) {
            root.right = prev;
            root.threaded = true;
        }

        prev = root;
    }

    public void postOrderTraversal() {
        TreeNode current = root;

        while (current != null) {
            if (current.right != null && !current.threaded) {
                current = current.right;
            } else if (current.left != null) {
                current = current.left;
            } else {
                break;
            }
        }

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.right;
        }
    }
}

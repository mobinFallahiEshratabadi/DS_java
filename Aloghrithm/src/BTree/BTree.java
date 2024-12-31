package BTree;


public class BTree {
    private BTreeNode root;
    private int t;

    public BTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void traverse() {
        if (root != null) {
            root.traverse();
        }
    }

    public BTreeNode search(int key) {
        return root == null ? null : root.search(key);
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);
                int i = 0;
                if (s.keys[0] < key) {
                    i++;
                }
                s.children[i].insertNonFull(key);
                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    public void delete(int key) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        root.delete(key);
        if (root.n == 0) {
            if (root.isLeaf) {
                root = null;
            } else {
                root = root.children[0];
            }
        }
    }
}

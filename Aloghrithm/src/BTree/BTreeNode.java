package BTree;

class BTreeNode {
    int[] keys;
    int t;
    BTreeNode[] children;
    int n;
    boolean isLeaf;

    public BTreeNode(int t, boolean isLeaf) {
        this.t = t;
        this.isLeaf = isLeaf;
        this.keys = new int[2 * t - 1];
        this.children = new BTreeNode[2 * t];
        this.n = 0;
    }

    public void traverse() {
        for (int i = 0; i < n; i++) {
            if (!isLeaf) {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }
        if (!isLeaf) {
            children[n].traverse();
        }
    }

    public BTreeNode search(int key) {
        int i = 0;
        while (i < n && key > keys[i]) {
            i++;
        }
        if (i < n && keys[i] == key) {
            return this;
        }
        if (isLeaf) {
            return null;
        }
        return children[i].search(key);
    }

    public void insertNonFull(int key) {
        int i = n - 1;

        if (isLeaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            n++;
        } else {
            while (i >= 0 && keys[i] > key) {
                i--;
            }
            if (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, children[i + 1]);
                if (keys[i + 1] < key) {
                    i++;
                }
            }
            children[i + 1].insertNonFull(key);
        }
    }

    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.isLeaf);
        z.n = t - 1;

        if (t - 1 >= 0) System.arraycopy(y.keys, t, z.keys, 0, t - 1);

        if (!y.isLeaf) {
            if (t >= 0) System.arraycopy(y.children, t, z.children, 0, t);
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }

        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }

        keys[i] = y.keys[t - 1];
        n++;
    }

    public void delete(int key) {
        int idx = findKey(key);

        if (idx < n && keys[idx] == key) {
            if (isLeaf) {
                removeFromLeaf(idx);
            } else {
                removeFromNonLeaf(idx);
            }
        } else {
            if (isLeaf) {
                System.out.println("The key " + key + " is not in the tree.");
                return;
            }

            boolean flag = (idx == n);
            if (children[idx].n < t) {
                fill(idx);
            }

            if (flag && idx > n) {
                children[idx - 1].delete(key);
            } else {
                children[idx].delete(key);
            }
        }
    }

    private int findKey(int key) {
        int idx = 0;
        while (idx < n && keys[idx] < key) {
            idx++;
        }
        return idx;
    }

    private void removeFromLeaf(int idx) {
        for (int i = idx + 1; i < n; i++) {
            keys[i - 1] = keys[i];
        }
        n--;
    }

    private void removeFromNonLeaf(int idx) {
        int key = keys[idx];
        if (children[idx].n >= t) {
            int pred = getPredecessor(idx);
            keys[idx] = pred;
            children[idx].delete(pred);
        } else if (children[idx + 1].n >= t) {
            int succ = getSuccessor(idx);
            keys[idx] = succ;
            children[idx + 1].delete(succ);
        } else {
            merge(idx);
            children[idx].delete(key);
        }
    }

    private int getPredecessor(int idx) {
        BTreeNode cur = children[idx];
        while (!cur.isLeaf) {
            cur = cur.children[cur.n];
        }
        return cur.keys[cur.n - 1];
    }

    private int getSuccessor(int idx) {
        BTreeNode cur = children[idx + 1];
        while (!cur.isLeaf) {
            cur = cur.children[0];
        }
        return cur.keys[0];
    }

    private void fill(int idx) {
        if (idx != 0 && children[idx - 1].n >= t) {
            borrowFromPrev(idx);
        } else if (idx != n && children[idx + 1].n >= t) {
            borrowFromNext(idx);
        } else {
            if (idx != n) {
                merge(idx);
            } else {
                merge(idx - 1);
            }
        }
    }

    private void borrowFromPrev(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx - 1];

        for (int i = child.n - 1; i >= 0; i--) {
            child.keys[i + 1] = child.keys[i];
        }

        if (!child.isLeaf) {
            for (int i = child.n; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }

        child.keys[0] = keys[idx - 1];

        if (!child.isLeaf) {
            child.children[0] = sibling.children[sibling.n];
        }

        keys[idx - 1] = sibling.keys[sibling.n - 1];
        child.n++;
        sibling.n--;
    }

    private void borrowFromNext(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];

        child.keys[child.n] = keys[idx];

        if (!child.isLeaf) {
            child.children[child.n + 1] = sibling.children[0];
        }

        keys[idx] = sibling.keys[0];

        for (int i = 1; i < sibling.n; i++) {
            sibling.keys[i - 1] = sibling.keys[i];
        }

        if (!sibling.isLeaf) {
            for (int i = 1; i <= sibling.n; i++) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }

        child.n++;
        sibling.n--;
    }

    private void merge(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];

        child.keys[t - 1] = keys[idx];

        if (sibling.n >= 0) System.arraycopy(sibling.keys, 0, child.keys, t, sibling.n);

        if (!child.isLeaf) {
            if (sibling.n + 1 >= 0) System.arraycopy(sibling.children, 0, child.children, t, sibling.n + 1);
        }

        for (int i = idx + 1; i < n; i++) {
            keys[i - 1] = keys[i];
        }

        for (int i = idx + 2; i <= n; i++) {
            children[i - 1] = children[i];
        }

        child.n += sibling.n + 1;
        n--;
    }
}


package RedBlackTree;


import java.awt.Color;

public class RedBlackTree {
    private RBNode root;
    private final RBNode nullNode = new RBNode(0, Color.BLACK);

    public RedBlackTree() {
        this.root = nullNode;
    }


    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }

    public RBNode getNullNode() {
        return nullNode;
    }

    public void insert(int value) {
        RBNode newNode = new RBNode(value, Color.RED);
        newNode.setLeft(nullNode);
        newNode.setRight(nullNode);
        newNode.setParent(null);

        RBNode current = root;
        RBNode parent = null;

        while (current != nullNode) {
            parent = current;
            if (newNode.getValue() < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        newNode.setParent(parent);

        if (parent == null) {
            root = newNode;
        } else if (newNode.getValue() < parent.getValue()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        balanceInsert(newNode);
    }

    private void balanceInsert(RBNode newNode) {
        while (newNode.getParent() != null && newNode.getParent().getColor().equals(Color.RED)) {
            if (newNode.getParent() == newNode.getParent().getParent().getLeft()) {
                RBNode y = newNode.getParent().getParent().getRight();
                if (y.getColor().equals(Color.RED)) {
                    newNode.getParent().setColor(Color.BLACK);
                    y.setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    newNode = newNode.getParent().getParent();
                } else {
                    if (newNode == newNode.getParent().getRight()) {
                        newNode = newNode.getParent();
                        leftRotate(newNode);
                    }
                    newNode.getParent().setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    rightRotate(newNode.getParent().getParent());
                }
            } else {
                RBNode y = newNode.getParent().getParent().getLeft();
                if (y.getColor().equals(Color.RED)) {
                    newNode.getParent().setColor(Color.BLACK);
                    y.setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    newNode = newNode.getParent().getParent();
                } else {
                    if (newNode == newNode.getParent().getLeft()) {
                        newNode = newNode.getParent();
                        rightRotate(newNode);
                    }
                    newNode.getParent().setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    leftRotate(newNode.getParent().getParent());
                }
            }
        }
        root.setColor(Color.BLACK);
    }

    private void rightRotate(RBNode newNode) {
        RBNode x = newNode.getLeft();
        newNode.setLeft(x.getRight());
        if (x.getRight() != nullNode) {
            x.getRight().setParent(newNode);
        }
        x.setParent(newNode.getParent());
        if (newNode.getParent() == null) {
            root = x;
        } else if (newNode == newNode.getParent().getRight()) {
            newNode.getParent().setRight(x);
        } else {
            newNode.getParent().setLeft(x);
        }
        x.setRight(newNode);
        newNode.setParent(x);
    }

    private void leftRotate(RBNode newNode) {
        RBNode y = newNode.getRight();
        newNode.setRight(y.getLeft());
        if (y.getLeft() != nullNode) {
            y.getLeft().setParent(newNode);
        }
        y.setParent(newNode.getParent());
        if (newNode.getParent() == null) {
            root = y;
        } else if (newNode == newNode.getParent().getLeft()) {
            newNode.getParent().setLeft(y);
        } else {
            newNode.getParent().setRight(y);
        }
        y.setLeft(newNode);
        newNode.setParent(y);
    }

    public void delete(int value) {
        RBNode nodeToDelete = search(root, value);
        if (nodeToDelete == nullNode) {
            System.out.println("Value not found in the tree.");
            return;
        }

        RBNode y = nodeToDelete;
        RBNode x;
        Color originalColor = y.getColor();

        if (nodeToDelete.getLeft() == nullNode) {
            x = nodeToDelete.getRight();
            transplant(nodeToDelete, nodeToDelete.getRight());
        } else if (nodeToDelete.getRight() == nullNode) {
            x = nodeToDelete.getLeft();
            transplant(nodeToDelete, nodeToDelete.getLeft());
        } else {
            y = treeMinimum(nodeToDelete.getRight());
            originalColor = y.getColor();
            x = y.getRight();
            if (y.getParent() == nodeToDelete) {
                x.setParent(y);
            } else {
                transplant(y, y.getRight());
                y.setRight(nodeToDelete.getRight());
                y.getRight().setParent(y);
            }
            transplant(nodeToDelete, y);
            y.setLeft(nodeToDelete.getLeft());
            y.getLeft().setParent(y);
            y.setColor(nodeToDelete.getColor());
        }

        if (originalColor == Color.BLACK) {
            balanceDelete(x);
        }
    }

    private void balanceDelete(RBNode x) {
        while (x != root && x.getColor() == Color.BLACK) {
            if (x == x.getParent().getLeft()) {
                RBNode w = x.getParent().getRight();
                if (w.getColor() == Color.RED) {
                    w.setColor(Color.BLACK);
                    x.getParent().setColor(Color.RED);
                    leftRotate(x.getParent());
                    w = x.getParent().getRight();
                }
                if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
                    w.setColor(Color.RED);
                    x = x.getParent();
                } else {
                    if (w.getRight().getColor() == Color.BLACK) {
                        w.getLeft().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        rightRotate(w);
                        w = x.getParent().getRight();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor(Color.BLACK);
                    w.getRight().setColor(Color.BLACK);
                    leftRotate(x.getParent());
                    x = root;
                }
            } else {
                RBNode w = x.getParent().getLeft();
                if (w.getColor() == Color.RED) {
                    w.setColor(Color.BLACK);
                    x.getParent().setColor(Color.RED);
                    rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                }
                if (w.getRight().getColor() == Color.BLACK && w.getLeft().getColor() == Color.BLACK) {
                    w.setColor(Color.RED);
                    x = x.getParent();
                } else {
                    if (w.getLeft().getColor() == Color.BLACK) {
                        w.getRight().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        leftRotate(w);
                        w = x.getParent().getLeft();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor(Color.BLACK);
                    w.getLeft().setColor(Color.BLACK);
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }
        x.setColor(Color.BLACK);
    }

    private void transplant(RBNode u, RBNode v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        v.setParent(u.getParent());
    }

    private RBNode treeMinimum(RBNode node) {
        while (node.getLeft() != nullNode) {
            node = node.getLeft();
        }
        return node;
    }


    private RBNode search(RBNode node, int value) {
        while (node != nullNode && value != node.getValue()) {
            if (value < node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    public boolean search(int value) {

        RBNode current = root;

        while (current != nullNode) {
            if (value == current.getValue()) {
                System.out.println("Node found: " + value);
                return true;
            } else if (value < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        System.out.println("Node not found: " + value);
        return false;
    }

}

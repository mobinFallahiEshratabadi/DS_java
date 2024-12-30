package RedBlackTree;


import javax.swing.*;
import java.awt.*;

class TreePanel extends JPanel {
    private RedBlackTree tree;

    public TreePanel(RedBlackTree tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, tree.getRoot(), getWidth() / 2, 30, 50);
    }

    private void drawTree(Graphics g, RBNode node, int x, int y, int xOffset) {
        if (node == tree.getNullNode()) {
            return;
        }
        g.setColor(node.getColor() == Color.RED ? Color.RED : Color.BLACK);
        g.fillOval(x - 20, y - 20, 40, 40);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(node.getValue()), x - 10, y + 5);

        if (node.getLeft() != tree.getNullNode()) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - xOffset, y + 50);
            drawTree(g, node.getLeft(), x - xOffset, y + 50, xOffset / 2);
        }

        if (node.getRight() != tree.getNullNode()) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + xOffset, y + 50);
            drawTree(g, node.getRight(), x + xOffset, y + 50, xOffset / 2);
        }
    }
}
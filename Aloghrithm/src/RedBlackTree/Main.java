package RedBlackTree;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        JFrame frame = new JFrame("Red-Black Tree Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        TreePanel panel = new TreePanel(tree);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JTextField inputField = new JTextField(10);
        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");
        JLabel resultLabel = new JLabel("");

        controls.add(inputField);
        controls.add(insertButton);
        controls.add(deleteButton);
        controls.add(searchButton);
        controls.add(resultLabel);

        frame.add(controls, BorderLayout.SOUTH);

        insertButton.addActionListener(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                tree.insert(value);
                panel.repaint();
                resultLabel.setText("Inserted: " + value);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                tree.delete(value);
                panel.repaint();
                resultLabel.setText("Deleted: " + value);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        searchButton.addActionListener(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                if (tree.search(value)) {
                    resultLabel.setText("Found: " + value);
                } else {
                    resultLabel.setText("Not Found");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        frame.setVisible(true);
    }
}
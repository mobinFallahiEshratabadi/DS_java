package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecursiveTraversalBT {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.value + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void inOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.value + " ");
                temp = temp.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public void postOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.value + " ");
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        System.out.print(temp.value + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int result = root.value;
        int left = findMax(root.left);
        int right = findMax(root.right);

        result = Math.max(result, left);
        result = Math.max(result, right);

        return result;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();

        RecursiveTraversalBT rt = new RecursiveTraversalBT();
        rt.preOrder(bt.getRoot());
        System.out.println();
        rt.preOrderStack(bt.getRoot());
        System.out.println();
        rt.inOrder(bt.getRoot());
        System.out.println();
        rt.inOrderStack(bt.getRoot());
        System.out.println();
        System.out.println(rt.findMax(bt.getRoot()));
    }
}

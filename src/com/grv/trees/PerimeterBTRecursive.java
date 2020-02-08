package com.grv.trees;

public class PerimeterBTRecursive {

    private void printLeftView(BinaryTreeNode node) {

        // bottom up for clock wise

        if (node == null) {
            return;
        }

        if (node.left != null) {
            printLeftView(node.left);
            System.out.print(node.data + ", ");
        } else if (node.right != null) {
            printLeftView(node.right);
            System.out.print(node.data + ", ");
        }

    }

    private void printRightView(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            System.out.print(node.data + ", ");
            printRightView(node.right);
        } else if (node.left != null) {
            System.out.print(node.data + ", ");
            printRightView(node.left);
        }

    }

    private void printLeaves(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        printLeaves(node.right);

        if (node.left == null && node.right == null) {
            System.out.print(node.data + ", ");
        }

        printLeaves(node.left);
    }

    public void printPerimeter(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + ", ");

            printRightView(root.right);
            printLeaves(root.right);
            printLeaves(root.left);
            printLeftView(root.left);
        }
    }
}

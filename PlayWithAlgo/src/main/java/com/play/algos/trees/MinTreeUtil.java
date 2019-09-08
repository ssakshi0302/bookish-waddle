package com.play.algos.trees;

public class MinTreeUtil {
  static BinaryTreeNode root;

  public static void main(String[] args) {
    createSampleTree();
    int min = findMin(root);
    System.out.println(min);
  }

  private static int findMin(final BinaryTreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    return Math.min(Math.min(root.data, findMin(root.left)), Math.min(root.data, findMin(root.right)));
  }

  private static void createSampleTree() {
    root = new BinaryTreeNode(5);
    root.setLeft(new BinaryTreeNode(3));
    root.left.setLeft(new BinaryTreeNode(4));
    root.left.left.setLeft(new BinaryTreeNode(5));
    root.left.left.left.setLeft(new BinaryTreeNode(10));
    root.left.left.left.setRight(new BinaryTreeNode(3));
    root.left.left.left.right.setLeft(new BinaryTreeNode(2));
    root.left.left.setRight(new BinaryTreeNode(2));
    root.left.left.right.setLeft(new BinaryTreeNode(6));
    root.left.left.right.setRight(new BinaryTreeNode(3));
    root.left.setRight(new BinaryTreeNode(7));
    root.setRight(new BinaryTreeNode(5));
    root.right.setLeft(new BinaryTreeNode(3));
    root.right.setRight(new BinaryTreeNode(2));
    root.right.left.setLeft(new BinaryTreeNode(4));
    root.right.left.setRight(new BinaryTreeNode(6));
    root.right.right.setLeft(new BinaryTreeNode(8));
    root.right.right.setRight(new BinaryTreeNode(5));
    root.right.right.right.setRight(new BinaryTreeNode(2));
    root.right.right.right.setLeft(new BinaryTreeNode(2));
    root.right.right.right.left.setLeft(new BinaryTreeNode(2));
    root.right.right.right.left.setRight(new BinaryTreeNode(12));
  }
}
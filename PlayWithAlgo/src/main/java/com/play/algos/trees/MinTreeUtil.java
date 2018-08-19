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
    return Math.min(Math.min(root.data, findMin(root.leftNode)), Math.min(root.data, findMin(root.rightNode)));
  }

  private static void createSampleTree() {
    root = new BinaryTreeNode(5);
    root.setLeftNode(new BinaryTreeNode(3));
    root.leftNode.setLeftNode(new BinaryTreeNode(4));
    root.leftNode.leftNode.setLeftNode(new BinaryTreeNode(5));
    root.leftNode.leftNode.leftNode.setLeftNode(new BinaryTreeNode(10));
    root.leftNode.leftNode.leftNode.setRightNode(new BinaryTreeNode(3));
    root.leftNode.leftNode.leftNode.rightNode.setLeftNode(new BinaryTreeNode(2));
    root.leftNode.leftNode.setRightNode(new BinaryTreeNode(2));
    root.leftNode.leftNode.rightNode.setLeftNode(new BinaryTreeNode(6));
    root.leftNode.leftNode.rightNode.setRightNode(new BinaryTreeNode(3));
    root.leftNode.setRightNode(new BinaryTreeNode(7));
    root.setRightNode(new BinaryTreeNode(5));
    root.rightNode.setLeftNode(new BinaryTreeNode(3));
    root.rightNode.setRightNode(new BinaryTreeNode(2));
    root.rightNode.leftNode.setLeftNode(new BinaryTreeNode(4));
    root.rightNode.leftNode.setRightNode(new BinaryTreeNode(6));
    root.rightNode.rightNode.setLeftNode(new BinaryTreeNode(8));
    root.rightNode.rightNode.setRightNode(new BinaryTreeNode(5));
    root.rightNode.rightNode.rightNode.setRightNode(new BinaryTreeNode(2));
    root.rightNode.rightNode.rightNode.setLeftNode(new BinaryTreeNode(2));
    root.rightNode.rightNode.rightNode.leftNode.setLeftNode(new BinaryTreeNode(2));
    root.rightNode.rightNode.rightNode.leftNode.setRightNode(new BinaryTreeNode(12));
  }
}
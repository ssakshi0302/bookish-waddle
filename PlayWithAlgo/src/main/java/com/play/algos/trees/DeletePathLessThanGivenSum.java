package com.play.algos.trees;

public class DeletePathLessThanGivenSum {
  static BinaryTreeNode root;
  static int inputSum = 20;

  public static void main(String[] args) {
    createSampleTree();
    System.out.println(root);
    deletePathsForAGivenSum(root, 0);
    System.out.println(root);
  }

  private static BinaryTreeNode deletePathsForAGivenSum(final BinaryTreeNode node, int sumTillPath) {
    if (node == null) {
      return null;
    }
    sumTillPath += node.data;
    int leftSum= sumTillPath;
    int rightSum = sumTillPath;
    node.left = deletePathsForAGivenSum(node.left, leftSum);
    node.right = deletePathsForAGivenSum(node.right, rightSum);
    if (Math.max(leftSum, rightSum) < inputSum) {
      return null;
    }
    return node;
  }

  private static void createSampleTree() {
    root = new BinaryTreeNode(5);
    root.setLeft(new BinaryTreeNode(3));
    root.left.setLeft(new BinaryTreeNode(4));
    root.left.left.setLeft(new BinaryTreeNode(5));
    root.left.left.left.setLeft(new BinaryTreeNode(1));
    root.left.left.left.setRight(new BinaryTreeNode(3));
    root.left.left.left.right.setLeft(new BinaryTreeNode(1));
    root.left.left.setRight(new BinaryTreeNode(2));
    root.left.left.right.setLeft(new BinaryTreeNode(6));
    root.left.left.right.setRight(new BinaryTreeNode(3));
    root.left.setRight(new BinaryTreeNode(1));
    root.setRight(new BinaryTreeNode(5));
    root.right.setLeft(new BinaryTreeNode(3));
    root.right.setRight(new BinaryTreeNode(2));
    root.right.left.setLeft(new BinaryTreeNode(4));
    root.right.left.setRight(new BinaryTreeNode(6));
    root.right.right.setLeft(new BinaryTreeNode(8));
    root.right.right.setRight(new BinaryTreeNode(5));
    root.right.right.right.setRight(new BinaryTreeNode(2));
    root.right.right.right.setLeft(new BinaryTreeNode(1));
    root.right.right.right.left.setLeft(new BinaryTreeNode(2));
    root.right.right.right.left.setRight(new BinaryTreeNode(1));
  }
}

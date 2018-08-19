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
    node.leftNode = deletePathsForAGivenSum(node.leftNode, leftSum);
    node.rightNode = deletePathsForAGivenSum(node.rightNode, rightSum);
    if (Math.max(leftSum, rightSum) < inputSum) {
      return null;
    }
    return node;
  }

  private static void createSampleTree() {
    root = new BinaryTreeNode(5);
    root.setLeftNode(new BinaryTreeNode(3));
    root.leftNode.setLeftNode(new BinaryTreeNode(4));
    root.leftNode.leftNode.setLeftNode(new BinaryTreeNode(5));
    root.leftNode.leftNode.leftNode.setLeftNode(new BinaryTreeNode(1));
    root.leftNode.leftNode.leftNode.setRightNode(new BinaryTreeNode(3));
    root.leftNode.leftNode.leftNode.rightNode.setLeftNode(new BinaryTreeNode(1));
    root.leftNode.leftNode.setRightNode(new BinaryTreeNode(2));
    root.leftNode.leftNode.rightNode.setLeftNode(new BinaryTreeNode(6));
    root.leftNode.leftNode.rightNode.setRightNode(new BinaryTreeNode(3));
    root.leftNode.setRightNode(new BinaryTreeNode(1));
    root.setRightNode(new BinaryTreeNode(5));
    root.rightNode.setLeftNode(new BinaryTreeNode(3));
    root.rightNode.setRightNode(new BinaryTreeNode(2));
    root.rightNode.leftNode.setLeftNode(new BinaryTreeNode(4));
    root.rightNode.leftNode.setRightNode(new BinaryTreeNode(6));
    root.rightNode.rightNode.setLeftNode(new BinaryTreeNode(8));
    root.rightNode.rightNode.setRightNode(new BinaryTreeNode(5));
    root.rightNode.rightNode.rightNode.setRightNode(new BinaryTreeNode(2));
    root.rightNode.rightNode.rightNode.setLeftNode(new BinaryTreeNode(1));
    root.rightNode.rightNode.rightNode.leftNode.setLeftNode(new BinaryTreeNode(2));
    root.rightNode.rightNode.rightNode.leftNode.setRightNode(new BinaryTreeNode(1));
  }
}

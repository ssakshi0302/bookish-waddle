package com.play.algos.trees;

public class RightViewUtil {
  static BinaryTreeNode root;
  static int maxLevel = -1;
  public static void main(String[] args) {
    createSampleTree();
    printRightView();
  }

  private static void printRightView() {

    int currentLevel = 0;
    printRightView(root, currentLevel);
  }

  private static void printRightView(BinaryTreeNode node, int currentLevel) {
    if (node == null) return;
    if (currentLevel > maxLevel) {
      maxLevel = currentLevel;
      System.out.println(node.data);
    }
    printRightView(node.rightNode, currentLevel + 1);
    printRightView(node.leftNode, currentLevel + 1);

  }

  private static void createSampleTree() {
    root = new BinaryTreeNode();
    root.setData(1);
    root.setLeftNode(new BinaryTreeNode());
    root.leftNode.setData(2);
    root.leftNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.leftNode.setData(3);
    root.leftNode.leftNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.leftNode.leftNode.setData(4);
    root.leftNode.leftNode.setRightNode(new BinaryTreeNode());
    root.leftNode.leftNode.rightNode.setData(5);
    root.leftNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.setData(6);
    root.leftNode.rightNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.rightNode.setData(7);
    root.leftNode.rightNode.rightNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.rightNode.rightNode.leftNode.setData(8);
    root.setRightNode(new BinaryTreeNode());
    root.rightNode.setData(9);
    root.rightNode.setLeftNode(new BinaryTreeNode());
    root.rightNode.leftNode.setData(10);
    root.rightNode.setRightNode(new BinaryTreeNode());
    root.rightNode.rightNode.setData(11);
  }
}

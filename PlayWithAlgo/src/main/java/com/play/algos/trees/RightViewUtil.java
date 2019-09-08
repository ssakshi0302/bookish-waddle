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
    printRightView(node.right, currentLevel + 1);
    printRightView(node.left, currentLevel + 1);

  }

  private static void createSampleTree() {
    root = new BinaryTreeNode();
    root.setData(1);
    root.setLeft(new BinaryTreeNode());
    root.left.setData(2);
    root.left.setLeft(new BinaryTreeNode());
    root.left.left.setData(3);
    root.left.left.setLeft(new BinaryTreeNode());
    root.left.left.left.setData(4);
    root.left.left.setRight(new BinaryTreeNode());
    root.left.left.right.setData(5);
    root.left.setRight(new BinaryTreeNode());
    root.left.right.setData(6);
    root.left.right.setRight(new BinaryTreeNode());
    root.left.right.right.setData(7);
    root.left.right.right.setLeft(new BinaryTreeNode());
    root.left.right.right.left.setData(8);
    root.setRight(new BinaryTreeNode());
    root.right.setData(9);
    root.right.setLeft(new BinaryTreeNode());
    root.right.left.setData(10);
    root.right.setRight(new BinaryTreeNode());
    root.right.right.setData(11);
  }
}

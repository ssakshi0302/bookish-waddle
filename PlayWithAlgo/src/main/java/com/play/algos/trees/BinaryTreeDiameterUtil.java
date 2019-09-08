package com.play.algos.trees;

public class BinaryTreeDiameterUtil {
  static BinaryTreeNode root;
  static int diameter = 0;

  public static void main(String[] args) {
    createSampleTree();
    System.out.println(root);
    System.out.println(calculateHeight(root, 0));
    System.out.println(diameterOfATree(root));
    System.out.println(diameter);
  }

  private static void createSampleTree() {
    root = new BinaryTreeNode();
    root.setData(1);
    root.setLeft(new BinaryTreeNode());
    root.left.setData(2);
    root.left.setLeft(new BinaryTreeNode());
    root.left.left.setData(3);
    root.left.left.setLeft(new BinaryTreeNode());
    root.left.left.setRight(new BinaryTreeNode());
    root.left.left.right.setLeft(new BinaryTreeNode());
    root.left.left.right.left.setLeft(new BinaryTreeNode());
    root.left.setRight(new BinaryTreeNode());
    root.left.right.setData(4);
    root.left.right.setRight(new BinaryTreeNode());
    root.left.right.right.setData(5);
    root.left.right.right.setLeft(new BinaryTreeNode());
    root.left.right.right.left.setData(6);
    root.left.right.right.setRight(new BinaryTreeNode());
    root.left.right.right.right.setRight(new BinaryTreeNode());
    root.left.right.right.setLeft(new BinaryTreeNode());
    root.setRight(new BinaryTreeNode());
    root.right.setData(7);
    root.right.setLeft(new BinaryTreeNode());
    root.right.left.setData(8);
    root.right.setRight(new BinaryTreeNode());
    root.right.right.setData(9);
  }

  private static int calculateHeight(BinaryTreeNode node, int height) {
    if (node == null) {
      return height;
    }
    height++;
    return Math.max(calculateHeight(node.left, height),
        calculateHeight(node.right, height));
  }

  private static int diameterOfATree(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftDiameter = diameterOfATree(node.left);
    int rightDiameter = diameterOfATree(node.right);
    if (diameter < (leftDiameter+ rightDiameter)+1) {
      diameter = (leftDiameter+ rightDiameter) +1;
    }
    return Math.max(leftDiameter , rightDiameter) + 1;
  }
}

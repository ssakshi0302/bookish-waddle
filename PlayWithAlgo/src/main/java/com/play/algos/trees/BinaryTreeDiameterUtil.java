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
    root.setLeftNode(new BinaryTreeNode());
    root.leftNode.setData(2);
    root.leftNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.leftNode.setData(3);
    root.leftNode.leftNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.leftNode.setRightNode(new BinaryTreeNode());
    root.leftNode.leftNode.rightNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.leftNode.rightNode.leftNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.setData(4);
    root.leftNode.rightNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.rightNode.setData(5);
    root.leftNode.rightNode.rightNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.rightNode.rightNode.leftNode.setData(6);
    root.leftNode.rightNode.rightNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.rightNode.rightNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.rightNode.setLeftNode(new BinaryTreeNode());
    root.setRightNode(new BinaryTreeNode());
    root.rightNode.setData(7);
    root.rightNode.setLeftNode(new BinaryTreeNode());
    root.rightNode.leftNode.setData(8);
    root.rightNode.setRightNode(new BinaryTreeNode());
    root.rightNode.rightNode.setData(9);
  }

  private static int calculateHeight(BinaryTreeNode node, int height) {
    if (node == null) {
      return height;
    }
    height++;
    return Math.max(calculateHeight(node.leftNode, height),
        calculateHeight(node.rightNode, height));
  }

  private static int diameterOfATree(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftDiameter = diameterOfATree(node.leftNode);
    int rightDiameter = diameterOfATree(node.rightNode);
    if (diameter < (leftDiameter+ rightDiameter)+1) {
      diameter = (leftDiameter+ rightDiameter) +1;
    }
    return Math.max(leftDiameter , rightDiameter) + 1;
  }
}

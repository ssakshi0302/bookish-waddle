package com.play.algos.trees;

import java.util.Stack;

public class PreOrderTraversalUtil {
  static BinaryTreeNode root;

  public static void main(String[] args) {
    createSampleTree();
    traversePreOrder();
  }

  private static void traversePreOrder() {
    Stack<BinaryTreeNode> stack = new Stack<>();
    BinaryTreeNode node = root;
    while (true) {
      while (node != null) {
        System.out.println(node.getData());
        stack.push(node);
        node = node.leftNode;
      }
      if (stack.isEmpty()) {
        break;
      }
      node = stack.pop();
      node = node.getRightNode();
    }
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

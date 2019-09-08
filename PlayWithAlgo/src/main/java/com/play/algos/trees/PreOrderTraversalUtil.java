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
        node = node.left;
      }
      if (stack.isEmpty()) {
        break;
      }
      node = stack.pop();
      node = node.getRight();
    }
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

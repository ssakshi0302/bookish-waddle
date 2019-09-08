package com.play.algos.trees;

public class BTToDLL {
  static BinaryTreeNode head, prev, left, right;

  private static void binaryTreeToDLL(final BinaryTreeNode node) {
    if (node == null)
      return;

    // Recursively convert left subtree
    binaryTreeToDLL(node.left);

    // Now convert this node
    if (prev == null)
      head = node;
    else {
      node.left = prev;
      prev.right = node;
    }
    prev = node;

    // Finally convert right subtree
    binaryTreeToDLL(node.right);
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(12);
    root.right = new BinaryTreeNode(15);
    root.left.left = new BinaryTreeNode(25);
    root.left.right = new BinaryTreeNode(30);
    root.right.left = new BinaryTreeNode(36);
    binaryTreeToDLL(root);
    printList(head);
  }

  private static void printList(BinaryTreeNode node) {
    while (node != null) {
      System.out.println(node.data);
      node = node.right;
    }
  }
}
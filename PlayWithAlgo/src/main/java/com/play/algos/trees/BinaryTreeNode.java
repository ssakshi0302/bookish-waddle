package com.play.algos.trees;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class BinaryTreeNode {
  public int data;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  BinaryTreeNode(int data) {
    this.data = data;
  }

  public BinaryTreeNode() {
  }

  public void inOrderTraversal(final BinaryTreeNode node) {
    if (node != null) {
      inOrderTraversal(node.left);
      System.out.print(node.data + " ");
      inOrderTraversal(node.right);
    }
  }
}

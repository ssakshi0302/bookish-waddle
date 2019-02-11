package com.play.algos.trees;

public class BSTCorrectSwappedNotes {
  private static BinaryTreeNode root;
  private static BinaryTreeNode firstNode, couldBeNode, secondNode, previousNode;

  public static void main(final String[] args) {
    createSampleTree();
    root.inOrderTraversal(root);
    correctSwappedNodes(root);
    System.out.println(" ");
    root.inOrderTraversal(root);

  }

  private static void correctSwappedNodes(final BinaryTreeNode root) {
    findNodes(root);
    if (firstNode != null && secondNode != null) {
      swap(firstNode, secondNode);
    } else if (firstNode != null && couldBeNode != null) {
      swap(firstNode, couldBeNode);
    }
  }

  private static void swap(final BinaryTreeNode firstNode, final BinaryTreeNode secondNode) {
    int temp = firstNode.data;
    firstNode.data = secondNode.data;
    secondNode.data = temp;
  }

  private static void findNodes(final BinaryTreeNode node) {
    if (node != null) {
      findNodes(node.leftNode);
      if (previousNode != null && previousNode.data > node.data) {
        if (firstNode == null) {
          firstNode = previousNode;
          couldBeNode = node;
        } else {
          secondNode = node;
        }

      }
      previousNode = node;
      findNodes(node.rightNode);
    }
  }

  private static void createSampleTree() {
    root = new BinaryTreeNode(6);
    root.leftNode = new BinaryTreeNode(10);
    root.rightNode = new BinaryTreeNode(2);
    root.leftNode.leftNode = new BinaryTreeNode(1);
    root.leftNode.rightNode = new BinaryTreeNode(3);
    root.rightNode.rightNode = new BinaryTreeNode(12);
    root.rightNode.leftNode = new BinaryTreeNode(7);

  }
}

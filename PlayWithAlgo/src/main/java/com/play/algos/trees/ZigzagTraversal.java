package com.play.algos.trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigzagTraversal {

  static BinaryTreeNode root;

  public static void main(String[] args) {
    createSampleTree();
    zigzagLevelOrder(root);
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
  }

  public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(BinaryTreeNode A) {
    if (A == null) {
      return null;
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Stack<BinaryTreeNode> leftToRight = new Stack<>();
    Stack<BinaryTreeNode> rightToLeft = new Stack<>();
    rightToLeft.push(A);
    while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
      if (!rightToLeft.isEmpty()) {
        ArrayList<Integer> list = new ArrayList<>();
        while (!rightToLeft.isEmpty()) {
          BinaryTreeNode node = rightToLeft.pop();
          list.add(node.data);
          if (node.leftNode != null) {
            leftToRight.push(node.leftNode);
          }

          if (node.rightNode != null) {
            leftToRight.push(node.rightNode);
          }
        }
        result.add(list);

      }

      if (!leftToRight.isEmpty()) {
        ArrayList<Integer> list2 = new ArrayList<>();
        while (!leftToRight.isEmpty()) {
          BinaryTreeNode node = leftToRight.pop();
          list2.add(node.data);
          if (node.rightNode != null) {
            rightToLeft.push(node.rightNode);
          }

          if (node.leftNode != null) {
            rightToLeft.push(node.leftNode);
          }
        }
        result.add(list2);
      }

    }
    return result;
  }
}



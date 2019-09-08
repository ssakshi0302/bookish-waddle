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
    root.setLeft(new BinaryTreeNode(3));
    root.left.setLeft(new BinaryTreeNode(4));
    root.left.left.setLeft(new BinaryTreeNode(5));
    root.left.left.left.setLeft(new BinaryTreeNode(1));
    root.left.left.left.setRight(new BinaryTreeNode(3));
    root.left.left.left.right.setLeft(new BinaryTreeNode(1));
    root.left.left.setRight(new BinaryTreeNode(2));
    root.left.left.right.setLeft(new BinaryTreeNode(6));
    root.left.left.right.setRight(new BinaryTreeNode(3));
    root.left.setRight(new BinaryTreeNode(1));
    root.setRight(new BinaryTreeNode(5));
    root.right.setLeft(new BinaryTreeNode(3));
    root.right.setRight(new BinaryTreeNode(2));
    root.right.left.setLeft(new BinaryTreeNode(4));
    root.right.left.setRight(new BinaryTreeNode(6));
    root.right.right.setLeft(new BinaryTreeNode(8));
    root.right.right.setRight(new BinaryTreeNode(5));
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
          if (node.left != null) {
            leftToRight.push(node.left);
          }

          if (node.right != null) {
            leftToRight.push(node.right);
          }
        }
        result.add(list);

      }

      if (!leftToRight.isEmpty()) {
        ArrayList<Integer> list2 = new ArrayList<>();
        while (!leftToRight.isEmpty()) {
          BinaryTreeNode node = leftToRight.pop();
          list2.add(node.data);
          if (node.right != null) {
            rightToLeft.push(node.right);
          }

          if (node.left != null) {
            rightToLeft.push(node.left);
          }
        }
        result.add(list2);
      }

    }
    return result;
  }
}



package com.play.algos.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrintKPathSumUtill {
  static BinaryTreeNode root;
  static int count = 0;

  public static void main(String[] args) {
    createSampleTree();
    findSum(5);
    System.out.println(count);
    createSampleTree2();
    findSum(5);
    System.out.println(count);
  }

  private static void createSampleTree2() {
    root = new BinaryTreeNode();
    root.setData(1);
    root.setLeft(new BinaryTreeNode());
    root.left.setData(3);
    root.left.setLeft(new BinaryTreeNode());
    root.left.left.setData(2);
    root.left.setRight(new BinaryTreeNode());
    root.left.right.setData(1);
    root.left.right.setLeft(new BinaryTreeNode());
    root.left.right.left.setData(1);

    root.setRight(new BinaryTreeNode());
    root.right.setData(-1);
    root.right.setLeft(new BinaryTreeNode());
    root.right.left.setData(4);
    root.right.left.setLeft(new BinaryTreeNode());
    root.right.left.left.setData(1);
    root.right.left.setRight(new BinaryTreeNode());
    root.right.left.right.setData(2);
    root.right.setRight(new BinaryTreeNode());
    root.right.right.setData(5);
    root.right.right.setRight(new BinaryTreeNode());
    root.right.right.right.setData(6);
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

  static void findSum(Integer originalSum, Integer sum,
                      List<List<Integer>> result, List<Integer> currentList,
                      BinaryTreeNode node) {

    if (node == null) return;
    count++;
    Integer nodeValue = node.data;
    currentList.add(nodeValue);

    if (Objects.equals(sum, nodeValue)) {
      List<Integer> resultL = new ArrayList(currentList);
      result.add(resultL);
    }

    // as the BT may contain negative values we have to iterate it all
    findSum(originalSum, originalSum, result, new ArrayList(), node.right);
    findSum(originalSum, originalSum, result, new ArrayList(), node.left);
    int remaining = sum - nodeValue;
    findSum(originalSum, remaining, result, new ArrayList(currentList), node.right);
    findSum(originalSum, remaining, result, new ArrayList(currentList), node.left);
  }

  static void findSum(Integer sum) {
    count = 0;
    List<List<Integer>> result = new ArrayList<>();
    findSum(sum, sum, result, new ArrayList<>(), root);
    System.out.println(result);
  }
}

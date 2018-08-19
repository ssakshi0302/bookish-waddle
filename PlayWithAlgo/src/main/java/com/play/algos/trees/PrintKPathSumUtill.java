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
    root.setLeftNode(new BinaryTreeNode());
    root.leftNode.setData(3);
    root.leftNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.leftNode.setData(2);
    root.leftNode.setRightNode(new BinaryTreeNode());
    root.leftNode.rightNode.setData(1);
    root.leftNode.rightNode.setLeftNode(new BinaryTreeNode());
    root.leftNode.rightNode.leftNode.setData(1);

    root.setRightNode(new BinaryTreeNode());
    root.rightNode.setData(-1);
    root.rightNode.setLeftNode(new BinaryTreeNode());
    root.rightNode.leftNode.setData(4);
    root.rightNode.leftNode.setLeftNode(new BinaryTreeNode());
    root.rightNode.leftNode.leftNode.setData(1);
    root.rightNode.leftNode.setRightNode(new BinaryTreeNode());
    root.rightNode.leftNode.rightNode.setData(2);
    root.rightNode.setRightNode(new BinaryTreeNode());
    root.rightNode.rightNode.setData(5);
    root.rightNode.rightNode.setRightNode(new BinaryTreeNode());
    root.rightNode.rightNode.rightNode.setData(6);
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
    findSum(originalSum, originalSum, result, new ArrayList(), node.rightNode);
    findSum(originalSum, originalSum, result, new ArrayList(), node.leftNode);
    int remaining = sum - nodeValue;
    findSum(originalSum, remaining, result, new ArrayList(currentList), node.rightNode);
    findSum(originalSum, remaining, result, new ArrayList(currentList), node.leftNode);
  }

  static void findSum(Integer sum) {
    count = 0;
    List<List<Integer>> result = new ArrayList<>();
    findSum(sum, sum, result, new ArrayList<>(), root);
    System.out.println(result);
  }
}

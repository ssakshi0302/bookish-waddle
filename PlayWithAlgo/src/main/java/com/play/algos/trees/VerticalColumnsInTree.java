package com.play.algos.trees;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VerticalColumnsInTree {

  static BinaryTreeNode root;

  public static void main(String[] args) {
    createSampleTree();
    verticalColumnsBinaryTree();

  }

  private static List<List<Integer>> verticalColumnsBinaryTree() {
    Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    map= verticalColumnsBinaryTree(0, map, root);
    List<List<Integer>> result = new ArrayList<>();
    map.entrySet().forEach(entry-> result.add(entry.getValue()));
    return result;
  }

  private static Map<Integer, List<Integer>> verticalColumnsBinaryTree(final int hd, final Map<Integer, List<Integer>> map, final BinaryTreeNode node) {
  if(node == null){return map;}
    if(map.get(hd) == null){
    List<Integer> list = new ArrayList<>();
    list.add(node.data);
  }else {
    map.get(hd).add(node.data);
  }
  if(node.left !=null){
      verticalColumnsBinaryTree(hd-1, map, node.left);
  }
  if(node.right !=null){
    verticalColumnsBinaryTree(hd+1, map, node.right);
  }
    return map;
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

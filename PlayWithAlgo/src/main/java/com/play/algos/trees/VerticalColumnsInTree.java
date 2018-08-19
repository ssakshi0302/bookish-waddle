package com.play.algos.trees;

import java.util.ArrayList;
import java.util.HashMap;
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
  if(node.leftNode !=null){
      verticalColumnsBinaryTree(hd-1, map, node.leftNode);
  }
  if(node.rightNode !=null){
    verticalColumnsBinaryTree(hd+1, map, node.rightNode);
  }
    return map;
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

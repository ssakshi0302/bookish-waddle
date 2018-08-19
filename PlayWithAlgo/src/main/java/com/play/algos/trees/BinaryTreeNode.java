package com.play.algos.trees;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BinaryTreeNode {
  int data;
  BinaryTreeNode leftNode;
  BinaryTreeNode rightNode;

  BinaryTreeNode(int data) {
    this.data = data;
  }

  public BinaryTreeNode() {
  }
}
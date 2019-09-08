package com.play.algos.trees;
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//Diameter is nothing but max of  leftHt. rightHt +1,
//At each node we will be calculating diameter of tree and comparing it with max, and returning max of leftHt, rightHt + 1

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
public class DiameterEasySolution {
  /* Complete the function to get diameter of a binary tree */
  static int max = Integer.MIN_VALUE;

  static int diameter(BinaryTreeNode node) {
    max = Integer.MIN_VALUE;
    diameterUtil(node);
    return max;

  }

  static int diameterUtil(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }
    int ld = diameterUtil(node.getLeft());
    int rd = diameterUtil(node.getRight());
    int d = ld + rd + 1;
    if (max < d) {
      max = d;
    }
    return Math.max(ld, rd) + 1;
  }
}

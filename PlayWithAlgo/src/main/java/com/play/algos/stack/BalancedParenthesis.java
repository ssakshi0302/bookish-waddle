package com.play.algos.stack;

import java.util.Stack;

public class BalancedParenthesis {
  public static void main(String[] args) {
    String A = "(){}[]";
    System.out.println(isValid(A));
  }
  public static int isValid(String A) {
    Stack<Character> stack = new Stack<>();
    char[] arr = A.toCharArray();
    for(int i=0 ; i< arr.length ; i++){
      if(arr[i]=='{' || arr[i]=='(' || arr[i]=='[' ){
        System.out.println(arr[i]);
        stack.push(arr[i]);
      }
      else if (stack.isEmpty()){
        System.out.println ("Hello " +  i );
        return 0;}
      else{
        char c = stack.pop();
        System.out.println(" c " + c + "  "+ arr[i] );
        switch(arr[i]){

          case '}':
            if(c != '{'){return 0;}
            break;
          case ')':
            if(c != '('){return 0;}
            break;
          case ']':
            if(c != '['){return 0;}

        }
      }
    }
    return (stack.isEmpty())? 1 :0 ;
  }
}

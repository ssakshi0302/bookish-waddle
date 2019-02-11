package com.play.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HotelReviews {

  public static void main(String[] args) {
    String A = "cool_wifi_ice";
    ArrayList<String> B = new ArrayList<>();
    B.add("water_is_cool");
    B.add( "cold_ice_drink");
    B.add("cool_wifi_speed");
    solve(A, B);

  }

  public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
    Set<String> coolWords = new HashSet<>();
    String[] coolA= A.split("_");
    for(int i=0;i < coolA.length; i++){
      coolWords.add(coolA[i]);
      // System.out.println(coolA[0]);
    }
    ArrayList<Item> list = new ArrayList<>();
    for(int index =0; index<  B.size(); index ++){
      Item item = new Item();
      item.setIndex(index);
      list.add(item);
    }

    for(int i=0; i < B.size(); i++){
      String[] coolB= B.get(i).split("_");
      for(int j=0; j < coolB.length ; j++){
        String s = coolB[j];
        if(coolWords.contains(s)){
          int count = list.get(i).getCount() ;
          list.get(i).setCount(++count);
        }
      }
    }
    Collections.sort(list);
    ArrayList<Integer> result = new ArrayList<>();
    for(int i=0; i< list.size(); i++){
      result.add(list.get(i).getIndex());
    }

    return result;

  }
}

class Item implements Comparable<Item>{
  int index;
  int count;

  @Override
  public int compareTo(Item obj){
    return  obj.count - this.getCount();
  }

  public void setIndex(int index){this.index=index;}
  public int getIndex(){return index;}
  public void setCount(int count){this.count=count;}
  public int getCount(){return count;}
}

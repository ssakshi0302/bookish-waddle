package com.play.algos;

import java.util.ArrayList;

public class SetMatrixZero {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    createMatrix(a);
    setZeroes(a);

  }

  private static void createMatrix(final ArrayList<ArrayList<Integer>> a) {
    a.add(0, new ArrayList<>());
    a.add(1, new ArrayList<>());
    a.get(0).add(0, 0);
    a.get(0).add(1, 0);
    a.get(1).add(0, 1);
    a.get(1).add(1, 0);
  }

  public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
    int noOfRows = a.size();
    int noOfColumns = a.get(0).size();
    boolean firstRow = false;
    boolean firstColumn = false;
    firstColumn = setFirstColumnToZero(a, noOfRows, firstColumn);
    firstRow = setFirstRowToZero(a, noOfColumns, firstRow);
    markZeroesInFirstROWCOl(a, noOfRows, noOfColumns);
    markColumnsAsZero(a, noOfRows, noOfColumns);
    markRowAsZero(a, noOfRows, noOfColumns);
    markFirstColumnAsZero(a, noOfRows, firstColumn);
    markFirstRowAsZero(a, noOfColumns, firstRow);
    for (int i = 0; i < noOfRows; i++) {
      for (int j = 0; j < noOfColumns; j++) {
        System.out.println(
            a.get(i).get(j));
      }
    }

  }

  private static void markFirstRowAsZero(final ArrayList<ArrayList<Integer>> a, final int noOfColumns, final boolean firstRow) {
    if (firstRow) {
      for (int j = 0; j < noOfColumns; j++) {
        a.get(0).set(j, 0);
      }
    }
  }

  private static void markFirstColumnAsZero(final ArrayList<ArrayList<Integer>> a, final int noOfRows, final boolean firstColumn) {
    if (firstColumn) {
      for (int i = 0; i < noOfRows; i++) {
        a.get(i).set(0, 0);
      }
    }
  }

  private static void markRowAsZero(final ArrayList<ArrayList<Integer>> a, final int noOfRows, final int noOfColumns) {
    for (int j = 1; j < noOfColumns; j++) {
      if (a.get(0).get(j) == 0) {
        for (int i = 1; i < noOfRows; i++) {
          a.get(i).set(j, 0);
        }
      }
    }
  }

  private static void markColumnsAsZero(final ArrayList<ArrayList<Integer>> a, final int noOfRows, final int noOfColumns) {
    for (int i = 1; i < noOfRows; i++) {
      if (a.get(i).get(0) == 0) {
        for (int j = 1; j < noOfColumns; j++) {
          a.get(i).set(j, 0);
        }
      }
    }
  }

  private static void markZeroesInFirstROWCOl(final ArrayList<ArrayList<Integer>> a, final int noOfRows, final int noOfColumns) {
    for (int i = 1; i < noOfRows; i++) {
      for (int j = 1; j < noOfColumns; j++) {
        if (a.get(i).get(j) == 0) {
          a.get(0).set(j, 0);
          a.get(i).set(0, 0);
        }
      }
    }
  }

  private static boolean setFirstRowToZero(final ArrayList<ArrayList<Integer>> a, final int noOfColumns, boolean firstRow) {
    for (int i = 0; i < noOfColumns; i++) {
      if (a.get(0).get(i) == 0) {
        firstRow = true;
        break;
      }
    }
    return firstRow;
  }

  private static boolean setFirstColumnToZero(final ArrayList<ArrayList<Integer>> a, final int noOfRows, boolean firstColumn) {
    for (int i = 0; i < noOfRows; i++) {
      if (a.get(i).get(0) == 0) {
        firstColumn = true;
        break;
      }
    }
    return firstColumn;
  }
}

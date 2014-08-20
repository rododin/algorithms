/*
 * SortAlgorithms.java
 */

package org.rododin.algorithms.sort_algorithms;

import java.util.ArrayList;

import org.rododin.algorithms.sort_algorithms.algorithms.BubbleSort;
import org.rododin.algorithms.sort_algorithms.algorithms.BubbleSort2;
import org.rododin.algorithms.sort_algorithms.algorithms.MergeSort;
import org.rododin.algorithms.sort_algorithms.algorithms.QuickSort;
import org.rododin.algorithms.sort_algorithms.algorithms.SelectionSort;

/**
 * The main application class.
 *
 * @author Rod Odin
 */
public class SortAlgorithms
{
  public static final int DEF_DATA_SIZE = 50;
  public static final int DEF_MAX_VALUE = 50;


  public static void main(String[] args)
  {
    sortBy(new BubbleSort());
    sortBy(new BubbleSort2());
    sortBy(new SelectionSort());
    sortBy(new QuickSort());
    sortBy(new MergeSort(10, null));
    //sortBy(new InsertionSort());
    //sortBy(new ShellSort());
  }

  public static void sortBy(SortAlgorithm algorithm)
  {
    final int[] array = new int[DEF_DATA_SIZE];
    final ArrayList<Integer> list = new ArrayList<Integer>(DEF_DATA_SIZE);

    Utils.provideRandomData(array, DEF_MAX_VALUE);
    Utils.provideRandomData(list, DEF_DATA_SIZE, DEF_MAX_VALUE);

    System.out.println("== " + algorithm.getClass().getSimpleName() + " ==========");
    System.out.println("Initial: arrSize=" + array.length + ", array=" + Utils.toString(array));
    int itCount = algorithm.sort(array);
    System.out.println("Sorted : itCount=" + itCount + ", array=" + Utils.toString(array));

    System.out.println();

    //System.out.println("Initial: lstSize=" + list.size() + ", list=" + list);
    //itCount = algorithm.sort(list);
    //System.out.println("Sorted : itCount=" + itCount + ", list=" + list);
    //
    //System.out.println();
  }
}

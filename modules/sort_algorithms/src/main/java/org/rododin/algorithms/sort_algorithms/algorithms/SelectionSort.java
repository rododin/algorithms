/*
 * SelectionSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;
import org.rododin.algorithms.sort_algorithms.Utils;

/**
 * Implements the selection sort algorithm.
 *
 * @author Rod Odin
 */
public class SelectionSort
  implements SortAlgorithm
{
  public int sort(int[] array)
  {
    int itCounter = 0;
    final int n = array.length - 1;
    for (int i = 0; i < n; i++, itCounter++)
    {
      int min = i;
      for (int j = i + 1; j < array.length; j++, itCounter++)
      {
        if (array[j] < array[min])
          min = j;
      }
      Utils.swap(array, i, min);
    }
    return itCounter;
  }

  public <T extends Comparable<T>> int sort(List<T> list)
  {
    int itCounter = 0;
    final int m = list.size();
    final int n = m - 1;
    for (int i = 0; i < n; i++, itCounter++)
    {
      int min = i;
      for (int j = i + 1; j < m; j++, itCounter++)
      {
        if (list.get(j).compareTo(list.get(min)) < 0)
          min = j;
      }
      Utils.swap(list, i, min);
    }
    return itCounter;
  }
}

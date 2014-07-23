/*
 * BubbleSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.Collections;
import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;
import org.rododin.algorithms.sort_algorithms.Utils;

/**
 * Implements the bubble sort algorithm.
 *
 * @author Rod Odin
 */
public class BubbleSort
  implements SortAlgorithm
{
  public int sort(int[] array)
  {
    int itCounter = 0;

    for (int i = 0; i < array.length; i++)
    {
      final int J = array.length - i - 1;
      for(int j = 0; j < J; j++, itCounter++)
      {
        final int jj = j + 1;
        if (array[j] > array[jj])
          Utils.swap(array, j, jj);
      }
    }

    return itCounter;
  }

  public <T extends Comparable<T>> int sort(List<T> list)
  {
    int itCounter = 0;

    for (int i = 0; i < list.size(); i++)
    {
      final int J = list.size() - i - 1;
      for(int j = 0; j < J; j++, itCounter++)
      {
        final int jj = j + 1;
        if (list.get(j).compareTo(list.get(jj)) > 0)
          Collections.swap(list, j, jj);
      }
    }

    return itCounter;
  }
}

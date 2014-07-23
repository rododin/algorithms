/*
 * BubbleSort2.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.Collections;
import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;
import org.rododin.algorithms.sort_algorithms.Utils;

/**
 * Description.
 * @author Rod Odin
 */
public class BubbleSort2
  implements SortAlgorithm
{
  public int sort(int[] array)
  {
    int itCounter = 0;

    for (int i = 0; i < array.length; i++)
    {
      for(int j = array.length - 1; j > i; j--, itCounter++)
      {
        final int jj = j - 1;
        if (array[jj] > array[j])
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
      for(int j = list.size() - 1; j > i; j--, itCounter++)
      {
        final int jj = j - 1;
        if (list.get(jj).compareTo(list.get(j)) > 0)
          Collections.swap(list, j, jj);
      }
    }

    return itCounter;
  }
}

/*
 * QuickSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;
import org.rododin.algorithms.sort_algorithms.Utils;

/**
 * Description.
 * @author Rod Odin
 */
public class QuickSort
  implements SortAlgorithm
{
  public int sort(int[] array)
  {
    return doSort(array, 0, array.length-1, 0);
  }

  private int doSort(int[] array, int first, int last, int itCounter)
  {
    int i = first;
    int j = last;
    int x = array[(first + last) / 2];

    do
    {
      while (array[i] < x)
      {
        i++;
        itCounter++;
      }

      while (array[j] > x)
      {
        j--;
        itCounter++;
      }

      if (i <= j)
      {
        if (array[i] > array[j])
        {
          Utils.swap(array, i, j);
          //itCounter++;
        }
        i++;
        j--;
        //itCounter++;
      }
    } while (i <= j);

    if (i < last)
      itCounter = doSort(array, i, last, itCounter);

    if (first < j)
      itCounter = doSort(array, first, j, itCounter);

    return itCounter;
  }

  public <T extends Comparable<T>> int sort(List<T> list)
  {
    int itCounter = 0;

    // TODO: Implement...
    throw new UnsupportedOperationException("Still not implemented");

    //return itCounter;
  }
}

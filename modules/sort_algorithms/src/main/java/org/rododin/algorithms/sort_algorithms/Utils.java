/*
 * AbstractSortAlgorithm.java
 */

package org.rododin.algorithms.sort_algorithms;

import java.util.List;
import java.util.Random;

/**
 * Introduces some useful data manipulation operations like value swap, etc.
 *
 * @author Rod Odin
 */
public abstract class Utils
{
  /**
   * Swaps the element i with the element j in the given array.
   * @param array the array
   * @param i the index of the 1-st element
   * @param j the index of the 2-nd element
   */
  public static void swap(int[] array, int i, int j)
  {
    final int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  /**
   * Swaps the element i with the element j in the given list.
   * @param list the list
   * @param i the index of the 1-st element
   * @param j the index of the 2-nd element
   */
  public static <T> void swap(List<T> list, int i, int j)
  {
    final T tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }

  public static void provideRandomData(int[] array, int maxValue)
  {
    for (int i = 0; i < array.length; i++)
      array[i] = RANDOM.nextInt(maxValue);
  }

  public static void provideRandomData(List<Integer> list, int count, int maxValue)
  {
    list.clear();
    for (int i = 0; i < count; i++)
      list.add(RANDOM.nextInt(maxValue));
  }

  public static String toString(int[] array)
  {
    final StringBuilder sb = new StringBuilder("[");
    final int last = array.length - 1;
    if (array.length > 0)
    {
      for (int i = 0; ; i++)
      {
        sb.append(array[i]);
        if (i == last)
          break;
        sb.append(", ");
      }
    }
    return sb.append("]").toString();
  }

  private static final Random RANDOM = new Random();
}

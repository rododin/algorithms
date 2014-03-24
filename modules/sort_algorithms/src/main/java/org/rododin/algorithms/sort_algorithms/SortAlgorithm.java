/*
 * Algorithm.java
 */

package org.rododin.algorithms.sort_algorithms;

import java.util.List;

/**
 * Represents an abstract sorting algorithm.
 *
 * @author Rod Odin
 */
public interface SortAlgorithm
{
  /**
   * Sorts the given array in the ascending order.
   * @param array the array to be sorted
   * @return the number of iterations really done to get the data sorted
   */
  public int sort(int[] array);

  /**
   * Sorts the given list in the ascending order.
   * @param list the list to be sorted
   * @return the number of iterations really done to get the data sorted
   */
  public <T extends Comparable<T>> int sort(List<T> list);
}

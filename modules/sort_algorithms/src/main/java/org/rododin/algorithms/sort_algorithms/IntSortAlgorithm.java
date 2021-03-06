/*
 * Algorithm.java
 */

package org.rododin.algorithms.sort_algorithms;

import java.util.List;

/**
 * Represents an abstract sorting algorithm.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public interface IntSortAlgorithm
{
	/**
	 * Sorts the given array entirely in the ascending order.
	 * @param array the array to be sorted
	 * @return the number of iterations really done to get the data sorted
	 */
	default int sort(int[] array)
	{
		return sort (array, 0, array.length);
	}

	/**
	 * Sorts the given array in the ascending order starting from the <code>first</code> index till the
	 * <code>afterLast - 1</code> index inclusively.
	 * @param array the array to be sorted
	 * @param first the index of the first element to start sorting from
	 * @param afterLast the index after the last element to finish sorting till
	 * @return the number of iterations really done to get the data sorted
	 */
	int sort(int[] array, int first, int afterLast);

	/**
	 * Sorts the given list entirely in the ascending order.
	 * @param list the list to be sorted
	 * @return the number of iterations really done to get the data sorted
	 */
	default <T extends Comparable<T>> int sort(List<T> list)
	{
		return sort (list, 0, list.size());
	}

	/**
	 * Sorts the given list in the ascending order from the <code>first</code> index till the
	 * <code>afterLast - 1</code> index inclusively.
	 * @param list the list to be sorted
	 * @param first the index of the first element to start sorting from
	 * @param afterLast the index after the last element to finish sorting till
	 * @return the number of iterations really done to get the data sorted
	 */
	<T extends Comparable<T>> int sort(List<T> list, int first, int afterLast);
}

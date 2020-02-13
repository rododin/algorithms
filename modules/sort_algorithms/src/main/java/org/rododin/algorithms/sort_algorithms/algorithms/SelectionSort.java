/*
 * SelectionSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.List;

import org.rododin.algorithms.sort_algorithms.IntSortAlgorithm;
import org.rododin.algorithms.sort_algorithms.IntSortUtils;

/**
 * Implements the classical Selection Sort algorithm.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SelectionSort
	implements IntSortAlgorithm
{
	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast - 1;
		for (int i = first; i < last; i++)
		{
			int min = i;
			for (int j = i + 1; j < afterLast; j++, itCounter++)
			{
				if (array[j] < array[min])
					min = j;
			}
			IntSortUtils.swap(array, i, min);
		}
		return itCounter;
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast - 1;
		for (int i = first; i < last; i++)
		{
			int min = i;
			for (int j = i + 1; j < afterLast; j++, itCounter++)
			{
				if (list.get(j).compareTo(list.get(min)) < 0)
					min = j;
			}
			IntSortUtils.swap(list, i, min);
		}
		return itCounter;
	}
}

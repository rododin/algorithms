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
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SelectionSort
	implements SortAlgorithm
{
	public int sort(final int[] array)
	{
		return sort(array, 0, array.length);
	}

	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;
		final int n = afterLast - 1;
		for (int i = first; i < n; i++)
		{
			int min = i;
			for (int j = i + 1; j < afterLast; j++, itCounter++)
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
		return sort(list, 0, list.size());
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;
		final int n = afterLast - 1;
		for (int i = first; i < n; i++)
		{
			int min = i;
			for (int j = i + 1; j < afterLast; j++, itCounter++)
			{
				if (list.get(j).compareTo(list.get(min)) < 0)
					min = j;
			}
			Utils.swap(list, i, min);
		}
		return itCounter;
	}
}

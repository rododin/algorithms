/*
 * InsertionSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.Collections;
import java.util.List;

import org.rododin.algorithms.sort_algorithms.IntSortAlgorithm;
import org.rododin.algorithms.sort_algorithms.IntSortUtils;

/**
 * Implements the insertion sort algorithm.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class InsertionSort
	implements IntSortAlgorithm
{
	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast-1;

		for (int i = first+1; i <= last; i++)
		{
			for (int j = i; j > first; j--, itCounter++)
			{
				final int jj = j-1;
				if (array[jj] > array[j])
					IntSortUtils.swap(array, jj, j);
			}
		}

		return itCounter;
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast-1;

		for (int i = first+1; i <= last; i++)
		{
			for (int j = i; j > first; j--, itCounter++)
			{
				final int jj = j-1;
				if (list.get(jj).compareTo(list.get(j)) > 0)
					Collections.swap(list, j, jj);
			}
		}

		return itCounter;
	}
}

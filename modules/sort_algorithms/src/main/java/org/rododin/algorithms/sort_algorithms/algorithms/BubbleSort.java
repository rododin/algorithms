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
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BubbleSort
	implements SortAlgorithm
{
	public int sort(final int[] array)
	{
		return sort(array, 0, array.length);
	}

	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;

		for (int i = first; i < afterLast; i++)
		{
			final int J = afterLast - i - 1;
			for(int j = first; j < J; j++, itCounter++)
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
		return sort(list, 0, list.size());
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;

		for (int i = first; i < afterLast; i++)
		{
			final int J = afterLast - i - 1;
			for(int j = first; j < J; j++, itCounter++)
			{
				final int jj = j + 1;
				if (list.get(j).compareTo(list.get(jj)) > 0)
					Collections.swap(list, j, jj);
			}
		}

		return itCounter;
	}
}

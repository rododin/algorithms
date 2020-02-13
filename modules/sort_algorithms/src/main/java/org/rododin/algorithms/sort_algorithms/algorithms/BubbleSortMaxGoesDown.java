/*
 * BubbleSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.Collections;
import java.util.List;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.sort_algorithms.IntSortAlgorithm;
import org.rododin.algorithms.sort_algorithms.IntSortUtils;

/**
 * A variation of the Bubble Sort algorithm, where on each outer iteration the most heavy (maximal) element goes down
 * under all other still unsorted elements, i.e. it's a kind of reversed logic.
 *
 * @see BubbleSortMinGoesUp
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BubbleSortMaxGoesDown
	implements IntSortAlgorithm, Constants
{
	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast-1;

		for (int i = first; i < last; i++)
		{
			final int J = last - i;
			for(int j = first; j < J; j++, itCounter++)
			{
				final int jj = j + 1;
				if (array[j] > array[jj])
					IntSortUtils.swap(array, j, jj);
			}
		}

		return itCounter;
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast-1;

		for (int i = first; i < last; i++)
		{
			final int J = last - i;
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

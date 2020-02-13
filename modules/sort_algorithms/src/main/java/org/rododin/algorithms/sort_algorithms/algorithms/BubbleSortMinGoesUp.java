/*
 * BubbleSort2.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.Collections;
import java.util.List;

import org.rododin.algorithms.sort_algorithms.IntSortAlgorithm;
import org.rododin.algorithms.sort_algorithms.IntSortUtils;

/**
 * Implements the classical variant of the Bubble Sort algorithm, where after outer iteration the minimal element goes up
 * like a bubble. I.e. after the 1st outer iteration, the minimal element gets moved to the index 0 in the array/list,
 * after the 2nd iteration the next minimal element goes to the index 1, and so on.
 * <p/>
 * In other words, on each outer iteration we're moving the next most light-weight bubble (element) on the top of the all
 * other still unsorted elements.
 *
 * @see BubbleSortMaxGoesDown
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BubbleSortMinGoesUp
	implements IntSortAlgorithm
{
	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast - 1;
		for (int i = first; i < last; i++)
		{
			for(int j = last; j > i; j--, itCounter++)
			{
				final int jj = j - 1;
				if (array[jj] > array[j])
					IntSortUtils.swap(array, j, jj);
			}
		}

		return itCounter;
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;
		final int last = afterLast - 1;
		for (int i = first; i < last; i++)
		{
			for(int j = last; j > i; j--, itCounter++)
			{
				final int jj = j - 1;
				if (list.get(jj).compareTo(list.get(j)) > 0)
					Collections.swap(list, j, jj);
			}
		}

		return itCounter;
	}
}

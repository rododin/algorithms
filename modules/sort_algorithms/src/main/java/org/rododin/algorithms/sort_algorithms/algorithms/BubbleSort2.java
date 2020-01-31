/*
 * BubbleSort2.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.Collections;
import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;
import org.rododin.algorithms.sort_algorithms.Utils;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BubbleSort2
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
			for(int j = afterLast - 1; j > i; j--, itCounter++)
			{
				final int jj = j - 1;
				if (array[jj] > array[j])
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
			for(int j = afterLast - 1; j > i; j--, itCounter++)
			{
				final int jj = j - 1;
				if (list.get(jj).compareTo(list.get(j)) > 0)
					Collections.swap(list, j, jj);
			}
		}

		return itCounter;
	}
}

/*
 * MergeSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;
import org.rododin.algorithms.sort_algorithms.Utils;

/**
 * Description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MergeSort
	implements SortAlgorithm
{
	private final int nextAlgChunkSize;
	private final SortAlgorithm chunkSortAlg;

	public MergeSort(int nextAlgChunkSize, SortAlgorithm chunkSortAlg)
	{
		this.nextAlgChunkSize = nextAlgChunkSize;
		this.chunkSortAlg = chunkSortAlg;
	}

	public int sort(final int[] array)
	{
		return sort(array, 0, array.length);
	}

	public int sort(int[] array, int first, int afterLast)
	{
		return doMergeSort(array, first, afterLast - 1, 0);
	}

	private int doMergeSort(int[] array, int first, int last, int itCounter)
	{
		itCounter++; // Recursive routine starts

		if (first >= last)
			return itCounter;

		final int mid = (first + last) / 2;

		if (chunkSortAlg != null && mid - first + 1 <= nextAlgChunkSize)
			chunkSortAlg.sort(array, first, mid);
		else if (mid - first + 1 > 1)
			itCounter = doMergeSort(array, first, mid, itCounter);

		if (chunkSortAlg != null && last - mid <= nextAlgChunkSize)
			chunkSortAlg.sort(array, mid + 1, last);
		else if (last - mid > 1)
			itCounter = doMergeSort(array, mid + 1, last, itCounter);

		//System.out.println("DBG: Making merge: array=" + Utils.toString(array) + ", first=" + first + ", mid=" + mid + ", last=" + last + ", itCounter=" + itCounter);
		return doMakeMerge(array, first, mid, last, itCounter);
	}

	private int doMakeMerge(int[] array, int first, int mid, int last, int itCounter)
	{
		final int tmp[] = new int[last - first + 1];
		int i = first;
		int j = mid + 1;
		int k = 0;
		for ( ; i <= mid && j <= last; k++, itCounter++)
		{
			if (array[i] < array[j])
				tmp[k] = array[i++];
			else
				tmp[k] = array[j++];
		}
		for ( ; i <= mid; k++, i++, itCounter++)  // 0 or 1 iterations
			tmp[k] = array[i];
		for ( ; j <= last; k++, j++, itCounter++) // 0 or 1 iterations
			tmp[k] = array[j];

		for (i = first, j = 0; i <= last; i++, j++, itCounter++)
			array[i] = tmp[j];

		return itCounter;
	}

	public <T extends Comparable<T>> int sort(List<T> list)
	{
		return sort(list, 0, list.size());
	}

	public <T extends Comparable<T>> int sort(List<T> list, int first, int afterLast)
	{
		int itCounter = 0;

		// TODO: Implement...
		throw new UnsupportedOperationException("Still not implemented");

		//return itCounter;
	}
}

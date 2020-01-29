/*
 * ShellSort.java
 */

package org.rododin.algorithms.sort_algorithms.algorithms;

import java.util.List;

import org.rododin.algorithms.sort_algorithms.SortAlgorithm;

/**
 * Implements the Donald Shell's sort algorithm.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ShellSort
	implements SortAlgorithm
{
	public int sort(final int[] array)
	{
		return sort(array, 0, array.length);
	}

	public int sort(int[] array, int first, int afterLast)
	{
		int itCounter = 0;

		// TODO: Implement...
		throw new UnsupportedOperationException("Still not implemented");

		//return itCounter;
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

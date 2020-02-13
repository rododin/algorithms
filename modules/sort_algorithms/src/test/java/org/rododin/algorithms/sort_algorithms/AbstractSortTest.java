package org.rododin.algorithms.sort_algorithms;

import java.util.ArrayList;
import java.util.List;

import org.rododin.algorithms.Constants;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AbstractSortTest
	implements Constants
{
	protected static final int[] DEFAULT_RANDOM_ARRAY_SIZES =
		{
			0, 1, 2, 3, 5, 10, 50, 100, 1_000, 10_000, // 100_000, 1_000_000
		};

	protected void sortRandomArrays(IntSortAlgorithm algorithm, boolean verboseLog, int... randomArraySizes)
	{
		for (int arraySize : randomArraySizes)
		{
			if (verboseLog)
				Log.info(">> Running Sort Algorithm: algorithm=" + algorithm.getClass().getSimpleName() + ", arraySize=" + arraySize);

			final int[] array = new int[arraySize];
			IntSortUtils.generateRandomArray(array, arraySize);

			final int itCount = IntSortUtils.sortAndAssert(array, algorithm, verboseLog);

			Log.info(">> Sort completed: algorithm=" + algorithm.getClass().getSimpleName() + ", arraySize=" + arraySize + ", itCount=" + itCount + ", isSorted=" + (itCount >= 0));
		}
	}

	protected void sortRandomLists(IntSortAlgorithm algorithm, boolean verboseLog, int... randomListSizes)
	{
		for (int listSize : randomListSizes)
		{
			if (verboseLog)
				Log.info(">> Running Sort Algorithm: algorithm=" + algorithm.getClass().getSimpleName() + ", listSize=" + listSize);

			final List<Integer> list = new ArrayList<>(listSize);
			IntSortUtils.generateRandomList(list, listSize, listSize);

			final int itCount = IntSortUtils.sortAndAssert(list, algorithm, verboseLog);

			Log.info(">> Sort completed: algorithm=" + algorithm.getClass().getSimpleName() + ", listSize=" + listSize + ", itCount=" + itCount + ", isSorted=" + (itCount >= 0));
		}
	}
}

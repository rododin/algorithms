package org.rododin.algorithms.sort_algorithms;

import org.junit.Test;
import org.rododin.algorithms.sort_algorithms.algorithms.BubbleSortMaxGoesDown;
import org.rododin.algorithms.sort_algorithms.algorithms.BubbleSortMinGoesUp;
import org.rododin.algorithms.sort_algorithms.algorithms.InsertionSort;
import org.rododin.algorithms.sort_algorithms.algorithms.SelectionSort;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class IntSortTest
	extends AbstractSortTest
{
	@Test
	public void testBubbleSortMaxGoesDownForArrays()
	{
		sortRandomArrays(new BubbleSortMaxGoesDown(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testBubbleSortMaxGoesDownForLists()
	{
		sortRandomLists(new BubbleSortMaxGoesDown(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testBubbleSortMinGoesUpForArrays()
	{
		sortRandomArrays(new BubbleSortMinGoesUp(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testBubbleSortMinGoesUpForLists()
	{
		sortRandomLists(new BubbleSortMinGoesUp(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testSelectionSortForArrays()
	{
		sortRandomArrays(new SelectionSort(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testSelectionSortForLists()
	{
		sortRandomLists(new SelectionSort(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testInsertionSortForArrays()
	{
		sortRandomArrays(new InsertionSort(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}

	@Test
	public void testInsertionSortForLists()
	{
		sortRandomLists(new InsertionSort(), false, DEFAULT_RANDOM_ARRAY_SIZES);
	}
}

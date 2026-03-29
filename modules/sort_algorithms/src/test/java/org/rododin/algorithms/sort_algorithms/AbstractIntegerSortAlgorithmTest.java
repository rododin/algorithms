package org.rododin.algorithms.sort_algorithms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Adopts {@link AbstractSortAlgorithmTest} for the {@link Integer} elements.
 * @author Nikolay Chebotaryov
 */
public abstract class AbstractIntegerSortAlgorithmTest
	extends AbstractSortAlgorithmTest<Integer>
{
	@Override @Before
	public void setup()
	{
		// NOTE: We need a fully-functional mutable indexed (indexed access with O(1)) java.util.ArrayList to be created, not anything else.
		singletonList = new ArrayList<>(List.of(1));
		minorAscSortedList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		minorDescSortedList = new ArrayList<>(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
		minorUnsortedList = new ArrayList<>(List.of(9, 1, 7, 3, 5, 4, 6, 2, 8, 0));
	}

	@Override
	protected Integer randomElement()
	{
		return tlRandom.nextInt();
	}

	@Override
	protected Integer randomElement(Integer minIncl, Integer maxExcl)
	{
		return tlRandom.nextInt(minIncl, maxExcl);
	}

	/**
	 * A test for testing our useful {@link AbstractSortAlgorithmTest#containsAllPrecisiously(List, List, int, int)} method.
	 */
	@Test
	public void testContainsAllPrecisiously()
	{
		Assert.assertTrue(List.of(2, 2, 1).containsAll(List.of(1, 1, 2)));
		Assert.assertFalse(containsAllPrecisiously(List.of(2, 2, 1), List.of(1, 1, 2), 0, 3));
	}
}

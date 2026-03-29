package org.rododin.algorithms.sort_algorithms;

import org.junit.Before;
import org.junit.Test;

/**
 * Introduces a set of tests for the {@link SelectionSortAlgorithm}.
 * @author Nikolay Chebotaryov
 */
public class SelectionSortAlgorithmTest
	extends AbstractIntegerSortAlgorithmTest
{
	@Override
	@Before
	public void setup()
	{
		super.setup();

		defaultSortAlgorithm = new SelectionSortAlgorithm<>();
		estimate = true;
		visualize = true;
	}

	@Test
	public void testEmpty()
	{
		doTest(emptyList);
	}

	@Test
	public void testSingleton()
	{
		doTest(singletonList);
	}

	@Test
	public void testMinorAscSortedList()
	{
		doTest(minorAscSortedList);
	}

	@Test
	public void testMinorDescSortedList()
	{
		doTest(minorDescSortedList);
	}

	@Test
	public void testMinorUnsortedList()
	{
		doTest(minorUnsortedList);
	}

	@Test
	public void testMinorRandomList()
	{
		doTest(randomList(DEFAULT_MINOR_LIST_SIZE, 0, DEFAULT_MINOR_LIST_SIZE));
	}

	@Test
	public void testAverageRandomList()
	{
		doTest(randomList(DEFAULT_AVERAGE_LIST_SIZE, 0, DEFAULT_AVERAGE_LIST_SIZE));
	}

	@Test
	public void testMajorRandomList()
	{
		doTest(randomList(DEFAULT_MAJOR_LIST_SIZE, 0, DEFAULT_MAJOR_LIST_SIZE));
	}
}

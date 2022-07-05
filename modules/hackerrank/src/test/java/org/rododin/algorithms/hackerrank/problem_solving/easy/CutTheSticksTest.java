/*
 * CutTheSticksTest.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for {@link CutTheSticks}.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CutTheSticksTest
{
	@Test
	public void testEmptyArray()
	{
		Assert.assertEquals(
			Collections.emptyList(),
			CutTheSticks.cutTheSticks(Collections.emptyList())
		);
	}

	@Test
	public void testOneItemArray()
	{
		Assert.assertEquals(
			Collections.singletonList(1),
			CutTheSticks.cutTheSticks(Collections.singletonList(123))
		);
	}

	@Test
	public void testHackerRankExample01()
	{
		Assert.assertEquals(
			Arrays.asList(8, 6, 4, 1),
			CutTheSticks.cutTheSticks(Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1))
		);
	}

	@Test
	public void testHackerRankExample02()
	{
		Assert.assertEquals(
			Arrays.asList(6, 4, 2, 1),
			CutTheSticks.cutTheSticks(Arrays.asList(5, 4, 4, 2, 2, 8))
		);
	}

	@Test
	public void testHackerRankExample03()
	{
		Assert.assertEquals(
			Arrays.asList(28, 27, 26, 25, 24, 23, 22, 20, 19, 16, 15, 14, 13, 11, 10, 7, 6, 5, 4, 3, 2, 1),
			CutTheSticks.cutTheSticks(Arrays.asList(66, 42, 68, 72, 68, 81, 91, 19, 40, 73, 44, 73, 89, 73, 44, 12, 77, 40, 44, 17, 59, 99, 35, 92, 80, 51, 14, 30))
		);
	}

	@Test
	public void testGeneratedArray1K()
	{
		doTestLargeGeneratedArray(1_000);
	}

	@Test
	public void testGeneratedArray1M()
	{
		doTestLargeGeneratedArray(1_000_000);
	}

	private void doTestLargeGeneratedArray(int n)
	{
		// Generating the worst case first:
		//  - each element is different
		//  - the test array is randomly shuffled
		//  - on the other hand, it's easy to generate the expected result

		final List<Integer> testArray = new ArrayList<>(n);
		final List<Integer> resultArray = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
		{
			testArray.add(i + 1);
			resultArray.add(n - i);
		}
		Collections.shuffle(testArray);
		Assert.assertEquals(resultArray, CutTheSticks.cutTheSticks(testArray));
	}
}

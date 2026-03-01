package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link SearchInRotatedSortedArray}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SearchInRotatedSortedArrayTest
{
	@Test
	public void test0()
	{
		doTest(-1, 0);
	}

	@Test
	public void test1No()
	{
		doTest(-1, 0, 1);
	}

	@Test
	public void test1Yes()
	{
		doTest(0, 1, 1);
	}

	@Test
	public void testMinor1()
	{
		doTest(4, 0, 4,5,6,7,0,1,2);
	}

	@Test
	public void testMinor2()
	{
		doTest(1, 1, 5,1,3);
	}

	@Test
	public void testMinor3()
	{
		doTest(0, 5, 5,1,3);
	}

	private static void doTest(int expected, int target, int... array)
	{
		Assert.assertEquals(expected, new SearchInRotatedSortedArray().search(array, target));
	}
}

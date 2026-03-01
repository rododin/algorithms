package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link SearchInRotatedSortedArray2}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SearchInRotatedSortedArray2Test
{
	@Test
	public void test0()
	{
		doTest(false, 0);
	}

	@Test
	public void test1No()
	{
		doTest(false, 0, 1);
	}

	@Test
	public void test1Yes()
	{
		doTest(true, 1, 1);
	}

	@Test
	public void testMinor1()
	{
		doTest(true, 0, 4,5,6,7,0,1,2);
	}

	@Test
	public void testMinor2()
	{
		doTest(true, 1, 5,1,3);
	}

	@Test
	public void testMinor3()
	{
		doTest(true, 5, 5,1,3);
	}

	@Test
	public void testMinor4()
	{
		doTest(true, 0, 2,5,6,0,0,1,2);
	}

	@Test
	public void testMinor5()
	{
		doTest(false, 3, 2,5,6,0,0,1,2);
	}

	@Test
	public void testMinor6()
	{
		doTest(false, 3, 7,1,2,7,7,7,7,7);
	}

	@Test
	public void testMinor7()
	{
		doTest(true, 7, 7,1,2,7,7,7,7,7);
	}

	@Test
	public void testMinor8()
	{
		doTest(true, 2, 7,1,2,7,7,7,7,7);
	}

	@Test
	public void testMinor9()
	{
		doTest(true, 2, 2,2,2,2,2,2,2,2);
	}

	@Test
	public void testMinor10()
	{
		doTest(false, 1, 2,2,2,2,2,2,2,2);
	}

	@Test
	public void testMinor11()
	{
		doTest(true, 9, 1,1,1,1,1,1,9,1);
	}

	private static void doTest(boolean expected, int target, int... array)
	{
		Assert.assertEquals(expected, new SearchInRotatedSortedArray2().search(array, target));
	}
}

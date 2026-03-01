package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link Search2DMatrixTest}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Search2DMatrixTest
{
	@Test
	public void test0()
	{
		doTest(new int[][]{}, 0, false);
	}

	@Test
	public void test1True()
	{
		doTest(new int[][]{ { 1 } }, 1, true);
	}

	@Test
	public void test1False()
	{
		doTest(new int[][]{ { 1 } }, 0, false);
	}

	@Test
	public void testMinorTrue()
	{
		doTest(new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }, 8, true);
	}

	@Test
	public void testMinorFalse()
	{
		doTest(new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 9, 10} }, 8, false);
	}

	private static void doTest(int[][] matrix, int target, boolean expected)
	{
		Assert.assertEquals(expected, new Search2DMatrix().searchMatrix(matrix, target));
	}
}

package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link BinarySearch}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BinarySearchTest
{
	@Test
	public void test0()
	{
		Assert.assertEquals(-1, BinarySearch.search(new int[]{}, 0));
	}

	@Test
	public void test1()
	{
		Assert.assertEquals(-1, BinarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
	}

	@Test
	public void test2()
	{
		Assert.assertEquals(4, BinarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
	}

	@Test
	public void test3()
	{
		Assert.assertEquals(19, BinarySearch.search(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE / 2, Integer.MIN_VALUE / 4, -1000, -123, -12, -3, 0, 1, 2, 3, 4, 5, 8, 9, 11, 17, 19, 22, 31, 127, 256, 1024, 1024 * 1024, Integer.MAX_VALUE / 8, Integer.MAX_VALUE / 3, Integer.MAX_VALUE}, 31));
	}

	@Test
	public void testSearchInsertionPosition0()
	{
		Assert.assertEquals(0, BinarySearch.searchInsertionPosition(new int[]{}, 0));
	}

	@Test
	public void testSearchInsertionPosition52()
	{
		Assert.assertEquals(2, BinarySearch.searchInsertionPosition(new int[]{1, 1, 1, 1, 1}, 1));
	}

	@Test
	public void testSearchInsertionPosition10()
	{
		Assert.assertEquals(0, BinarySearch.searchInsertionPosition(new int[]{1}, 0));
	}

	@Test
	public void testSearchInsertionPosition11()
	{
		Assert.assertEquals(0, BinarySearch.searchInsertionPosition(new int[]{1}, 1));
	}

	@Test
	public void testSearchInsertionPosition12()
	{
		Assert.assertEquals(1, BinarySearch.searchInsertionPosition(new int[]{1}, 2));
	}

	@Test
	public void testSearchInsertionPosition80()
	{
		Assert.assertEquals(0, BinarySearch.searchInsertionPosition(new int[]{-1, 0, 3, 5, 9, 12, 17, 19}, -3));
	}

	@Test
	public void testSearchInsertionPosition85()
	{
		Assert.assertEquals(5, BinarySearch.searchInsertionPosition(new int[]{-1, 0, 3, 5, 9, 12, 17, 19}, 10));
	}

	@Test
	public void testSearchInsertionPosition88()
	{
		Assert.assertEquals(8, BinarySearch.searchInsertionPosition(new int[]{-1, 0, 3, 5, 9, 12, 17, 19}, 20));
	}

	@Test
	public void testRecursive0()
	{
		Assert.assertEquals(-1, BinarySearch.search(new int[]{}, 0));
	}

	@Test
	public void testRecursive1()
	{
		Assert.assertEquals(-1, BinarySearch.searchRecursive(new int[]{-1, 0, 3, 5, 9, 12}, 2));
	}

	@Test
	public void testRecursive2()
	{
		Assert.assertEquals(4, BinarySearch.searchRecursive(new int[]{-1, 0, 3, 5, 9, 12}, 9));
	}

	@Test
	public void testRecursive3()
	{
		Assert.assertEquals(19, BinarySearch.search(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE / 2, Integer.MIN_VALUE / 4, -1000, -123, -12, -3, 0, 1, 2, 3, 4, 5, 8, 9, 11, 17, 19, 22, 31, 127, 256, 1024, 1024 * 1024, Integer.MAX_VALUE / 8, Integer.MAX_VALUE / 3, Integer.MAX_VALUE}, 31));
	}
}

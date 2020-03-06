/*
 * AppleAndOrangeTest.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link AppleAndOrange}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AppleAndOrangeTest
{
	@Test
	public void test01()
	{
		Assert.assertArrayEquals(new int[] {1, 2}, AppleAndOrange.printCountApplesAndOranges(7, 10, 4, 12, new int[] {2, 3, -4}, new int[] {3, -2, -4}));
		System.out.println();
	}

	@Test
	public void test02()
	{
		Assert.assertArrayEquals(new int[] {1, 1}, AppleAndOrange.printCountApplesAndOranges(7, 11, 5, 15, new int[] {-2, 2, 1}, new int[] {5, -6}));
		System.out.println();
	}

	@Test
	public void test03()
	{
		Assert.assertArrayEquals(new int[] {0, 0}, AppleAndOrange.printCountApplesAndOranges(2, 3, 1, 5, new int[] {-2}, new int[] {-1}));
		System.out.println();
	}

	@Test
	public void test04()
	{
		Assert.assertArrayEquals(new int[] {3, 2}, AppleAndOrange.printCountApplesAndOranges(5, 10, 0, 15
		                                         , new int[] {1, 2, 3, 5, 8, 10, 20, 25}
		                                         , new int[] {3, 4, 5, -2, -7, -9, -11, -15}));
		System.out.println();
	}
}

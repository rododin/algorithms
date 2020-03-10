package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link CircularArrayRotation}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CircularArrayRotationTest
{
	@Test
	public void test00()
	{
		Assert.assertArrayEquals(new int[] {}, CircularArrayRotation.circularArrayRotation(new int[] {}, 5, new int[] {}));
	}

	@Test
	public void test01()
	{
		Assert.assertArrayEquals(new int[] {5, 3}, CircularArrayRotation.circularArrayRotation(new int[] {3, 4, 5}, 2, new int[] {1, 2}));
	}

	@Test
	public void test02()
	{
		Assert.assertArrayEquals(new int[] {2, 3, 1}, CircularArrayRotation.circularArrayRotation(new int[] {1, 2, 3}, 2, new int[] {0, 1, 2}));
	}

	@Test
	public void test03()
	{
		Assert.assertArrayEquals(new int[] {1, 5, 10}, CircularArrayRotation.circularArrayRotation(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 20, new int[] {0, 4, 9}));
	}

	@Test
	public void test04()
	{
		Assert.assertArrayEquals(new int[] {2, 6, 1}, CircularArrayRotation.circularArrayRotation(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 19, new int[] {0, 4, 9}));
	}

	@Test
	public void test05()
	{
		Assert.assertArrayEquals(new int[] {10, 4, 9}, CircularArrayRotation.circularArrayRotation(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 31, new int[] {0, 4, 9}));
	}
}

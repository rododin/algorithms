package org.rododin.algorithms.leetcode.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link FourSum}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FourSumTest
{
	@Test
	public void test00()
	{
		doTest(Set.of(), 0);
	}

	@Test
	public void test01()
	{
		doTest(Set.of(), 1);
	}

	@Test
	public void test02()
	{
		doTest(Set.of(), 2, 1, 2);
	}

	@Test
	public void test10()
	{
		doTest(Set.of(List.of(-2, -1, 1, 2)), 0, -2, -1, 1, 2);
	}

	@Test
	public void test11()
	{
		doTest(Set.of(List.of(-2, -1, 1, 2)), 0, -2, -1, 1, 2, 3, 4);
	}

	@Test
	public void test50()
	{
		doTest( Set.of( List.of(-3, -2, 2, 3)
		              , List.of(-3, -1, 1, 3)
		              , List.of(-3,  0, 1, 2)
		              , List.of(-2, -1, 1, 2)
		              , List.of(-2, -1, 0, 3)
		              )
		      , 0
		      , -3, -2, -1, 0, 1, 2, 3
		      );
	}

	@Test
	public void testMinMax01()
	{
		doTest( Set.of()
		      , -294967296
		      , 1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000
		      );
	}

	@Test
	public void testMinMax02()
	{
		doTest( Set.of()
		      , 294967296
		      , -1_000_000_000, -1_000_000_000, 1_000_000_000, -1_000_000_000, -1_000_000_000
		      );
	}

	private static void doTest(Set<List<Integer>> expected, int target, int... array)
	{
		final List<List<Integer>> result = new FourSum().fourSum(array, target);
		Assert.assertEquals(expected.size(), result.size());
		Assert.assertTrue(expected.containsAll(result));
	}

	@Test
	public void trySomething()
	{
		int[] arr = new int[] { -1_000_000_000, -1_000_000_000, -1_000_000_000, -1_000_000_000 };
		System.out.println("trySomething: " + (arr[0] + arr[1] + arr[2] + arr[3]));
		System.out.println("expected    : " + 294967296);
	}
}

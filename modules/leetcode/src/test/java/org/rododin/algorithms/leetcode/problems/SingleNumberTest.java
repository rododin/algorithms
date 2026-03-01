package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link SingleNumber}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SingleNumberTest
{
	@Test
	public void test0()
	{
		doTest(0);
	}

	@Test
	public void test1()
	{
		doTest(1, 1);
	}

	@Test
	public void test2()
	{
		doTest(2, 1,1,2);
	}

	@Test
	public void test3()
	{
		doTest(41, 1,1,7,7,8,8,9,9,19,31,31,19,17,2,17,2,41,63,Integer.MAX_VALUE,Integer.MIN_VALUE,63,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private static void doTest(int expected, int... array)
	{
		Assert.assertEquals(expected, new SingleNumber().singleNumber(array));
	}
}

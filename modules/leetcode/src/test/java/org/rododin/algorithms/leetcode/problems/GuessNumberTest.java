package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link GuessNumber}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class GuessNumberTest
{
	@Test
	public void test0()
	{
		Assert.assertEquals(0, pickNumber(0).guessNumber(0));
	}

	@Test
	public void test1()
	{
		Assert.assertEquals(0, pickNumber(0).guessNumber(1));
	}

	@Test
	public void test11()
	{
		Assert.assertEquals(1, pickNumber(1).guessNumber(1));
	}

	@Test
	public void testMinor()
	{
		Assert.assertEquals(19, pickNumber(19).guessNumber(31));
	}

	@Test
	public void testMajor()
	{
		Assert.assertEquals(31, pickNumber(31).guessNumber(Integer.MAX_VALUE));
	}

	private static GuessNumber pickNumber(int pickedNumber)
	{
		final GuessNumber guessNumber = new GuessNumber();
		guessNumber.setPickedNumber(pickedNumber);
		return guessNumber;
	}
}

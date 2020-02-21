/*
 * RepeatedStringTest.java
 */

package org.rododin.algorithms.hackerrank.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link RepeatedString}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class RepeatedStringTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals(4L, RepeatedString.printRepeatedString("abcac", 10L));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(7L, RepeatedString.printRepeatedString("aba", 10L));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(1_000_000_000_000L, RepeatedString.printRepeatedString("a", 1_000_000_000_000L));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(0L, RepeatedString.printRepeatedString("bcd", 100L));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(0L, RepeatedString.printRepeatedString("", 100L));
	}
}

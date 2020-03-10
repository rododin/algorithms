package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link FindDigits}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FindDigitsTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals(0, FindDigits.findDigits(0));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals(3, FindDigits.findDigits(111));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(2, FindDigits.findDigits(12));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(3, FindDigits.findDigits(1012));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(3, FindDigits.findDigits(123456789));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(3, FindDigits.findDigits(114108089));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(6, FindDigits.findDigits(110110015));
	}

	@Test
	public void test07()
	{
		Assert.assertEquals(5, FindDigits.findDigits(106108048));
	}
}

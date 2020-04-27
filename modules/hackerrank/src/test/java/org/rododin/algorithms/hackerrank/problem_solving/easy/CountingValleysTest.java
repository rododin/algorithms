package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for {@link CountingValleys}.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CountingValleysTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals(1, CountingValleys.printCountingValleys(8, "DDUUUUDD"));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals(1, CountingValleys.printCountingValleys(8, "UDDDUDUU"));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(1, CountingValleys.printCountingValleys(5, "DUUDU"));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(0, CountingValleys.printCountingValleys(10, "UDUDUDUDUD"));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(5, CountingValleys.printCountingValleys(10, "DUDUDUDUDU"));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(2, CountingValleys.printCountingValleys(12, "DDUUDDUDUUUD"));
	}
}

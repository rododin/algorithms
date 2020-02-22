/*
 * ExtraLongFactorialsTest.java
 */

package org.rododin.algorithms.hackerrank.medium;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link ExtraLongFactorials}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ExtraLongFactorialsTest
{
	@Test
	public void test1()
	{
		Assert.assertEquals(new BigInteger("1"), ExtraLongFactorials.printExtraLongFactorials(1));
	}

	@Test
	public void test2()
	{
		Assert.assertEquals(new BigInteger("2"), ExtraLongFactorials.printExtraLongFactorials(2));
	}

	@Test
	public void test3()
	{
		Assert.assertEquals(new BigInteger("6"), ExtraLongFactorials.printExtraLongFactorials(3));
	}

	@Test
	public void test4()
	{
		Assert.assertEquals(new BigInteger("24"), ExtraLongFactorials.printExtraLongFactorials(4));
	}

	@Test
	public void test5()
	{
		Assert.assertEquals(new BigInteger("120"), ExtraLongFactorials.printExtraLongFactorials(5));
	}

	@Test
	public void test10()
	{
		Assert.assertEquals(new BigInteger("3628800"), ExtraLongFactorials.printExtraLongFactorials(10));
	}

	@Test
	public void test50()
	{
		Assert.assertEquals(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), ExtraLongFactorials.printExtraLongFactorials(50));
	}

	@Test
	public void test100()
	{
		Assert.assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"), ExtraLongFactorials.printExtraLongFactorials(100));
	}
}

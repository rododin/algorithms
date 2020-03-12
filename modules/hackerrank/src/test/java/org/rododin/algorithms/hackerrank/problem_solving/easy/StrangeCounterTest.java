package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link StrangeCounter}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StrangeCounterTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals(3, StrangeCounter.strangeCounter(1));
		Assert.assertEquals(2, StrangeCounter.strangeCounter(2));
		Assert.assertEquals(1, StrangeCounter.strangeCounter(3));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals(6, StrangeCounter.strangeCounter(4));
		Assert.assertEquals(5, StrangeCounter.strangeCounter(5));
		Assert.assertEquals(4, StrangeCounter.strangeCounter(6));
		Assert.assertEquals(3, StrangeCounter.strangeCounter(7));
		Assert.assertEquals(2, StrangeCounter.strangeCounter(8));
		Assert.assertEquals(1, StrangeCounter.strangeCounter(9));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(12, StrangeCounter.strangeCounter(10));
		Assert.assertEquals(11, StrangeCounter.strangeCounter(11));
		Assert.assertEquals(10, StrangeCounter.strangeCounter(12));
		Assert.assertEquals( 7, StrangeCounter.strangeCounter(15));
		Assert.assertEquals( 5, StrangeCounter.strangeCounter(17));
		Assert.assertEquals( 3, StrangeCounter.strangeCounter(19));
		Assert.assertEquals( 1, StrangeCounter.strangeCounter(21));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(24, StrangeCounter.strangeCounter(22));
		Assert.assertEquals(15, StrangeCounter.strangeCounter(31));
		Assert.assertEquals( 8, StrangeCounter.strangeCounter(38));
		Assert.assertEquals( 1, StrangeCounter.strangeCounter(45));
		Assert.assertEquals(48, StrangeCounter.strangeCounter(46));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(         534L, StrangeCounter.strangeCounter(         1000L));
		Assert.assertEquals(       16716L, StrangeCounter.strangeCounter(        32434L));
		Assert.assertEquals(649267441662L, StrangeCounter.strangeCounter(1000000000000L));
		Assert.assertEquals(649267443994L, StrangeCounter.strangeCounter( 999999997668L));
		Assert.assertEquals(  3079217434L, StrangeCounter.strangeCounter(  99999997668L));
	}
}

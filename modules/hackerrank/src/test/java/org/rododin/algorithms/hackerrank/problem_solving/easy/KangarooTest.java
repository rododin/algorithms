package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link Kangaroo}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class KangarooTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals("YES", Kangaroo.kangaroo(1, 1, 1, 1));
		Assert.assertEquals("NO" , Kangaroo.kangaroo(1, 1, 2, 1));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals("YES", Kangaroo.kangaroo(2, 1, 1, 2));
		Assert.assertEquals("YES", Kangaroo.kangaroo(0, 3, 4, 2));
		Assert.assertEquals("NO" , Kangaroo.kangaroo(0, 2, 5, 3));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("NO" , Kangaroo.kangaroo(1, 20,  2, 10));
		Assert.assertEquals("NO" , Kangaroo.kangaroo(9,  9, 20,  7));
		Assert.assertEquals("YES", Kangaroo.kangaroo(0,  9, 20,  7));
	}
}

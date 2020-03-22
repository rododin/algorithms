package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JumpingOnTheClouds}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JumpingOnTheCloudsTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals(96, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 0, 1, 0}, 2));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(92, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 1, 0}, 2));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(80, JumpingOnTheClouds.jumpingOnClouds(new int[] {1, 1, 1, 0, 1, 1, 0, 0, 0, 0}, 3));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(86, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0}, 3));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(97, JumpingOnTheClouds.jumpingOnClouds(new int[] {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, 19));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(79, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0}, 1));
	}

	@Test
	public void test07()
	{
		Assert.assertEquals(96, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 1}, 1));
	}

	@Test
	public void test08()
	{
		Assert.assertEquals(91, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0}, 4));
	}
}

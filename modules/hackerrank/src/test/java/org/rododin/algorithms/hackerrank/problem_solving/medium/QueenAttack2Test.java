package org.rododin.algorithms.hackerrank.problem_solving.medium;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link QueenAttack2}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class QueenAttack2Test
{
	@Test
	public void testIE00()
	{
		Assert.assertEquals(0, QueenAttack2.queensAttackIneffective(1, 0, 1, 1, new int[0][0]));
	}

	@Test
	public void testIE01()
	{
		Assert.assertEquals(27, QueenAttack2.queensAttackIneffective(8, 0, 4, 4, new int[0][0]));
	}

	@Test
	public void testIE02()
	{
		Assert.assertEquals(24, QueenAttack2.queensAttackIneffective(8, 1, 4, 4, new int[][] {{3, 5}}));
	}

	@Test
	public void testIE03()
	{
		Assert.assertEquals(9, QueenAttack2.queensAttackIneffective(4, 0, 4, 4, new int[0][0]));
	}

	@Test
	public void testIE04()
	{
		Assert.assertEquals(10, QueenAttack2.queensAttackIneffective(5, 3, 4, 3, new int[][] {{5, 5}, {4, 2}, {2, 3}}));
	}

	@Test
	public void testIE05()
	{
		Assert.assertEquals(27, QueenAttack2.queensAttackIneffective(8, 0, 5, 4, new int[0][0]));
	}

	@Test @Ignore // This test runs long time and causes an OutOfMemoryError because of the ineffective solution
	public void testIE06()
	{
		try
		{
			Assert.assertEquals(308369, QueenAttack2.queensAttackIneffective(100000, 0, 4187, 5068, new int[0][0]));
		}
		catch (OutOfMemoryError e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void test00()
	{
		Assert.assertEquals(0, QueenAttack2.queensAttack(1, 0, 1, 1, new int[0][0]));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals(27, QueenAttack2.queensAttack(8, 0, 4, 4, new int[0][0]));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(24, QueenAttack2.queensAttack(8, 1, 4, 4, new int[][] {{3, 5}}));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(9, QueenAttack2.queensAttack(4, 0, 4, 4, new int[0][0]));
	}

	@Test
	public void test04()
	{
		//Assert.assertEquals(10, QueenAttack2.queensAttackIneffective(5, 3, 4, 3, new int[][] {{5, 5}, {4, 2}, {2, 3}}));
		Assert.assertEquals(10, QueenAttack2.queensAttack           (5, 3, 4, 3, new int[][] {{5, 5}, {4, 2}, {2, 3}}));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(27, QueenAttack2.queensAttack(8, 0, 5, 4, new int[0][0]));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(308369, QueenAttack2.queensAttack(100000, 0, 4187, 5068, new int[0][0]));
	}
}

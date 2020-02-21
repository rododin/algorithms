/*
 * MagicSquareFormingTest.java
 */

package org.rododin.algorithms.hackerrank.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MagicSquareFormingTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals(7, MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{5, 3, 4},
			{1, 5, 8},
			{6, 4, 2},
		}));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(1, MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{4, 9, 2},
			{3, 5, 7},
			{8, 1, 5},
		}));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(4, MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{4, 8, 2},
			{4, 5, 7},
			{6, 1, 6},
		}));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(21, MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{1, 8, 9},
			{2, 5, 7},
			{3, 4, 9},
		}));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(21, MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{2, 9, 8},
			{4, 2, 7},
			{5, 6, 7},
		}));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(18, MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{6, 1, 2},
			{7, 2, 6},
			{5, 6, 2},
		}));
	}
}

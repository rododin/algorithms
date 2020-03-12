package org.rododin.algorithms.hackerrank.problem_solving.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link SurfaceArea3D}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SurfaceArea3DTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals(0, SurfaceArea3D.surfaceArea(new int[0][0]));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals(6, SurfaceArea3D.surfaceArea(new int[][] {{1}}));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(16, SurfaceArea3D.surfaceArea(new int[][] {{2, 2}}));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(24, SurfaceArea3D.surfaceArea(new int[][] {{2, 2}, {2, 2}}));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(54, SurfaceArea3D.surfaceArea(new int[][] {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}}));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(96, SurfaceArea3D.surfaceArea(new int[][] {{4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}}));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(60, SurfaceArea3D.surfaceArea(new int[][] {{1, 3, 4}, {2, 2, 3}, {1, 2, 4}}));
	}

	@Test
	public void test07()
	{
		Assert.assertEquals(1482, SurfaceArea3D.surfaceArea(new int[][]
			{
				{ 51 },
				{ 32 },
				{ 28 },
				{ 49 },
				{ 28 },
				{ 21 },
				{ 98 },
				{ 56 },
				{ 99 },
				{ 77 },
			}));
	}

	@Test
	public void test08()
	{
		Assert.assertEquals(1276, SurfaceArea3D.surfaceArea(new int[][]
			{
				{91, 80, 7, 41, 36, 11, 48, 57, 40, 43}
			}));
	}

	@Test
	public void test09()
	{
		Assert.assertEquals(150, SurfaceArea3D.surfaceArea(new int[][]
			{
				{1, 2, 3, 4, 5},
				{2, 2, 3, 4, 5},
				{3, 3, 3, 4, 5},
				{4, 4, 4, 4, 5},
				{5, 5, 5, 5, 5},
			}));
	}

	@Test
	public void test10()
	{
		Assert.assertEquals(262, SurfaceArea3D.surfaceArea(new int[][]
			{
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 2, 2, 2, 2, 2, 2, 2, 1},
				{1, 2, 3, 3, 3, 3, 3, 2, 1},
				{1, 2, 3, 4, 4, 4, 3, 2, 1},
				{1, 2, 3, 4, 5, 4, 3, 2, 1},
				{1, 2, 3, 4, 4, 4, 3, 2, 1},
				{1, 2, 3, 3, 3, 3, 3, 2, 1},
				{1, 2, 2, 2, 2, 2, 2, 2, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
			}));
	}
}

package org.rododin.algorithms.leetcode.problems;

import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link NumberOfIslands}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class NumberOfIslandsTest
{
	@Test
	public void test1()
	{
		char[][] src = new char[][]
			{
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
			};

		final int num = new NumberOfIslands().numIslands(src);
		System.out.println(num);
	}

	@Test
	public void test2()
	{
		char[][] src = new char[][]
			{
				{'1','1','1'},
				{'0','1','0'},
				{'1','1','1'}
			};

		final int num = new NumberOfIslands().numIslands(src);
		System.out.println(num);
	}
}

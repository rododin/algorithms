package org.rododin.algorithms.leetcode.problems;

/**
 * TODO: Add description.
 */
public class NumberOfIslands
{
	public int numIslands(char[][] grid)
	{
		char minX = 'A';
		char x = minX;
		for (int i = 0; i < grid.length; i++)
		{
			char[] line = grid[i];
			for (int j = 0; j < line.length; j++)
			{
				x = checkAround(grid, i, j, x);
			}
		}
		return x - minX;
	}

	private char checkAround(char[][] grid, int i, int j, char x)
	{
		if (grid[i][j] == '1')
		{
			char cLeft  = j-1 >= 0 ? grid[i][j-1] : 0;
			char cTop   = i-1 >= 0 ? grid[i-1][j] : 0;
			//int cRight  = j+1 < grid[i].length ? grid[i][j+1] : -1;
			//int cBottom = i+1 < grid.length ? grid[i+1][j] : -1;

			if (cLeft > '1')
				grid[i][j] = cLeft;
			else if (cTop > '1')
				grid[i][j] = cTop;
			else
				grid[i][j] = x++;
		}
		return x;
	}
}

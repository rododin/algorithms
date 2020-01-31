package org.rododin.algorithms.connectivity_problem.office;

import java.util.HashMap;
import java.util.Map;

/**
 * It's coming from a <a href="https://developers.turing.com/dashboard/algorithm_challenge">Turing's Algorithm Challenge</a>
 * task.
 * </p>
 * I cannot copy-paste the task definition, so let me try to reproduce it from my memory.
 * </p>
 * There is an office space area (in a building) consisting of space cells and walls between the cells.
 * It's represented with a matrix (2-dimension array) of <code>MxN</code> elements,
 * where <code>0</code>s define walls, and <code>1</code>s define
 * the space cells. Each office may consist of many cells if there are no walls between them.
 * E.g.
 * </p>
 * <pre>
 *   1 1 0 0 0
 *   1 1 0 0 0
 *   0 0 1 0 0
 *   0 0 0 1 1
 * </pre>
 * </p>
 * In the given matrix we have 3 offices defined, i.e. it can be converted to the following representation where we
 * mark each office with appropriate letter A, B and C, and wallas are marked with dots:
 * </p>
 * <pre>
 *   A A . . .
 *   A A . . .
 *   . . B . .
 *   . . . C C
 * </pre>
 * </p>
 * So, the linked (neighbor) <code>1</code>s represent the same office.
 * The purpose of the task/algorithm is to count the number of the offices at the given space area represented with the
 * given matrix of <code>0</code>s and <code>1</code>s.
 * </p>
 * Thus, it's a variant of the connectivity problem where we need to connect/unite neighbor cells into sets and count
 * the number of sets.
 * </p>
 * One more variant may propose to unite the cells into named sets like shown above in the matrix with A, B, C.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Office
{
	/**
	 * That's my quick implementation I passed to <a href="https://developers.turing.com/dashboard/algorithm_challenge">Turing</a> within 30-45 mins.
	 * Generally I don't like it, because involves <code>{@link java.util.HashMap}</code>, but couldn't find a better solution in that time.
	 * </p>
	 * NOTE: On <a href="https://developers.turing.com/dashboard/algorithm_challenge">Turing</a> they used a matrix of <code>{@link String}</code>
	 * to be entered from <code>STDIN</code>, but here I've exchanged my implementation with <code>int[][]</code>.
	 *
	 * @param area non-<code>null</code> matrix of integers, where <code>0</code> is a wall, and any other number is an office cell.
	 * @return the number of the offices consisting of connected office cells and separated by walls
	 */
	public static int countOfficesQuickImplementation(int[][] area)
	{
		int rv = 0;
		final Map<Long, Boolean> includedCells = new HashMap<>();
		for (int i = 0; i < area.length; i++)
		{
			for (int j = 0; j < area[i].length; j++)
			{
				if (findConnected(area, i, j, includedCells))
					rv++;
			}
		}
		return rv;
	}

	private static boolean findConnected(int[][] area, int i, int j, Map<Long, Boolean> includedCells)
	{
		if (i >= 0 && j >= 0 && i < area.length && j < area[i].length && area[i][j] != 0)
		{
			final long cellKey = ((long)i << 32) + (long)j;
			if (includedCells.putIfAbsent(cellKey, true) == null)
			{
				findConnected(area, i, j - 1, includedCells);
				findConnected(area, i, j + 1, includedCells);
				findConnected(area, i - 1, j, includedCells);
				findConnected(area, i + 1, j, includedCells);
				return true;
			}
		}
		return false;
	}
}

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/picking-numbers/problem">
 *   Practice > Algorithms > Implementation > Picking Numbers
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class PickingNumbers
{
	/**
	 * The complexity of solution is: <code>O((n^2 + n) / 2)</code>.
	 */
	public static int pickingNumbers(List<Integer> a)
	{
		int[] countersN = new int[a.size()];
		int[] countersP = new int[a.size()];
		int max = 0;
		for (int i = 0; i < a.size(); i++)
		{
			for (int j = i; j < a.size(); j++)
			{
				if (a.get(i) - a.get(j) == -1)
					countersN[i]++;
				else if (a.get(i) - a.get(j) == 1)
					countersP[i]++;
				else if (a.get(i) - a.get(j) == 0)
				{
					countersN[i]++;
					countersP[i]++;
				}
			}
			final int m = Math.max(countersN[i], countersP[i]);
			if (max < m)
				max = m;
		}
		return max;
	}
}

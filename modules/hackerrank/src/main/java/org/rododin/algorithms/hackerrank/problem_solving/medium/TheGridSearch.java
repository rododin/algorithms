package org.rododin.algorithms.hackerrank.problem_solving.medium;

/**
 * <a href="https://www.hackerrank.com/challenges/the-grid-search/problem">
 *   HackerRank > Practice > Algorithms > Implementation > The Grid Search
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TheGridSearch
{
	/**
	 * Implement a quite trivial solution.
	 * <p/>
	 * The complexity is hard to determine, because substring search and comparison API is used,
	 * but ignoring that the worst complexity is about <code>O(n^2 * l * (m-1))</code>,
	 * where <code>n</code> is the size of the <code>G</code> array (aka the height of the grid <code>G</code>),
	 * <code>l</code> is the the length of the strings in the grid <code>G</code> (aka the width of the grid <code>G</code>),
	 * and <code>m</code> is the height of the sought grid <code>P</code> (aka the height of the sub-grid <code>P</code>).
	 * <p/>
	 * Thus, it's probably not effective, but I don't see easily a better one, and this one has still passed the
	 * HackerRank's acceptance tests.
	 */
	public static String gridSearch(String[] G, String[] P)
	{
		if (G.length == 0 || P.length == 0)
			return "NO";

		final String p0 = P[0];
		boolean found = false;
		for (int i = 0; !found && i < G.length; i++)
		{
			final String g = G[i];
			int j = 0;
			for (j = g.indexOf(p0, j), found = j >= 0; found; j = j < g.length() ? g.indexOf(p0, j) : j, found = j >= 0 && j < g.length())
			{
				if (G.length - i < P.length)
					break;
				int y = 1;
				for (int x = i+1; found && x < G.length && y < P.length; x++, y++)
				{
					final String gx = G[x];
					final String py = P[y];
					if (!py.equals(gx.substring(j, j + py.length())))
						found = false;
				}
				if (found && y == P.length)
					break;
				else
					j++;
			}
		}

		return found ? "YES" : "NO";
	}
}

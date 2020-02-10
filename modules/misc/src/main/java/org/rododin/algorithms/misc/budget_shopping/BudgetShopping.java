package org.rododin.algorithms.misc.budget_shopping;

/**
 * <b>BUDGET SHOPPING - problem definition</b>
 * <p/>
 * Sources:
 * <ul>
 *   <li><a href="https://www.hackerrank.com">hackerrank.com</a></li>
 *   <li><a href="https://github.com/ufoscout/HackerRank_Java/blob/master/src/main/java/ufo/hackerrank/job/numbrs/budget_shopping/BudgetShooping_CodingChallenge.txt">github.com/ufoscout/HackerRank...BudgetShooping</a></li>
 * </ul>
 * Helen has <code>n</code> dollars budgeted to purchase Math notebooks.
 * There are <code>m</code> stores that stock unlimited supplies of notebooks in bundles, but the size and price of the
 * bundles vary from store to store. Helen can purchase as many bundles as she wants from as many stores as necessary
 * until she depletes her budget, but her goal is to purchase a maximal number of notebooks.
 * For example, if Helen has <code>n = 5</code> dollars and there are <code>m = 2</code> shops where one sells
 * 4-notebook bundles for 2 dollars a piece and the other sells 2-notebook bundles for 1 dollar a piece,
 * she will buy a total of <code>4 + 4 + 2 = 10</code> notebooks
 * (two bundles of 4 from the first shop and one bundle of 2 from the second shop).
 * <p/>
 * <b>Function Description</b>
 * <p/>
 * Complete the <code>budgetShopping()</code> function. It has three parameters:
 * <ul>
 *   <li><code>int n</code> - the number of dollars in Helen's notebook budget.</li>
 *   <li><code>int[] bundleQuantities</code> - each <code>bundleQuantities[i]</code>
 *       (where <code>0 ≤ i < m</code>) denotes the number of notebooks per bundle at shop <code>i</code>.
 *   </li>
 *   <li><code>int[] bundleCosts</code> - each <code>bundleCosts[i]</code>
 *       (where <code>0 ≤ i < m</code>) denotes the cost of each bundle at shop <code>i</code>.
 *   </li>
 * </ul>
 * The function must return an <code>int</code> value denoting the maximum number of notebooks she can buy with
 * <code>n</code> dollars.
 * <p/>
 * <b>Constraints</b>
 * <ul>
 *   <li><code>1 ≤ n ≤ 10000</code></li>
 *   <li><code>1 ≤ m ≤ 1000</code></li>
 *   <li><code>1 ≤ bundleQuantities[i] ≤ 100</code></li>
 *   <li><code>1 ≤ bundleCosts[i] ≤ 200</code></li>
 * </ul>
 * <b>Input Format For Custom Testing</b>
 * <ul>
 *   <li>The first line contains an integer, <code>n</code>, denoting the number of dollars in Helen's notebook
 *       budget.
 *   </li>
 *   <li>The next line contains an integer, <code>m</code>, denoting the number of shops.
 *   </li>
 *   <li>Each line <code>i</code> of the <code>m</code> subsequent lines (where <code>0 ≤ i < m</code>) contains an
 *       integer describing <code>bundleQuantities[i]</code>.
 *   </li>
 *   <li>The next line contains an integer, <code>m</code>, denoting the number of shops.
 *   </li>
 *   <li>Each line <code>i</code> of the <code>m</code> subsequent lines (where <code>0 ≤ i < m</code>) contains an
 *       integer describing <code>bundleCosts[i]</code>.
 *   </li>
 *   <li>One more (the last) line denotes the expected result</li>.
 * </ul>
 * <b>Sample Case 0</b>
 * <p/>
 * <i>Sample Input:</i>
 * <pre>
 * 50
 * 2
 * 20
 * 19
 * 2
 * 24
 * 20
 * 40
 * </pre>
 * <i>Sample Output:</i>
 * <pre>
 * 40
 * </pre>
 * <i>Explanation:</i>
 * <p/>
 * Helen has <code>n = 50</code> dollars to purchase notebooks from the <code>m = 2</code> stores described by
 * <code>bundleQuantities = [20, 19]</code> and <code>bundleCosts = [24, 20]</code>.
 * <p/>
 * She makes the following purchases:
 * <ul>
 *   <li>One bundle of <code>20</code> notebooks from shop <code>0</code> at a cost of <code>24</code> dollars and has <code>n = 50 − 24 = 26</code> dollars left.</li>
 *   <li>One bundle of <code>20</code> notebooks from shop <code>0</code> at a cost of <code>24</code> dollars and has <code>26 - 24 = 2</code> dollars left.</li>
 * </ul>
 * Helen can't afford any more notebooks, so we return the total number of notebooks she was able to purchase: <code>20 + 20 = 40</code>.
 * <p/>
 * <b>Sample Case 1</b>
 * <p/>
 * <i>Sample Input:</i>
 * <pre>
 * 4
 * 1
 * 10
 * 1
 * 2
 * 20
 * </pre>
 * <i>Sample Output:</i>
 * <pre>
 * 20
 * </pre>
 * <i>Explanation:</i>
 * <p/>
 * Helen has <code>n = 4</code> dollars to purchase notebooks from the <code>m = 1</code> store described by
 * <code>bundleQuantities = [10]</code> and <code>bundleCosts = [2]</code>.
 * <p/>
 * She makes the following purchases:
 * <ul>
 *   <li>One bundle of <code>10</code> notebooks from shop <code>0</code> at a cost of <code>2</code> dollars and has <code>n = 4 − 2 = 2</code> dollars left.</li>
 *   <li>One bundle of <code>10</code> notebooks from shop <code>0</code> at a cost of <code>2</code> dollars and has <code>2 − 2 = 0</code> dollars left.</li>
 * </ul>
 * Helen can't afford any more notebooks, so we return the total number of notebooks she was able to purchase: <code>10 + 10 = 20</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BudgetShopping
{
	public static int bruteForceSearch(int n, int[] bundleQuantities, int[] bundleCosts)
	{
		checkMainConstraints(n, bundleQuantities, bundleCosts);
		return doBruteForceSearch(n, bundleQuantities, bundleCosts);
	}

	private static int doBruteForceSearch(int n, int[] bundleQuantities, int[] bundleCosts)
	{
		if (n == 0)
			return 0;

		// TODO: Think, how to perform these constraint checks only once per shop/index
		// checkGivenItemsConstraints(bundleQuantities, bundleCosts, i);

		int max = 0;
		final int m = bundleQuantities.length;
		for (int k = 0; k < m; k++)
		{
			if (n < bundleCosts[k])
				continue;
			int r = n % bundleCosts[k];
			int nbAmountI = (n / bundleCosts[k]) * bundleQuantities[k]
			              + doBruteForceSearch(r, bundleQuantities, bundleCosts);
			if (max < nbAmountI)
				max = nbAmountI;
		}
		return max;
	}

	private static void checkMainConstraints(int n, int[] bundleQuantities, int[] bundleCosts)
	{
		if (n < 1 || n > 10000)
			throw new IllegalArgumentException("Expected: 1 ≤ n ≤ 10000, given: " + n);
		if (bundleQuantities.length != bundleCosts.length)
			throw new IllegalArgumentException("Expected: bundleQuantities.length == bundleCosts.length, given: " + bundleQuantities.length + " != " + bundleCosts.length);
		if (bundleQuantities.length < 1 || bundleQuantities.length > 1000)
			throw new IllegalArgumentException("Expected: 1 ≤ m ≤ 1000, given: " + bundleQuantities.length);
	}

	private static void checkGivenItemsConstraints(int[] bundleQuantities, int[] bundleCosts, int i)
	{
		if (bundleQuantities[i] < 1 || bundleQuantities[i] > 100)
			throw new IllegalArgumentException("Expected: 1 ≤ bundleQuantities[i] ≤ 100, given: " + bundleQuantities[i]);
		if (bundleCosts[i] < 1 || bundleCosts[i] > 200)
			throw new IllegalArgumentException("Expected: 1 ≤ bundleCosts[i] ≤ 200, given: " + bundleCosts[i]);
	}
}

package org.rododin.algorithms.leetcode.problems;

/**
 * TODO: Add description.
 */
public class BestTimeToBuyAndSellStockII
{
	public int maxProfit(int[] prices)
	{
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++)
		{
			if (prices[i] >= prices[i + 1])
				continue;

			final int lowest = prices[i];

			for (; i < prices.length - 1 && prices[i] <= prices[i + 1]; i++);

			final int highest = prices[i];

			profit += highest - lowest;
		}
		return profit;
	}
}

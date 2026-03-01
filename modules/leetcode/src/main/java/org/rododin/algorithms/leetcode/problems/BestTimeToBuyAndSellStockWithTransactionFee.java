package org.rododin.algorithms.leetcode.problems;

/**
 * TODO: Add description.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee
{
	public int maxProfit(int[] prices, int fee)
	{
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++)
		{
			if (prices[i] >= prices[i + 1])
				continue;

			final int lowest = prices[i];

			for (; i < prices.length - 1 && prices[i] <= prices[i + 1]; i++);

			final int highest = prices[i];

			final int currentProfit = highest - lowest - fee;
			profit += Math.max(currentProfit, 0);
		}
		return profit;
	}
}

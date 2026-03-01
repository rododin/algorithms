package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">
 *   LeetCode > Problems > Best Time to Buy and Sell Stock <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BestTimeToBuyAndSellStock
{
	public int maxProfit(int[] prices)
	{
		int maxProfit = 0;
		int minPrice = prices[0];

		for (int i = 1; i < prices.length; i++)
		{
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		return maxProfit;
	}
}

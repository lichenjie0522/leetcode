package hard;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author lichenjie0522
 *
 */
public class No123_BestTimetoBuyandSellStockIII {
	// 假设第一次发生在[0, j]区间内，那么第二次一定发生在[j + 1, len - 1]区间里。所以由此原理，我们可以使用类似Best Time
	// to Buy and Sell Stock I的方法，做两次dp。一次是从前向后，利用当前price -
	// minPrice。第二次是从后向前，利用当前的maxPrice - price。这样下来，我们综合两次的结果就能找到最大profit
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int profit = 0;
		int len = prices.length;
		int[] firstTransProfit = new int[len];
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			profit = Math.max(profit, prices[i] - minPrice);
			firstTransProfit[i] = profit;
			minPrice = Math.min(minPrice, prices[i]);
		}
		profit = 0;
		int maxPrice = 0;
		for (int i = len - 1; i >= 0; i--) {
			int secondTransProfit = (maxPrice > prices[i]) ? (maxPrice - prices[i]) : 0;
			profit = Math.max(profit, firstTransProfit[i] + secondTransProfit);
			maxPrice = Math.max(maxPrice, prices[i]);
		}
		return profit;
	}
}

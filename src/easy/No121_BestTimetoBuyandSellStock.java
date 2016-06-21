package easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author lichenjie0522
 *
 */
public class No121_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int leftMin = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - leftMin);
			if (prices[i] < leftMin) {
				leftMin = prices[i];
			}
		}
		return profit;
	}
}

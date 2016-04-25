package medium;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * @author lichenjie0522
 *
 */
public class No322_CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0) {
			return -1;
		}
		if (amount <= 0) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					int diff = i - coins[j];
					if (dp[diff] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[diff] + 1, dp[i]);
					}
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}

package leetcode.dynamic;

import java.util.Arrays;

/**
 * 动态规划：最有子结构即前i天最低股票价格
 * 
 * @author qizy
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 3, 1, 6, 8, 9, 15, -1, 2, 6, 8, 5 };
		// 第一个是哪天买，第二个是哪天卖，第三个是盈利值
		int result = bestTimeSellOne(prices);
		System.out.println(result);
	}

	private static int bestTimeSellOne(int[] prices) {
		int minprice = prices[0];

		int max = 0;
		int buyday =0;
		int sellday =0;
		int cmin = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minprice) {
				minprice = prices[i];
				cmin=i;
			}

			if (max < prices[i] - minprice) {
				max = prices[i] - minprice;
				sellday = i;
				buyday = cmin;
			}

		}
		System.out.println(buyday+1);
		System.out.println(sellday+1);
		return max;
	}
	

}

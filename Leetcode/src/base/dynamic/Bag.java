package base.dynamic;

/**
 * 动态规划 背包问题
 * 
 * @author qizy
 *
 */
public class Bag {

	public static void main(String[] args) {
		int[] price = {2, 3, 1, 4, 6, 5};
		int[] weight = {5, 6, 5, 1, 19, 7};
		int c = 10;
		int[] select = dpFindWay(price, weight, c);
	}

	private static int[] dpFindWay(int[] price, int[] weight, int c) {
		int n = weight.length;
		// dp[i][j] 前i种物品，背包重量为j的情况下的最大价值
		// 方式式： dp[i][j] = max{ dp[i-1][j],// j>w[i]放入第i种物品未必最大价值 ，
		// dp[i-1][j-w[i]]+p[i]
		// j<w[i] 容量不够 dp[i][j] = dp[i-1][j]
		int[][] dp = new int[n+1][c+1];
		// 定义一个是否放入的数组
		int[] x = new int[n];
		// 初始化
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < c; i++) {
			dp[0][c] = 0;
		}

		for (int i = 1; i < n; i++) {
			// 其实j应该从weight数组中最小的开始
			for (int j = 0; j < c; j++) {
				if (j < weight[i]) {
					x[i]=1;
					dp[i][j] = dp[i - 1][j];
				} else {
					// 放入了
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+price[i]);
				}
			}
		}
		
		// 遍历看下结果，跟算法本身无关
		for (int[] a : dp) {
			for (int t : a) {
				System.out.print(t + "  ");
			}
			System.out.println();
		}
		
		return null;
	}
}
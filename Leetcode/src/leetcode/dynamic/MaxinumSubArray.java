package leetcode.dynamic;

/**
 * 子数组和字符串的定义可大不一样，字符串按照顺序遍历，可组合任意 abc ->a ,b, c,ab,ac,bc,abc 但ca就不是了
 * 子数组，必须是一段连续的，不然这题做不了。先明白这两个概念
 * 
 * @author qizy
 *
 */
public class MaxinumSubArray {

	public static void main(String[] args) {
		// given the array [−2,1,−3,4,−1,2,1,−5,4],
		// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		findLargestSubArray(a);

	}

	private static int findLargestSubArray(int[] a) {
		// dp[i] 表示数组a从0到i的最大子数组的和（注意连续问题），
		// 则dp[i+1] = max{dp[i]+ a[i],a[i]}
		// 大白话解释，如果a[i]是负数了，+1长度肯定不是最大子数组了，但当前最大值需要判断一下
		int newsum = a[0];
		int max = a[0];
		int s=0;
		int e=0;
		for (int i = 1; i < a.length; i++) {
			newsum = Math.max(newsum + a[i], a[i]);
			max= Math.max(max, newsum);
		}

		return max;
	}

}

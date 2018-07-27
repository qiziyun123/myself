package leetcode.dynamic;

/**
 * 归类：动态
 * 相关概念，字符串子序列 abc  a,b,c ab,bc,ac,abc
 * 好难的一题
 * @author qizy
 *
 */
public class DistinctSubsequences {

	public static void main(String[] args) {
		// S = rabbbit
		// T = rabbit
	
//		那么递推关系式就变成了 

		
		
		// 动态思路 dp[i][j] 表示 s.sub(0,i)有多少子序列 跟  t.sub(0,j) 相同
		// 初始 s是空，T不是空，  即 dp[0][j] = 0 ,空串不相等与任意非空字符串，空串的子串也是
		// 初始s非空,T空， dp[i][0] =1, 空串为是任何字符串的字串
		// S.charAt(i) == T.charAt(j), dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
		// 
		// else  dp[i][j] = dp[i-1][j]; 如
		
		// 好难理解啊这个图可以解释一下啊,个人觉得最好的参考网页https://www.cnblogs.com/zl1991/p/7004492.html
		
//			r	a	b	b	b	i	t
//		1	1	1	1	1	1	1	1
//	r	0	1	1	1	1	1	1	1
//	a	0	0	1	1	1	1	1	1
//	b	0	0	0	1	2	3	3	3
//	b	0	0	0	0	1	3	3	3
//	i	0	0	0	0	0	0	3	3
//	t	0	0	0	0	0	0	0	3
	}

	public static int numDistincts(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];
	 
		for (int i = 0; i < S.length(); i++)
			table[i][0] = 1;
	 
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] += table[i - 1][j];
				}
			}
		}
	 
		return table[S.length()][T.length()];
	}
}

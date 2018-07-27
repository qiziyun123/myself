package leetcode.dynamic;

/**
 * ���ࣺ��̬
 * ��ظ���ַ��������� abc  a,b,c ab,bc,ac,abc
 * ���ѵ�һ��
 * @author qizy
 *
 */
public class DistinctSubsequences {

	public static void main(String[] args) {
		// S = rabbbit
		// T = rabbit
	
//		��ô���ƹ�ϵʽ�ͱ���� 

		
		
		// ��̬˼· dp[i][j] ��ʾ s.sub(0,i)�ж��������� ��  t.sub(0,j) ��ͬ
		// ��ʼ s�ǿգ�T���ǿգ�  �� dp[0][j] = 0 ,�մ������������ǿ��ַ������մ����Ӵ�Ҳ��
		// ��ʼs�ǿ�,T�գ� dp[i][0] =1, �մ�Ϊ���κ��ַ������ִ�
		// S.charAt(i) == T.charAt(j), dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
		// 
		// else  dp[i][j] = dp[i-1][j]; ��
		
		// ������Ⱑ���ͼ���Խ���һ�°�,���˾�����õĲο���ҳhttps://www.cnblogs.com/zl1991/p/7004492.html
		
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

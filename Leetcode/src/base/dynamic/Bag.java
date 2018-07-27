package base.dynamic;

/**
 * ��̬�滮 ��������
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
		// dp[i][j] ǰi����Ʒ����������Ϊj������µ�����ֵ
		// ��ʽʽ�� dp[i][j] = max{ dp[i-1][j],// j>w[i]�����i����Ʒδ������ֵ ��
		// dp[i-1][j-w[i]]+p[i]
		// j<w[i] �������� dp[i][j] = dp[i-1][j]
		int[][] dp = new int[n+1][c+1];
		// ����һ���Ƿ���������
		int[] x = new int[n];
		// ��ʼ��
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < c; i++) {
			dp[0][c] = 0;
		}

		for (int i = 1; i < n; i++) {
			// ��ʵjӦ�ô�weight��������С�Ŀ�ʼ
			for (int j = 0; j < c; j++) {
				if (j < weight[i]) {
					x[i]=1;
					dp[i][j] = dp[i - 1][j];
				} else {
					// ������
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+price[i]);
				}
			}
		}
		
		// �������½�������㷨�����޹�
		for (int[] a : dp) {
			for (int t : a) {
				System.out.print(t + "  ");
			}
			System.out.println();
		}
		
		return null;
	}
}
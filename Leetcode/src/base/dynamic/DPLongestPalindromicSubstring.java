package base.dynamic;

/**
 * ��̬�滮�㷨ʵ��
 * 
 * @author qizy
 *
 */
public class DPLongestPalindromicSubstring {

	public static String eval(String model) {
		// dp[i,j] ��ʾ���±�i,���±�j�ǻ����ַ���
		// ���ݶ�̬�滮˼�룬��ʽʽ dp[i,j] = dp[i-1,j+1] && model �±�i��j���
		
//		model = "dabcba";
		int size = model.length();
		int[][] dp = new int[size][size];
		int start=0;
		int maxLength=0;
		// ��ʼ��
		for (int i = 0; i < model.length(); i++) {
			dp[i][i] = 1;
			if (i != size - 1 && model.charAt(i) == model.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				maxLength = 2;
				start = i;
			}
		}
		// ��ӡһ�£����Ը��õ��ѽ�
		print(dp);
		System.out.println();
		// �ӳ���3
		for(int l=3;l<model.length();l++) {
			System.out.println(l);
			// ���ݶ�̬�滮˼�룬��ʽʽ dp[i,j] = dp[i-1,j+1] && model �±�i��j���
			for(int i=0;i<=model.length()-l;i++) {
				int j = i+l-1;
				if(dp[i+1][j-1]==1&& model.charAt(i)==model.charAt(j)) {
					dp[i][j]=1;
					maxLength = l;
					start = i;
				}
			}
			
			print(dp);
		}
		if(maxLength>=2) {
			
			System.out.println(maxLength);
			return model.substring(start,maxLength+start);
		}
		return null;
	}

	public static void main(String[] args) {
		// ����dabcba ż�� dabba
		String r = eval("dabcba");
		System.out.println(r);
	}
	
	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) { // ������ά���飬����������ÿһ��Ԫ����һ��һά����
			for (int j = 0; j < dp[i].length; j++) { // ������Ӧλ���ϵ�һά����
				System.out.print(dp[i][j] + " ") ;
			}
			System.out.println() ;
		}

	}

}

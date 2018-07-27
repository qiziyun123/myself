package base.dynamic;

/**
 * 动态规划算法实例
 * 
 * @author qizy
 *
 */
public class DPLongestPalindromicSubstring {

	public static String eval(String model) {
		// dp[i,j] 表示从下表i,到下表j是回文字符串
		// 根据动态规划思想，方式式 dp[i,j] = dp[i-1,j+1] && model 下表i和j相等
		
//		model = "dabcba";
		int size = model.length();
		int[][] dp = new int[size][size];
		int start=0;
		int maxLength=0;
		// 初始化
		for (int i = 0; i < model.length(); i++) {
			dp[i][i] = 1;
			if (i != size - 1 && model.charAt(i) == model.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				maxLength = 2;
				start = i;
			}
		}
		// 打印一下，可以更好的裂解
		print(dp);
		System.out.println();
		// 从长度3
		for(int l=3;l<model.length();l++) {
			System.out.println(l);
			// 根据动态规划思想，方式式 dp[i,j] = dp[i-1,j+1] && model 下表i和j相等
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
		// 奇数dabcba 偶数 dabba
		String r = eval("dabcba");
		System.out.println(r);
	}
	
	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) { // 遍历二维数组，遍历出来的每一个元素是一个一维数组
			for (int j = 0; j < dp[i].length; j++) { // 遍历对应位置上的一维数组
				System.out.print(dp[i][j] + " ") ;
			}
			System.out.println() ;
		}

	}

}

package leetcode.bfs;

import java.util.ArrayList;

/**
 * 动态规划思路容易点，DFS感觉不太容易想这个问题
 * @author qizy
 *
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
//		         aab
//		      /   |   \
//		   (a)√ (aa)√  aab×
//		  /  \    | 
//		(a)√ ab× (b)√
//		 |
//		(b)√
//		a,a,b aa,b
		//写毛注释去解释DFS，图最好理解
		String t = "aab";
		ArrayList<ArrayList<String>> result = partition(t);
		System.out.println(result);
	}

	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	 
		if (s == null || s.length() == 0) {
			return result;
		}
		//track each possible partition 其實就是某一個樹枝
		ArrayList<String> partition = new ArrayList<String>();
		// 重要，DFS但凡要求所有滿足的分支，都要先new 兩個，一個是最終結果，一個是單獨一個樹枝，代入函數，写函数体里面很麻烦
		addPalindrome(s, 0, partition, result);
	 
		return result;
	}
	 
	private static void addPalindrome(String s, int start, ArrayList<String> partition,
			ArrayList<ArrayList<String>> result) {
	//        aab
	//     /   |   \
	//  (a)√ (aa)√  aab×
	// /  \    | 
	//(a)√ ab× (b)√
	//|
	//(b)√
	//a,a,b aa,b
		//stop condition 最底層的終止條件
		if (start == s.length()) {
			// 這個方法忘記了複製了
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
	 
		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str); 
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}
	 
	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
	 
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
	 
			left++;
			right--;
		}
	 
		return true;
	}


}

package leetcode.dynamic;

import base.dynamic.DPLongestPalindromicSubstring;

/**
 * 问题归类：动态规划算法，动态规划时间复杂度都是O(n^2)，动态规划参考dynamic.DPLongestPalindromicSubstring
 * 半径法，比动态节省空间 要求只求长度，返回最大回文串也不是太难
 * 
 * @author qizy
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String model = "awcfbbfccsfeewf";
		String str = DPLongestPalindromicSubstring.eval(model);
//		System.out.println(str);
		// 半径法
		str = longestPalindromicSubstr(model);
		System.out.println(str);
		System.out.println(str.length());
	}

	/**
	 * 奇数偶数都要校验
	 * 
	 * @param model
	 * @return
	 */
	private static String longestPalindromicSubstr(String model) {
		// 当前最大回文串
		String longest = model.substring(0, 1);
		System.out.println(model);
		if (model.isEmpty()) {
			return null;
		}
	 
		if (model.length() == 1) {
			return model;
		}
	 
		for (int i = 0; i < model.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(model, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(model, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}

	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}

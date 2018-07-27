package leetcode.dynamic;

import base.dynamic.DPLongestPalindromicSubstring;

/**
 * ������ࣺ��̬�滮�㷨����̬�滮ʱ�临�Ӷȶ���O(n^2)����̬�滮�ο�dynamic.DPLongestPalindromicSubstring
 * �뾶�����ȶ�̬��ʡ�ռ� Ҫ��ֻ�󳤶ȣ����������Ĵ�Ҳ����̫��
 * 
 * @author qizy
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String model = "awcfbbfccsfeewf";
		String str = DPLongestPalindromicSubstring.eval(model);
//		System.out.println(str);
		// �뾶��
		str = longestPalindromicSubstr(model);
		System.out.println(str);
		System.out.println(str.length());
	}

	/**
	 * ����ż����ҪУ��
	 * 
	 * @param model
	 * @return
	 */
	private static String longestPalindromicSubstr(String model) {
		// ��ǰ�����Ĵ�
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

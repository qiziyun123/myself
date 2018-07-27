package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {
		String t = "abcabcxbb";
		int longest = find(t);
		System.out.println(longest);
	}

	private static int find(String t) {
		// map记录字符和下标的关系
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int s=0;
		int result =0;
		while(s<=t.length()-1) {
			char c = t.charAt(s);
			if(map.containsKey(c)) {
				// 发现重复的 abcabcxbb 到第2个a了
				int olds = map.get(c);
				// 这个字符下标到当前
				int temp = s-olds;
				result = Math.max(temp, result);
				map.put(c, s);
			}else {
				map.put(c, s);
			}
			s++;
			
		}
		return result;
	}

}

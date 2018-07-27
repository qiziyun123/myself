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
		// map��¼�ַ����±�Ĺ�ϵ
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int s=0;
		int result =0;
		while(s<=t.length()-1) {
			char c = t.charAt(s);
			if(map.containsKey(c)) {
				// �����ظ��� abcabcxbb ����2��a��
				int olds = map.get(c);
				// ����ַ��±굽��ǰ
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

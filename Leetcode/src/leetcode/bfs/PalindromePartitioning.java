package leetcode.bfs;

import java.util.ArrayList;

/**
 * ��̬�滮˼·���׵㣬DFS�о���̫�������������
 * @author qizy
 *
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
//		         aab
//		      /   |   \
//		   (a)�� (aa)��  aab��
//		  /  \    | 
//		(a)�� ab�� (b)��
//		 |
//		(b)��
//		a,a,b aa,b
		//дëע��ȥ����DFS��ͼ������
		String t = "aab";
		ArrayList<ArrayList<String>> result = partition(t);
		System.out.println(result);
	}

	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	 
		if (s == null || s.length() == 0) {
			return result;
		}
		//track each possible partition �䌍����ĳһ����֦
		ArrayList<String> partition = new ArrayList<String>();
		// ��Ҫ��DFS����Ҫ�����НM��ķ�֧����Ҫ��new �ɂ���һ������K�Y����һ���ǆΪ�һ����֦�����뺯����д������������鷳
		addPalindrome(s, 0, partition, result);
	 
		return result;
	}
	 
	private static void addPalindrome(String s, int start, ArrayList<String> partition,
			ArrayList<ArrayList<String>> result) {
	//        aab
	//     /   |   \
	//  (a)�� (aa)��  aab��
	// /  \    | 
	//(a)�� ab�� (b)��
	//|
	//(b)��
	//a,a,b aa,b
		//stop condition ��׌ӵĽKֹ�l��
		if (start == s.length()) {
			// �@��������ӛ���}�u��
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

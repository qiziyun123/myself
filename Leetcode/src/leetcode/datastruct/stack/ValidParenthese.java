package leetcode.datastruct.stack;

import java.util.Stack;

/**
 * 搞过计算器，看这题，一想就用栈
 * https://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/ 
 * 这个参考巧用了hashmap，减少了if else和变量的设置，显然考虑了对称性,但仔细读题，The brackets must close in the correct order
 * 就是说，各种括号的顺序必须对，即允许这种情况发生 abc(dedf,不然参考就是错的   
 * if else多点可读性好。
 * 个人的代码实现了一个 括号必须有意义的解法
 * @author qizy
 *
 */
public class ValidParenthese {

	public static void main(String[] args) {
		String correctStr = "(xaf[efe]we)";
		String incorrectStr = "xfe[(sdf])wfw";
		String aa = "d(d]";
		String bb = "d)d";
		boolean y1 = validParenthese(correctStr);
		boolean y2 = validParenthese(incorrectStr);
		System.out.println(y1);
		System.out.println(y2);
		
		System.out.println(validParenthese(aa));
		System.out.println(validParenthese(bb));
	}

	private static boolean validParenthese(String correctStr) {
		// 假设只有() [] ，其他也一样，重在体会栈的应用
		char[] arr = correctStr.toCharArray();
		Stack<Character> s = new Stack<Character>();
		for (Character c : arr) {
			if(c=='['||c=='(') {
				s.push(c);
			}else if(c==']') {
				if(s.isEmpty()) {
					return false;
				}
				if(!s.isEmpty()) {
					char t = s.pop();
					if(t!='[') {
						return false;
					}
				}
			}else if(c==')') {
				if(s.isEmpty()) {
					return false;
				}
				if(!s.isEmpty()) {
					char t = s.pop();
					if(t!='(') {
						return false;
					}
				}
			}
		}
		return s.empty();
	}

}

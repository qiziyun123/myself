package leetcode.datastruct.stack;

import java.util.Stack;

/**
 * ����������������⣬һ�����ջ
 * https://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/ 
 * ����ο�������hashmap��������if else�ͱ��������ã���Ȼ�����˶Գ���,����ϸ���⣬The brackets must close in the correct order
 * ����˵���������ŵ�˳�����ԣ������������������ abc(dedf,��Ȼ�ο����Ǵ��   
 * if else���ɶ��Ժá�
 * ���˵Ĵ���ʵ����һ�� ���ű���������Ľⷨ
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
		// ����ֻ��() [] ������Ҳһ�����������ջ��Ӧ��
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

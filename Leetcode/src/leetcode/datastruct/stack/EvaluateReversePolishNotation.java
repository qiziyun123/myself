package leetcode.datastruct.stack;

import java.util.Stack;

/**
 * ��׺���ʽת��׺���ʽ������ջ���м���
 * ͼ��ο�https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * ��չ�㣺��׺��α��׺���ο�https://blog.csdn.net/bbc955625132551/article/details/72784464
 * ��A+(B-C/D)*E��εõ���׺���ʽABCD/-E*+
 * ʵ��ת���Ļ����������£�
	1.��ʼ��һ�������ջ��
	2.���������ʽ������ַ��������δ�������ÿ�ζ�ȡһ���ַ���
	3.�����ǰ�ַ��ǲ���������ֱ����д����׺���ʽ��
	4.�����ǰ�ַ��ǣ������ţ�����ѹ�������ջ����һ�����壩��
	5.�����ǰ�ַ�Ϊ���������
	5.1.�������ջΪ�գ�����ѹ�������ջ��
	5.2.��������������ȼ�����ջ��Ԫ�ص�ʱ���򽫴������ѹ�������ջ�����򣬵���ջ�����������׺���ʽ�����ҽ���ǰ�����ѹջ���ص�����2.
	6.�����ǰ�ַ��ǣ������ţ�������ջ��Ԫ�ص�������׺���ʽ��ֱ��ջ��Ԫ���������ţ�Ϊֹ�����������Ŵ�ջ�е���������
	7.�����ȡ��δ��ɣ��ص�����2.
	8.�����ȡ��ɣ���ջ��ʣ�����������ε�������׺���ʽ��
 * @author qizy
 *
 */
public class EvaluateReversePolishNotation {
	public static String[] operators = {"+","-","*","/"};
	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(eval(tokens));
	}

	private static int eval(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for(String s: tokens) {
			if(!isoperator(s)) {
				int n = Integer.valueOf(s);
				stack.push(n);
			}else {
				evaluate(stack,s);
			}
		}
		return (int) stack.pop();
	}

	private static void evaluate(Stack<Integer> stack, String o) {
		int n1 = stack.pop();
		int n2 = stack.pop();
		switch (o) {
		case "+":
			stack.push(n1+n2);
			break;
		case "-":
			stack.push(n1-n2);
			break;
		case "*":
			stack.push(n1*n2);
			break;
		case "/":
			stack.push(n1/n2);
			break;
		default:
			break;
		}
		
	}

	private static boolean isoperator(String s) {
		for (String o : operators) {
			if(s.equals(o)) {
				return true;
			}
		}
		return false;
	}
	
}

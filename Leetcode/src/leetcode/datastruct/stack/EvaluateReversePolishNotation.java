package leetcode.datastruct.stack;

import java.util.Stack;

/**
 * 中缀表达式转后缀表达式后，利用栈进行计算
 * 图解参考https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * 扩展点：中缀如何变后缀，参考https://blog.csdn.net/bbc955625132551/article/details/72784464
 * 由A+(B-C/D)*E如何得到后缀表达式ABCD/-E*+
 * 实现转换的基本步骤如下：
	1.初始化一个运算符栈。
	2.从算数表达式输入的字符串中依次从左向右每次读取一个字符。
	3.如果当前字符是操作数，则直接填写到后缀表达式。
	4.如果当前字符是（左括号，将其压入运算符栈（第一步定义）。
	5.如果当前字符为运算符，则
	5.1.当运算符栈为空，则将其压入运算符栈。
	5.2.当此运算符的优先级高于栈顶元素的时候，则将此运算符压入运算符栈；否则，弹出栈顶运算符到后缀表达式，并且将当前运算符压栈。回到步骤2.
	6.如果当前字符是）右括号，反复将栈顶元素弹出到后缀表达式，直到栈顶元素是左括号（为止，并将左括号从栈中弹出丢弃。
	7.如果读取还未完成，回到步骤2.
	8.如果读取完成，则将栈中剩余的运算符依次弹出到后缀表达式。
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

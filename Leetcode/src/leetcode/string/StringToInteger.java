package leetcode.string;

/**
 * 其实不知道这个问题属于哪类，感觉像迭代问题，最重要的就是 对10取余 并叠加
 * 归为字符串处理吧，内功深了或许将来知道怎么分类
 * @author qizy
 *
 */
public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="-13423f2";
		System.out.println(atoi(str));
	}

	private static Integer atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;
	}
	
}

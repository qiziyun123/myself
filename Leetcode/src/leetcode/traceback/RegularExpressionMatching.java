package leetcode.traceback;


/**
 * 递归，考虑情况多一点
 * @author qizy
 *
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		String s = "aa";
		String p = "a";
		boolean b = isMatch(s,p);
	//	isMatch("aa","a") → false
	//	isMatch("aa","aa") → true
	//	isMatch("aaa","aa") → false
	
//		isMatch("aab", "c*a*b") → true

	}

	private static boolean isMatch(String s, String p) {
		if(p.length()==0) {
			return s.length()==0;
		}
		if(p.length()==1) {
			if(s.length()==0) {
				return false;
			}
			if(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.') {
				return isMatch(s.substring(1),p.substring(1));
			}else {
				return false;
			}
		}
		// 
		if(p.charAt(1)!='*') {
			if(s.length()==0) {
				return false;
			}
			if(s.charAt(0)!=p.charAt(0)||p.charAt(0)=='.') {
				return false;
			}else {
				return isMatch(s.substring(1),p.substring(1));
			}
				
			
		}else {
//			isMatch("aa", "a*") → true
			//	isMatch("aa", ".*") → true
			//	isMatch("ab", ".*") → true
			while(s.length()>0&&(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.')) {
				if(isMatch(s,p.substring(2))) {
					return true;
				}else {
					s=s.substring(1);
				}
				
			}
			//isMatch("aab", "c*a*b")
			return isMatch(s,p.substring(2));
		}
	}

}

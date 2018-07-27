package leetcode.string;
/**
 * 
 * @author qizy
 *
 */
public class ImpleStrstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "advabfeabcxx";
		String needle = "abc";
		// ±©Á¦·¨
		int index = strNative(haystack,needle);
		System.out.println(index);
		// TODO KMP
	}

	private static int strNative(String haystack, String needle) {
		if(haystack.length()<needle.length()) {
			return -1;
		}
		for(int i=0;i<haystack.length();i++) {
			if(haystack.length()-i<needle.length()) {
				return -1;
			}
			int m=i;
			for(int j=0;j<needle.length();j++) {
				if(haystack.charAt(m)==needle.charAt(j)) {
					if(j==needle.length()-1) {
						return i;
					}
					m++;
				}else {
					break;
				}
				
			}
		}
		return -1;
	}

}

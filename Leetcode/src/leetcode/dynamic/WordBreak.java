package leetcode.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author qizy
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		// leetcode can be break into leet code
		Set<String> s = new HashSet<String>();
		s.add("leet");
		s.add("code");
		String partern = "leetcode";
		System.out.println(wordbreak(partern,s));

	}

	private static boolean wordbreak(String partern, Set<String> s) {
		// init dp  string.substring(0,0) is null
		// so dp length 是长度+1,初始dp[0] = true;
		// dp [i] 从0到i是否可被分割
		// 从0开始遍历字符串，每个字符起点开始，便利set集合，则可得到dp中部分数值
		// 循坏到后面的时候，如果前dp[i]有值了，则不用遍历了，符合动态规划，前面的计算为后面使用
		boolean[] dp = new boolean[partern.length()+1];
        dp[0] = true;
 
        for(int i=0; i<partern.length(); i++){
            if(!dp[i]) 
                continue;
 
            for(String a: s){
                int len = a.length();
                int end = i + len;
                if(end > partern.length())
                    continue;
 
                if(dp[end]) continue;
 
                if(partern.substring(i, end).equals(a)){
                    dp[end] = true;
                }
            }
        }
 
        return dp[partern.length()];
	}

}

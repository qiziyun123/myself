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
		// so dp length �ǳ���+1,��ʼdp[0] = true;
		// dp [i] ��0��i�Ƿ�ɱ��ָ�
		// ��0��ʼ�����ַ�����ÿ���ַ���㿪ʼ������set���ϣ���ɵõ�dp�в�����ֵ
		// ѭ���������ʱ�����ǰdp[i]��ֵ�ˣ����ñ����ˣ����϶�̬�滮��ǰ��ļ���Ϊ����ʹ��
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

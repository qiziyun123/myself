package base.subsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * �ַ�����������
 * 
 * @author qizy
 *
 */
public class StringSubsequences {

	public static void main(String[] args) {
		// �ַ������������ַ�����������
		// ���磺�ַ���abc,�����У�a,b,c,ab,ba,ac,ca,bc,cb,abc,acb,bac,bca,cab,cba
		String str = "abc";
		perm(str);
	}

	// ���ַ����������ַ������abc>a,b,c,ab,ac,bc,abc  
    public static void perm(String s) {  
        List<String> result = new ArrayList<String>();  
        for (int i = 1; i <= s.length(); i++) {  
            perm(s, i, result);  
        }  
    }  
  
    // ���ַ���s��ѡ��m���ַ�  
    public static void perm(String s, int m, List<String> result) {  
  
        // ���m==0����ݹ�����������ǰ���  
        if (m == 0) {  
            for (int i = 0; i < result.size(); i++) {  
                System.out.print(result.get(i));  
            }  
            System.out.println();  
            return;  
        }  
  
        if (s.length() != 0) {  
            // ѡ��ǰԪ��  
            result.add(s.charAt(0) + "");  
            perm(s.substring(1, s.length()), m - 1, result);  
            result.remove(result.size() - 1);  
            // ��ѡ��ǰԪ��  
            perm(s.substring(1, s.length()), m, result);  
        }  
    }   
}

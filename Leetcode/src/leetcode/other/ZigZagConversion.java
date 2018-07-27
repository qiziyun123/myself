package leetcode.other;

public class ZigZagConversion {

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		
		String zstr = zigzag(str,3);
		System.out.println(zstr);

	}

	private static String zigzag(String s,int n) {
		// zigzag��Ӣ�ľ���֮����
		// ���� ����һ���ַ������ɣ�������һһ�ַ�����
		// ����n
		// ��һ�к����һ���±�������interval = n*2-2
		// �м伸��interval-(2*i)
//		P   A   H   N
//		A P L S I I G
//		Y   I   R
		if(n == 1) {
			return s;
		}
        int len = s.length();
        int k = 0;
        int interval = (n*2)-2;
        // s�ȳ��ȵĿ��ַ���

        char[] res = new char[len];
        for(int j = 0; j < len ; j += interval) {
        	//�����һ��
            res[k++] = s.charAt(j);
        }
        for(int i = 1; i < n-1; i++){
        	//�����м���
            int inter = (i*2);
            for(int j = i; j < len; j += inter)
            {
                res[k++] = s.charAt(j);
                inter = interval - inter;
            }
        }
        for(int j = n-1; j < len ; j += interval) {
        	//�������һ��
        	res[k++] = s.charAt(j);
        }
        String resstr ="";
        for (char c : res) {
        	resstr += c;
		}
        return resstr;
	}

}

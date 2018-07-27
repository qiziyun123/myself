package leetcode.other;

public class ZigZagConversion {

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		
		String zstr = zigzag(str,3);
		System.out.println(zstr);

	}

	private static String zigzag(String s,int n) {
		// zigzag在英文就是之字形
		// 规律 遍历一次字符串即可，但不是一一字符遍历
		// 行数n
		// 第一行和最后一行下标间隔都是interval = n*2-2
		// 中间几行interval-(2*i)
//		P   A   H   N
//		A P L S I I G
//		Y   I   R
		if(n == 1) {
			return s;
		}
        int len = s.length();
        int k = 0;
        int interval = (n*2)-2;
        // s等长度的空字符串

        char[] res = new char[len];
        for(int j = 0; j < len ; j += interval) {
        	//处理第一行
            res[k++] = s.charAt(j);
        }
        for(int i = 1; i < n-1; i++){
        	//处理中间行
            int inter = (i*2);
            for(int j = i; j < len; j += inter)
            {
                res[k++] = s.charAt(j);
                inter = interval - inter;
            }
        }
        for(int j = n-1; j < len ; j += interval) {
        	//处理最后一行
        	res[k++] = s.charAt(j);
        }
        String resstr ="";
        for (char c : res) {
        	resstr += c;
		}
        return resstr;
	}

}

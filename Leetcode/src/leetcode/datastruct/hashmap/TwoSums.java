package leetcode.datastruct.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ࣺ���˸о��������㷨�������ʣ���Ҫ�뿼���ݽṹ��ʹ�ðɣ����Էŵ�hashmap����һЩ
 * @author qizy
 * ��Ŀ��ţ�1
 */
public class TwoSums {

	public static void main(String[] args) {
		// Input: numbers={2, 7, 11, 15}, target=9
		// Output: index1=0, index2=1
		// ��Ŀ��˵����һ��������ģ�Ҳ��������ǲ����ںͱ߽�ֵ��
		int a[]	={2, 11, 7, 15};
		int target = 9;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++) {
			int chazhi = target-a[i];
			if(map.containsKey(a[i])) {
				int index1 =i;
				int index2 =map.get(a[i]);
				System.out.println(index1);
				System.out.println(index2);
				break;
			}else {
				map.put(chazhi, i);
			}
		}
		
	}

}

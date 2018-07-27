package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * �ϴ���hashmap ����������⣬��ˢһ������Ϊ���滹��3sum������
 * Ҫ����λָ��ķ�ʽ���
 * @author qizy
 *
 */
public class TwoSums {

	public static void main(String[] args) {
		int[] n = {2,11,5,8,19};
		int target = 13;
		// [2,11] [5,8]
		// first sort the array
		Arrays.sort(n);
		Set<int []>result = findTwoNum(n,target);
		for (int[] is : result) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}
			System.out.println();
		}
	}

	private static Set<int[]> findTwoNum(int[] n, int target) {
		if(n.length==0) {
			return null;
		}
		Set<int[]> result = new HashSet<int[]>();
		int s=0;
		int e=n.length-1;
		
		while(s<e) {
			int sum = n[s]+n[e];
			if(target-sum==0) {
				int[] a = {n[s],n[e]};
				result.add(a);
				s++;
				e--;
			}
			if(target-sum>0) {
				s++;
			}
			if(target-sum<0) {
				e--;
			}
		}
		
		return result;
	}

}

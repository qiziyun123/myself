package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// For example, given [100, 4, 200, 1, 3, 2], 
		// the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
		// 时间复杂度O(n) 不能双重循坏
		int[] a= {100,4,200,1,3,2};
		Set<Integer> s = new HashSet<Integer>();
		for (int n : a) {
			s.add(n);
		}
		Set<Integer> result = new HashSet<Integer>();
		// 最起码有1个，除非空数组，这里不判断了
		int max =1;
		for(int num:a) {
			int l = num-1;
			int r = num+1;
			Set<Integer> temp = new HashSet<Integer>();
			temp.add(num);
			int count=1;
			while(s.contains(l)) {
				temp.add(l);
				count++;
				l--;
			}
			while(s.contains(r)) {
				temp.add(r);
				count++;
				r++;
			}
			if(count>max) {
				max = count;
				result= temp;
			}else {
			}
		}
		System.out.println(max);
		for (Integer i : result) {
			System.out.println(i);
		}
	}

}

package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 归类：求Ksum问题
 * @author qizy
 *
 */
public class KSums {

	public static void main(String[] args) {
		// 3sum
		// S = {-1 0 1 2 -1 4}
		// 4sum
		//  S = {1 0 -1 0 -2 2}
		int[] s3 = {-1,0,1,2,-1,4};
		Arrays.sort(s3);
		List<LinkedList<Integer>> r3 = findKNum(s3,0,3,0);
		for (LinkedList<Integer> linkedList : r3) {
			while(linkedList.size()>0) {
				System.out.print(linkedList.pop() + "--->");
			}
			System.out.println();
		}
		int[] s4 = {1,0,-1,0,-2,2};
		Arrays.sort(s4);
		List<LinkedList<Integer>> r4 = findKNum(s4,0,4,0);
		for (LinkedList<Integer> linkedList : r4) {
			while(linkedList.size()>0) {
				System.out.print(linkedList.pop() + "--->");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param s
	 * @param target
	 * @param k
	 * @return
	 */
	private static List<LinkedList<Integer>> findKNum(int[] s, int target, int k,int index) {
		if(s.length<k) {
			return null;
		}
		List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		
		if(k-2==0) {
			// 转换为2sum
			List<LinkedList<Integer>> slist = findTwoNum(s, target, index);
			return slist;
		}else {
			// 递归
			for(int i=index;i<s.length-k+1;i++) {
				int rest = target-s[i];
				List<LinkedList<Integer>> temp = findKNum(s,rest,k-1,i+1);
				for (LinkedList<Integer> subList : temp) {
					subList.addFirst(s[i]);
					result.add(subList);
				}
				
			}
		} 
		return result;
	}

	private static List<LinkedList<Integer>> findTwoNum(int[] n, int target, int start) {
		List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if(n.length==0) {
			return null;
		}
		
		int s=start;
		int e=n.length-1;
		
		while(s<e) {
			int sum = n[s]+n[e];
			if(target-sum==0) {
				LinkedList<Integer> t = new LinkedList<Integer>();
				t.add(n[s]);
				t.add(n[e]);
				result.add(t);
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

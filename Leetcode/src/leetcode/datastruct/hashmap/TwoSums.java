package leetcode.datastruct.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题归类：个人感觉归哪中算法都不合适，主要想考数据结构的使用吧，所以放到hashmap合适一些
 * @author qizy
 * 题目序号：1
 */
public class TwoSums {

	public static void main(String[] args) {
		// Input: numbers={2, 7, 11, 15}, target=9
		// Output: index1=0, index2=1
		// 题目都说假设一定有满足的，也就是你别考虑不存在和边界值了
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

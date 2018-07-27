package leetcode.binarysearch;
/**
 * 问题归类：二分查找算法,拆入位置，其实不用单独写代码逻辑，只要理解了，循环法求二分查找的下标位置，就明白了
 * @author qizy
 *
 */
public class SearchInsertPoistion {

	public static void main(String[] args) {
		// Given a sorted array and a target value, return the index if the target is found. 
		// If not, return the index where it would be if it were inserted in order. 
		// You may assume no duplicates in the array.
		int[] a = {1,3,5,6};
//		[1,3,5,6], 5 -> 2
		int k1 = 5;
		int p1 = binarySearch(a,k1);
//		[1,3,5,6], 2 -> 1
		int k2 = 2;
		int p2 = binarySearch(a,k2);
//		[1,3,5,6], 7 -> 4
		int k3 = 7;
		int p3 = binarySearch(a,k3);
//		[1,3,5,6], 0 -> 0
		int k4 = 0;
		int p4 = binarySearch(a,k4);
	}

	private static int binarySearch(int[] a, int k) {
		if(k>a[a.length-1]) {
			return a.length;
		}
		int lo = 0;
		int hi = a.length-1;
		int mid = (lo+hi)/2;
		while(lo<=hi) {
			if(a[mid]==k) {
				return k;
			}else if(a[mid]<k){
				lo = mid+1;
			}else {
				hi = mid-1;
			}
		}
		return lo;
	}

}

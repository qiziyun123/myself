package leetcode.binarysearch;

/**
 * 概念：中位数是将数组排序之后，数组个数为奇数时，取中间的即为中位数；数组个数为偶数时，取中间两个的平均值即为中位数。
 * 思考方向：已排序的数组，二分比较合适
 * 问题归类：有序数组找数组第K个数
 * 扩展点：无序数组求第K元素，无需排序，参考实例find.array.kth.HeapSort
 * 参考：https://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 * @author qizy
 *
 */
public class MedianTwoSortArrays {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2, 7, 8};
		int[] nums2 = new int[]{3, 4, 5, 6, 9, 10, 11, 12, 13,14,15,16};
		System.out.println(findMedianTwoSortArrays(nums1,nums2));

	}

	private static int findMedianTwoSortArrays(int[] nums1, int[] nums2) {
		int size = nums1.length + nums2.length;
		int k = size/2;
		if(size%2==0) {
			int result = (findKth(nums1,nums2,k,0,0)+findKth(nums1,nums2,k+1,0,0))/2;
			return result;
		}else {
			return findKth(nums1,nums2,k+1,0,0);
		}
		
	}
	
	/**a
	 * 数组从小到大排序，求第K个元素
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @param s1 nums1 start pointer
	 * @param s2 nums2 start pointer
	 * @return
	 */
	private static int findKth(int[] nums1, int[] nums2, int k, int s1, int s2) {
		// 此情况为某次拆分后，正好是最后一个元素，即右半部分是空的，且比另一个数组小
		if(s1>=nums1.length) {
			return nums2[s2+k-1];
		}
		if(s2>=nums2.length) {
			return nums1[s1+k-1];
		}
		if(k==1) {
			return Math.min(nums1[s1], nums2[s2]);
		}
	    //从 两个数组各个取一半K元素
		int k1 = s1+(k-k/2-1);
		int k2 = s2+(k-k/2-1);
		
	    // 舍弃小的那部分，或者，其中一个数组不够k/2 +初始长度的时候 舍弃另外一数组的左半部分
		int v1 = k1<nums1.length ? nums1[k1]:Integer.MAX_VALUE;
		int v2 = k2<nums2.length ? nums2[k2]:Integer.MAX_VALUE;
		if(v1<v2) {
			return findKth(nums1, nums2, k-k/2, k1+1, s2);
		}else {
			return findKth(nums1, nums2, k-k/2, s1, k2+1);
		}

	}

}

package leetcode.binarysearch;

/**
 * �����λ���ǽ���������֮���������Ϊ����ʱ��ȡ�м�ļ�Ϊ��λ�����������Ϊż��ʱ��ȡ�м�������ƽ��ֵ��Ϊ��λ����
 * ˼����������������飬���ֱȽϺ���
 * ������ࣺ���������������K����
 * ��չ�㣺�����������KԪ�أ��������򣬲ο�ʵ��find.array.kth.HeapSort
 * �ο���https://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
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
	 * �����С�����������K��Ԫ��
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @param s1 nums1 start pointer
	 * @param s2 nums2 start pointer
	 * @return
	 */
	private static int findKth(int[] nums1, int[] nums2, int k, int s1, int s2) {
		// �����Ϊĳ�β�ֺ����������һ��Ԫ�أ����Ұ벿���ǿյģ��ұ���һ������С
		if(s1>=nums1.length) {
			return nums2[s2+k-1];
		}
		if(s2>=nums2.length) {
			return nums1[s1+k-1];
		}
		if(k==1) {
			return Math.min(nums1[s1], nums2[s2]);
		}
	    //�� �����������ȡһ��KԪ��
		int k1 = s1+(k-k/2-1);
		int k2 = s2+(k-k/2-1);
		
	    // ����С���ǲ��֣����ߣ�����һ�����鲻��k/2 +��ʼ���ȵ�ʱ�� ��������һ�������벿��
		int v1 = k1<nums1.length ? nums1[k1]:Integer.MAX_VALUE;
		int v2 = k2<nums2.length ? nums2[k2]:Integer.MAX_VALUE;
		if(v1<v2) {
			return findKth(nums1, nums2, k-k/2, k1+1, s2);
		}else {
			return findKth(nums1, nums2, k-k/2, s1, k2+1);
		}

	}

}

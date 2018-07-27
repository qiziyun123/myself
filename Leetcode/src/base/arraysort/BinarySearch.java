package base.arraysort;
/**
 * 二分查找算法
 * @author qizy
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int key = 5;
		int[] a = {1,3,4,6,8,13,35,46};
		System.out.println(binarySearchRecursion(a,key,0,a.length-1));
		int[] b = {1,3,4,6,8,13,35,46};
		System.out.println(binarySearchLoop(b,key));

	}

	private static int binarySearchLoop(int[] b, int key) {
		int start=0;
		int end = b.length-1;
		//中间数的下标
        int mid=(start+end)/2;
		while(start<=end) {
			if(b[mid]==key) {
				return mid; //数组中间的数正好是被查找的数直接返回
			}
            else if(b[mid]<key){
                start=mid+1; //若小于被查找的数 则证明被查找的数只可能在数组右部分，则将右部分的数组重新进行一次二分查找
            }else{
                end=mid-1;//同理
            }
            mid=(start+end)/2;
		}
		return -1;
	}

	private static int binarySearchRecursion(int[] a,int key,int start,int end) {
		if(start>end) {
			return -1;
		}
		int m = (end+start)/2;
		if(a[m]==key) {
			return m;
		}else if(a[m]>key) {
			return binarySearchRecursion(a, key, start, m-1);
		}else {
			return binarySearchRecursion(a, key, m+1, end);
		}
		
	}

}

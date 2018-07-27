package leetcode.array;
/**
 * 参考归并排序arraysort包下面的mergesort
 * @author 
 *
 */
public class MergeTwoSortArray {

	public static void main(String[] args) {
		// a数组假设是无限大的，b合并到a，最后大小有m+n,必有舍弃的
		// 跟归并排序最后把剩余合并有区别
		
		int[] a = {1,3,5,7,9,11,13,15};
		int[] b = {2,4,6,8};
		
		a= merge(a,b,a.length,b.length);
		// 假设情况可没法试着运行啊
		for (int i : a) {
			System.out.println(i);
		}

	}

	private static int[] merge(int[] a, int[] b, int m, int n) {
		// 跟归并思路一样，但不一样的是大小是a的长度，所以从后往前来
	       while(m > 0 && n > 0){
	            if(a[m-1] > b[n-1]){
	                a[m+n-1] = a[m-1];
	                m--;
	            }else{
	                a[m+n-1] = b[n-1];
	                n--;
	            }
	        }
	 
	        while(n > 0){
	            a[m+n-1] = b[n-1];
	            n--;
	        }
		return a;
	}

}

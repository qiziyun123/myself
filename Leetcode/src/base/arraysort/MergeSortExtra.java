package base.arraysort;

public class MergeSortExtra {
	/**
	 * 利用归并排序中的分治思想，但又不同，只求最大最小没要求排序
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {4, 3, 1, 7, 6};
		//要求 用最小的比较次数 选出数组最大值和最小值
		
		// 两两交换 3，4  1，7  6 n/2比较次数
		int i =0;
		while(i<a.length-1) {
			if(a[i]>a[i+1]) {
				swap(a,i,i+1);
			}
			i =i+2;
		}
		int max = a[0],min =a[1];
		// 每对第一个比较 n/2
		// 每对第二个比较求最大 n/2
		int length = a.length;
		
		int j =1;
		//3，4  1，7  6
		while(j<a.length-1) {
			min = Math.min(a[j], min);
			max = Math.max(a[j+1], max);
			j=j+2;
		}
		
		if(length%2!=0) {
			int last = a[length-1];
			min = Math.min(last, min);
			max = Math.max(last, max);
		}
		
		System.out.println(min);
		System.out.println(max);
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}

}

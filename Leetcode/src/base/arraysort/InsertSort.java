package base.arraysort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// 3 7 4 9 5 2 6 1
		int[] a = {3,7,4,9,5,2,6,1};
		// 3 4 7 9 5
		insertSort(a);
		System.out.print(Arrays.toString(a));
	}

	private static void insertSort(int[] a) {
		for(int i=1;i<a.length;i++) {
			// 0到i是已排序好的
			int k =i;
			while(k>0) {
				if(a[k-1]>a[k]) {
					swap(a,k-1,k);
				}
				k--;
			}
		}
		
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}
}

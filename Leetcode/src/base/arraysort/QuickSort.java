package base.arraysort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// 注意有相同的
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));
		quicksort(x);
		System.out.println(Arrays.toString(x));
	}

	private static void quicksort(int[] x) {
		quicksort(x, 0, x.length - 1);

	}

	/**
	 * 
	 * @param x
	 * @param s
	 * @param e
	 */
	private static void quicksort(int[] x, int s, int e) {
		if (s < e) {
			int p = partion(x, s, e);
			quicksort(x, s, p - 1);
			quicksort(x, p + 1, e);

		}

	}

	private static int partion(int[] x, int s, int e) {
		int temp = x[s];
		int i = s;
		int j = e;
		while (i < j) {
			while (x[j] >= temp && i < j) {
				j--;
			}
			
			x[i]=x[j];
			while(x[i] <= temp && i<j) {
				i++;
			}
			x[j]=x[i];
		}
		x[i]=temp;
		return i;
	}

}

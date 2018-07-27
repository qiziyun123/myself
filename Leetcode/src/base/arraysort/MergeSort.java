package base.arraysort;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27 };
		mergesort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void mergesort(int[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (right - left > 1) {
			mergesort(a, left, mid);
			mergesort(a, mid + 1, right);
			merge(a, left, mid, right);
		} else {
			// swap
			if (a[right] < a[left]) {
				swap(a, left, right);
			}
		}
		
	}

	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	/*
	 * 
	 */
	private static void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int tindex = 0;
		int i = left;
		int j = mid+1;
		while(i<=mid&&j<=right) {
			if(a[i]<a[j]) {
				temp[tindex]=a[i];
				tindex++;
				i++;
			}else {
				temp[tindex]=a[j];
				j++;
				tindex++;
			}
		}
		// 
		while(j<=right) {
			temp[tindex]=a[j];
			j++;
			tindex++;
		}
		while(i<=mid) {
			temp[tindex]=a[i];
			i++;
			tindex++;
		}
		// ×ÜÍü¼Ç¸³Öµ
		for(int k=0;k<temp.length;k++) {
			a[left+k]=temp[k];
		}
	}

}

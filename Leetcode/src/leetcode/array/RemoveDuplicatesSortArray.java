package leetcode.array;

import java.util.Arrays;

/**
 * 快慢指针法
 * @author qizy
 *
 */
public class RemoveDuplicatesSortArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 2, 3, 3};
		int[] b = removeduplicat(a);
		for (int i : b) {
			System.out.println(i);
		}
	}

	private static int[] removeduplicat(int[] a) {
		int searchIndex=1;
		int writeIndex=0;
		while(searchIndex<=a.length-1) {
			if(a[writeIndex]==a[searchIndex]) {
				searchIndex++;
			}else {
				writeIndex++;
				a[writeIndex] = a[searchIndex];
				searchIndex++;
			}
			
		}
		// 0 writeIndex是我们需要的部分
		int[] b = Arrays.copyOf(a, writeIndex + 1);
		return b;
	}
}

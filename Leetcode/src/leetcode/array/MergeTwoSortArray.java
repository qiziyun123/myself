package leetcode.array;
/**
 * �ο��鲢����arraysort�������mergesort
 * @author 
 *
 */
public class MergeTwoSortArray {

	public static void main(String[] args) {
		// a������������޴�ģ�b�ϲ���a������С��m+n,����������
		// ���鲢��������ʣ��ϲ�������
		
		int[] a = {1,3,5,7,9,11,13,15};
		int[] b = {2,4,6,8};
		
		a= merge(a,b,a.length,b.length);
		// ���������û���������а�
		for (int i : a) {
			System.out.println(i);
		}

	}

	private static int[] merge(int[] a, int[] b, int m, int n) {
		// ���鲢˼·һ��������һ�����Ǵ�С��a�ĳ��ȣ����ԴӺ���ǰ��
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

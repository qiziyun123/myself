package leetcode.matrix;

/**
 * ������ࣺ���ֲ����㷨
 * ���ɵ㣺���ֲ����е㣬������ͨ���±���������Լ�С�������ȡ�࣬������ȫ���ڶ��ֲ����㷨
 * @author qizy
 *
 */
public class Search2DMatrix {

	public static void main(String[] args) {
//		[
//		  [1,   3,  5,  7],
//		  [10, 11, 16, 20],
//		  [23, 30, 34, 50]
//		]
		int[][] a = new int[3][4];
		//init
		int c =1;
		int r =2;
		
		for (int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				a[i][j] = c+r;
				r=r+i;
				c++;
			}
		}
		for (int[] row : a) {
			for (int e : row) {
				System.out.print(e + " ");

			}
			System.out.println();
		}
		int target = 8;
		System.out.println(binarySearch(a,target));
	}

	private static boolean binarySearch(int[][] a, int target) {
		// �пձ����ˣ����ɿ��Ǳ߽�ֵ��ϰ��
		if(a==null || a.length==0 || a[0].length==0) 
            return false;
		int col = a[0].length;
		int end = (a.length*a[0].length)-1;
		int start =0;
		int mid = (start+end)/2;
		while(start<=end) {
			mid = (start+end)/2;
			int midx = mid/col;
			int midy = mid%col;
			// a[x][y] ���Ƕ��ֲ����㷨�е�a[mid]
			if(a[midx][midy]==target) {
				return true;
			}else if(a[midx][midy]>target) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return false;
	}

}

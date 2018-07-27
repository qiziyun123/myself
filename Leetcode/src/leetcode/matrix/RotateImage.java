package leetcode.matrix;

/**
 * 
 * @author qizy
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		// n*n clockwise顺时针旋转
		// Could you do this in-place? 限制了空间
		// 所以不能new新数组
		// 可以想象成环，无论奇偶 ，n为方形矩阵大小，共需要旋转(n-1)/2圈，奇数的情况最后一圈是自己一个值
		// 最终更要的公式 旋转一次 新位置对应原位置的值n[x][y] = n[n-1-y][x]

		// 方形
		int[][] c = new int[3][3];
		int count = 1;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = count;
				count++;
			}
		}
		for (int[] r : c) {
			for (int e : r) {
				System.out.print(e + " ");

			}
			System.out.println();
		}
		System.out.println();
		rotate(c);
		
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int temp = 0;
		for (int i = 0; i <= (n - 1) / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
		
		for (int[] r : matrix) {
			for (int e : r) {
				System.out.print(e + " ");

			}
			System.out.println();
		}
	}
}

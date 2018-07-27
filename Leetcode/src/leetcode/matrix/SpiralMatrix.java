package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// 4��3�� ����ʾ���һ���ǵ������
		// 3��4����������һ��
		// ���ξ���������һ��Ԫ��
		// ��ʼ�� ������ڳ���
		int[][] a = new int[4][3];
		int count = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = count;
				count++;
			}
		}
		for (int[] r : a) {
			for (int e : r) {
				System.out.print(e + " ");

			}
			System.out.println();
		}

		List<Integer> output = spiralorder(a);
		for (Integer integer : output) {
			System.out.print(integer + ",");
		}
		System.out.println();
		// �����ڿ�
		int[][] b = new int[3][4];
		count = 1;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = count;
				count++;
			}
		}
		for (int[] r : b) {
			for (int e : r) {
				System.out.print(e + " ");

			}
			System.out.println();
		}
		
		List<Integer> outputb = spiralorder(b);
		for (Integer integer : outputb) {
			System.out.print(integer + ",");
		}
		System.out.println();
		// ����
		int[][] c = new int[3][3];
		count = 1;
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
		
		List<Integer> outputc = spiralorder(c);
		for (Integer integer : outputc) {
			System.out.print(integer + ",");
		}
	}

	private static List<Integer> spiralorder(int[][] a) {
		List<Integer> output = new ArrayList<>();
		// ��
		int left = 0;
		// ��
		int right = a[0].length-1;
		// ��
		int up = 0;
		// ��
		int down = a.length-1;

		while (left <= right && up <= down) {
			// ֻʣһ��
			if (left == right) {
				for (int j = up; j <= down; j++) {
					output.add(a[j][left]);
				}
				break;
			}
			// ֻʣһ��
			if(up==down) {
				for (int i = left; i <= right; i++) {
					output.add(a[up][i]);
				}
				break;
			}
			
			for(int i = left;i<=right;i++) {
				output.add(a[up][i]);
			}
			up++;
			
			for(int i = up;i<=down;i++) {
				output.add(a[i][right]);
			}
			right--;
			
			for(int i=right;i>=left;i--) {
				output.add(a[down][i]);
			}
			down--;
			
			for(int i=down;i>=up;i--) {
				output.add(a[i][left]);
			}
			left++;
		}
		return output;
	}

}

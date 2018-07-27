package leetcode.matrix;
/**
 * 难点在于考虑空间
 * @author qizy
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		//int[][]matrix = new int[5][6];
		// init
	// int[] row 记录各行的信息，有0则0，全没0 则1	
//	  c0=0	  c1=1	  c2=1	  c3=1	  c4=0
//r0=0	4		5		2		1		0
//		
//r1=0	0		2		4		5		9
//		
//r2=1	1		2		3		4		5
//		
//r3=1	1		1		1		1		1
//		
//r4=1	1		2		5		7		4

	}

	public static void setZeroes(int[][] matrix) {
        int noZeroRawIndex = -1;
        int rawLength = matrix.length;
        int colLength = matrix[0].length;
        for (int i = 0; i < rawLength; i++) {
            int index = 0;
            for (index = 0; index < colLength; index++) {
                if (matrix[i][index] == 0) {
                    break;
                }
            }
            if (index == colLength) {
                noZeroRawIndex = i;
                break;
            }
        }

        if (noZeroRawIndex == -1) {
            for (int i = 0; i < rawLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        } else {
            for (int i = 0; i < rawLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[noZeroRawIndex][j] = 0;
                    }
                }
            }

            for (int i = 0; i < rawLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (i == noZeroRawIndex) {
                        continue;
                    }
                    if (matrix[i][j] == 0) {
                        for (int j2 = 0; j2 < colLength; j2++) {
                            matrix[i][j2] = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < colLength; i++) {
                if (matrix[noZeroRawIndex][i] == 0) {
                    for (int j = 0; j < rawLength; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
	
}

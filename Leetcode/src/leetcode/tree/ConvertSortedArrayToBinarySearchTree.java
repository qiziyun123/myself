package leetcode.tree;

import base.datastruct.tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8};
//		int[] b= {1,2,3,4,5,6,7,8,9};
//				 4
//			2		   7
//		1		3  6       8
				
//				 5
//			3		  7
//		2		4 6		   8
//	1							9
		// 其实有多种可能，如果都求出来这题就难了
		TreeNode ra = sortedArrayToBst(a);
	}
	
	private static TreeNode sortedArrayToBst(int[] num) {
		if (num.length == 0)
			return null;
		// 二分查找的基本写法
		return sortedArrayToBst(num, 0, num.length - 1);
	}
 
	private static TreeNode sortedArrayToBst(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBst(num, start, mid - 1);
		root.right = sortedArrayToBst(num, mid + 1, end);
 
		return root;
	}

}

package leetcode.tree;

import base.datastruct.tree.TreeNode;

/**
 * valid if a tree is balaned比较基础的题
 * 
 * @author qizy
 *
 */
public class BalancedBinarySearchTree {

	public static void main(String[] args) {
//				5
//		3				6
//  1		4		nvl		9
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		boolean y = isBalanced(root);
		System.out.println(y);
	}

	private static boolean isBalanced(TreeNode root) {
		if(root==null) {
			// 空也是？我概念错了,度是0
			return true;
		}
		if(determine(root)==-1) {
			return false;
		}else {
			return true;
		}
	}

	private static int determine(TreeNode root) {
		if(root==null) {
			return 0;
		}else {
			int lh =determine(root.left);
			int rh = determine(root.right);
			if(lh<0||rh<0) {
				return -1;
			}else if(Math.abs(lh-rh)>1){
				return -1;
			}else {
				return Math.max(lh, rh)+1;
			}
		}
	}

}

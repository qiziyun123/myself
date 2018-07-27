package leetcode.tree;

import base.datastruct.tree.TreeNode;

public class ValidBinarySearchTree {
	//×óÓÒ×ÓÊ÷¶¼ÊÇµÝ¹é
	
	public boolean isValid(TreeNode root) {
		if(root==null) {
			return false;
		}
		if(root.left!=null&& root.left.val> root.val) {
			return false;
		}
		if(root.right!=null&& root.right.val< root.val) {
			return false;
		}
		return isValid(root.left)&&isValid(root.right);
	}
}

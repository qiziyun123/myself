package leetcode.tree;

import base.datastruct.tree.TreeNode;

public class ConstructTheBinaryTree {

	public static void main(String[] args) {
		// 通过中序后序构造二叉树
		int[] inOrder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postOrder = { 4, 5, 2, 6, 7, 8, 3, 1 };
		TreeNode root = buildTree(inOrder, postOrder);
		System.out.println();
	}

	public static TreeNode buildTree(int[] inOrder, int[] postOrder) {
		// recurions
		int instart = 0;
		int inend = inOrder.length - 1;
		int poststart = 0;
		int postend = postOrder.length-1;
		
		return buildTree(inOrder,postOrder,instart,inend,poststart,postend);
	}

	private static TreeNode buildTree(int[] inOrder, int[] postOrder, int instart, int inend, int poststart,
			int postend) {
		if (instart > inend || poststart > postend)
			return null;
		int rootV = postOrder[postend];
		TreeNode root = new TreeNode(rootV);
		// { 4, 2, 5, 1, 6, 7, 3, 8 }
		// { 4, 5, 2, 6, 7, 8, 3, 1 }
		int k=0;
		for(int i=instart;i<=inend;i++ ) {
			if(inOrder[i]==rootV) {
				k=i;
				break;
			}
		}
		root.left = buildTree(inOrder,postOrder,instart,k-1,poststart,poststart + k - (instart + 1));
		root.right =buildTree(inOrder,postOrder,k+1,inend,poststart + k- instart,postend - 1);
		return root;
	}

}

package leetcode.tree;

import java.util.Stack;

import base.datastruct.tree.TreeNode;

/**
 * category: DFS 与最小深度正相反，递归和回溯法求解，中止搜索的条件就是没有任何子树
 * @author qizy
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
//	 	 1
//      / \
//     2   5
//    / \   
//   3   4   
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		
		System.out.println(maxdepthOfTree(root));

	}

	/*
	 * 非递归
	 */
	private static int maxdepthOfTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		// 当前最大值
		int max=1;
		// different between preorder to this problem
		// we don't have to traversal all the path,if a node only has one leaf,
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<Integer> num = new Stack<Integer>();
		s.push(root);
		num.push(1);
		while(!s.isEmpty()) {
			TreeNode temp = s.pop();
			int tv = num.pop();
			max = Math.max(max, tv);
			if(temp.right!=null) {
				s.push(temp.right);
				num.push(tv+1);
			}
			if(temp.left!=null) {
				s.push(temp.left);
				num.push(tv+1);
			}
		}
		return max;
	}

}

package leetcode.tree;

import java.util.Stack;

import base.datastruct.tree.TreeNode;

/**
 * category: DFS ����С������෴���ݹ�ͻ��ݷ���⣬��ֹ��������������û���κ�����
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
	 * �ǵݹ�
	 */
	private static int maxdepthOfTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		// ��ǰ���ֵ
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

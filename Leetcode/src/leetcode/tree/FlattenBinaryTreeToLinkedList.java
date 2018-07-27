package leetcode.tree;

import java.util.Stack;

import base.datastruct.tree.TraversalTreeUtil;
import base.datastruct.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
//		 	 1
//	        / \
//	       2   5
//	      / \   \
//	     3   4   6
		
//		 	1
//		    \
//		     2
//		      \
//		       3
//		        \
//		         4
//		          \
//		           5
//		            \
//		             6
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		// û������,���Ƕ��������Ƕ��������
		// ת������,����������ṹ,��ȫ�����������Ļ���
		// ��ϸ�۲�,Ҫ�����ɵ����ı���˳����ԭ������ǰ�����
		
		TreeNode result = flatern(root);
		TraversalTreeUtil.PreorderLoop(result);
	}

	private static TreeNode flatern(TreeNode root) {
//		flatten it to a linked list in-place �����ö���Ŀռ�
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		while(!s.isEmpty()||p!=null) {
			if(p.right!=null) {
				s.push(p.right);
				
			}
			if(p.left!=null) {
				p.right = p.left;
				p.left =null;
			}else if(!s.empty()){
				TreeNode temp = s.pop();
                p.right=temp;
			}
			p= p.right;
		}
		return root;
	}

}

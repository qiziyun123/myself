package leetcode.tree;

import base.datastruct.tree.TraversalTreeUtil;
import base.datastruct.tree.TreeNode;

/**
 * ����:���Ĳ���,�ڻ���base������,ֱ�Ӳο�����
 * ���������3��������,���ϲ�α���
 * @author qizy
 *
 */
public class BinaryTreeTraversal {

	public static void main(String[] args) {

//					5
//			3				6
//		1		4				9
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(9);
		// �ݹ�
//		TraversalTreeUtil.PreorderRecursion(root);
//		System.out.println();
//		TraversalTreeUtil.InorderRecursion(root);
//		System.out.println();
//		TraversalTreeUtil.PostorderRecursion(root);
//		System.out.println();
		// �ǵݹ���ջ
		TraversalTreeUtil.LevelorderLoop(root);
		TraversalTreeUtil.PreorderLoop(root);
		System.out.println();
		TraversalTreeUtil.InorderLoop(root);
		System.out.println();
		TraversalTreeUtil.PostorderLoop(root);
		System.out.println();
		
	}

}

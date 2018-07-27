package leetcode.tree;

import java.util.LinkedList;

import base.datastruct.tree.TreeNode;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
//	 	   1
//        / \
//       2   5
//      / \   
//     3   4   
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		
		System.out.println(mindepthOfTree(root));

	}

	private static int mindepthOfTree(TreeNode root) {
		// 层次遍历是最小的遍历情况  树各种遍历参考 TraversalTreeUtil
		if(root==null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> countqueue = new LinkedList<Integer>();
		queue.add(root);
		countqueue.add(1);
		while(queue.isEmpty()==false) {
			// queue先进先出，linkedlist remove方法就是取队列最首先放入的
			TreeNode temp = queue.remove();
			int tempV = countqueue.remove();
			if(temp.left==null&&temp.right==null) {
				// leaf node
				return tempV;
			}
			if(temp.left!=null) {
				queue.add(temp.left);
				countqueue.add(tempV+1);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
				countqueue.add(tempV+1);
			}
				
		}
		return 0;
	}

}

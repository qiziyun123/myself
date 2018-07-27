package leetcode.tree;

import java.util.LinkedList;

import base.datastruct.tree.TreeNode;

public class PathSum {

	public static void main(String[] args) {
//	      	 5
//          / \
//         4   8
//        /   / \
//       11  13  4
//      /  \      \
//     7    2      1
		// 两个队列,二叉树层次遍历使用队列都应该很熟悉了,不熟悉可参考TraversalTreeUtil.LevelorderLoop
		
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.val);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
 
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }
 
        return false;
    }
}

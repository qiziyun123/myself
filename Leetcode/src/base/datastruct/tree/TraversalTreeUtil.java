package base.datastruct.tree;

import java.util.LinkedList;
import java.util.Stack;

public class TraversalTreeUtil {
	// ตÝน้
	public static void PreorderRecursion(TreeNode root) {
		System.out.print(root.val + " ");
		if (root.left != null) {
			PreorderRecursion(root.left);

		}
		if (root.right != null) {
			PreorderRecursion(root.right);
		}
	}

	public static void InorderRecursion(TreeNode root) {
		if (root.left != null) {
			InorderRecursion(root.left);

		}
		System.out.print(root.val + " ");
		if (root.right != null) {
			InorderRecursion(root.right);
		}
	}

	public static void PostorderRecursion(TreeNode root) {
		if (root.left != null) {
			PostorderRecursion(root.left);

		}
		if (root.right != null) {
			PostorderRecursion(root.right);
		}
		System.out.print(root.val + " ");
	}

	public static void PreorderLoop(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.empty()) {
			TreeNode cur = s.pop();
			System.out.print(cur.val + " ");
			if (cur.right != null) {
				s.push(cur.right);
			}
			if (cur.left != null) {
				s.push(cur.left);
			}

		}
	}

	public static void InorderLoop(TreeNode root) {
//				5
//		3				6
// 1			4					9
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		while (!s.isEmpty() || p != null) {
			if (p != null) {
				s.push(p);
				p = p.left;
			} else {
				TreeNode t = s.pop();
				System.out.print(t.val + " ");
				p = t.right;
			}
		}
	}

	public static void PostorderLoop(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while(s.isEmpty()==false) {
			TreeNode c = s.peek();
			if(c.left==null&&c.right==null) {
				System.out.print(s.pop().val + " ");
			}else {
				if(c.right!=null) {
	                s.push(c.right);
	                c.right = null;
	            }
	 
	            if(c.left!=null) {
	                s.push(c.left);
	                c.left = null;
	            }
			}
			
			
		}

	}
	
	public static void LevelorderLoop(TreeNode root) {
		 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);
		 while(queue.isEmpty()==false) {
			 TreeNode temp = queue.poll();
			 System.out.print(temp.val+ "   ");
			 queue.add(temp.left);
			 queue.add(temp.right);
		 }
		 
	}
}

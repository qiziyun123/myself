package leetcode.tree;

import base.datastruct.tree.TreeNode;
import leetcode.linkedlist.ListNode;

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// 这题比刚才的难一点，链表不知道总长度，如果遍历一遍求出总长度，安装排序数组的方式一样处理，效率就低了
		// 好多这种答案参考意义不大，还是靠快慢指针找中点更优化一些，但快慢指针的难点在于中点找到后如何分割两部分链表，还给靠递归啊
		
		//{1,2,3,4,5,6,7,8};

		System.out.println();
	}

	private static TreeNode convertListToBst(ListNode l) {
		ListNode[] nodes = findMidAndTailNode(l,null);
		ListNode mid = nodes[0];
		ListNode tail = nodes[1];
		TreeNode root = new TreeNode(mid.val);
		
		root.left = convertListToBst(l,mid);
		root.right = convertListToBst(mid.next,tail.next);
		
		return root;
	}

	/**
	 * 
	 * @param start
	 * @param endnext 遍历结束节点的下一个节点
	 * @return
	 */
	private static TreeNode convertListToBst(ListNode start, ListNode endnext) {
		//{1,2,3,4,5,6,7,8};
		ListNode[] nodes = findMidAndTailNode(start,endnext);
		ListNode mid = nodes[0];
		ListNode tail = nodes[1];
		if(mid==tail) {
			return new TreeNode(mid.val);
		}
		TreeNode root = new TreeNode(mid.val);
		root.left = convertListToBst(start,mid);
		root.right = convertListToBst(mid.next,tail);
		return root;
	}

	private static ListNode[] findMidAndTailNode(ListNode start, ListNode endnext) {
		ListNode s = start;
		ListNode f = start;
		ListNode[] r = new ListNode[2];
		if(start==endnext) {
			// 中点
			r[0]=start;
			// 尾
			r[1]=start;
		}
		while(f.next!=endnext) {
			f = f.next;
			if(f.next!=endnext) {
				f = f.next;
				s = s.next;
			}else {
				break;
			}
		}
		
		// 中点
		r[0]=s;
		// 尾
		r[1]=f;
		return r;
	}

}

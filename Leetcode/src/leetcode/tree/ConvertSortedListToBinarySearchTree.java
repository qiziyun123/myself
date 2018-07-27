package leetcode.tree;

import base.datastruct.tree.TreeNode;
import leetcode.linkedlist.ListNode;

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// ����ȸղŵ���һ�㣬����֪���ܳ��ȣ��������һ������ܳ��ȣ���װ��������ķ�ʽһ������Ч�ʾ͵���
		// �ö����ִ𰸲ο����岻�󣬻��ǿ�����ָ�����е���Ż�һЩ��������ָ����ѵ������е��ҵ�����ηָ������������������ݹ鰡
		
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
	 * @param endnext ���������ڵ����һ���ڵ�
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
			// �е�
			r[0]=start;
			// β
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
		
		// �е�
		r[0]=s;
		// β
		r[1]=f;
		return r;
	}

}

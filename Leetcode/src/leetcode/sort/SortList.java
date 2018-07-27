package leetcode.sort;

import leetcode.linkedlist.ListNode;

/**
 * 归类：没有归为链表，因为实际想考察的是排序 in O(n log n) time，时间复杂度定义好了 using constant space
 * complexity. 空间复杂度用固定的空间 基本排序满足此要求的有
 * 归并和堆排序，而仔细想下，空间是固定的，也就是链表本身，所以满足条件的排序就是归并了 所以这题，一是考察归并的思想，二是考察合并链表，后面就so easy
 * 
 * @author qizy
 *
 */
public class SortList {

	public static void main(String[] args) {
		// 数组的归并排序 base.arraysort有例子
		// 解决此题需要先会的基本操作：归并排序逻辑，递归，快慢指针求中点，合并链表，以上不会先别看此题
		// 4 3 1 7 6
		ListNode l = new ListNode(4);
		l.next = new ListNode(3);
		l.next.next = new ListNode(1);
		l.next.next.next = new ListNode(7);
		l.next.next.next.next = new ListNode(6);
		l = sortList(l);
		l.print();
	}

	private static ListNode sortList(ListNode head) {
		// 终止递归条件，也就是就一个或者2个节点
		if (head == null || head.next == null) {
			return head;
		}
		// 4 3 (1) 7 6
		ListNode p1 = head;
		ListNode firstEnd = getFirstEnd(head);
		ListNode p2 = firstEnd.next;
		// this is the key
		firstEnd.next = null;

		p1 = sortList(p1);
		p2 = sortList(p2);

		return merge(p1, p2);
		// 跟数组的归并写法一样，就是求中点和合并不一样
	}

	// 求中点偶数的话，中点在左边，认为是分治的末尾节点
	private static ListNode getFirstEnd(ListNode head) {
		// 4 3 1 7 6
		ListNode s = head;
		ListNode f = head;
		while (s != null && f != null) {
			if (f.next == null ||
					// 奇数
					f.next.next == null) {// 偶数
				return s;
			}

			s = s.next;
			f = f.next.next;
		}

		return head;
	}


	private static ListNode merge(ListNode n1, ListNode n2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		ListNode p1 = n1;
		ListNode p2 = n2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}

			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return head.next;
	}
}

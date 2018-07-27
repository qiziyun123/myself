package leetcode.sort;

import leetcode.linkedlist.ListNode;

public class SortLinkedListUsingInsertionSort {

	/**
	 * base.arraysort.InsertSort 数组插入排序，基本思路，供参考，只是换了链表而已，其实反而更简单了，但是给是双链表
	 * 
	 * @param
	 */
	public static void main(String[] args) {
		ListNode l = new ListNode(4);
		l.next = new ListNode(3);
		l.next.next = new ListNode(1);
		l.next.next.next = new ListNode(7);
		l.next.next.next.next = new ListNode(6);
		l = sortInsertList(l);
		l.print();

	}

	private static ListNode sortInsertList(ListNode head) {
		// 难点是单链表,需要一个指针记录前序节点
		ListNode fakeNode = new ListNode(-1);
		fakeNode.next = head;
		if (head == null)
			return null;
		ListNode cur = head.next;// 从第二个节点开始遍历
		ListNode pre = head;// 排好序的最后一个节点
		while (cur != null) {
			if (cur.val < pre.val) {
				ListNode nextNode = cur.next;// 保存下一个需要遍历的节点

				// 寻找插入的合适位置
				ListNode aleadySort = fakeNode.next;
				ListNode temp = fakeNode;// 记录aleadySort前面一个节点
				while (cur.val > aleadySort.val && aleadySort != pre) {
					temp = aleadySort;
					aleadySort = aleadySort.next;
				}
				// 进行插入
				temp.next = cur;
				cur.next = aleadySort;
				pre.next = nextNode;
				// 继续遍历下一个节点
				cur = nextNode;
			} else {
				pre = cur;
				cur = cur.next;
			}

		}

		return fakeNode.next;
	}

}

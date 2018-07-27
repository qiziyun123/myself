package leetcode.sort;

import leetcode.linkedlist.ListNode;

public class SortLinkedListUsingInsertionSort {

	/**
	 * base.arraysort.InsertSort ����������򣬻���˼·�����ο���ֻ�ǻ���������ѣ���ʵ���������ˣ����Ǹ���˫����
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
		// �ѵ��ǵ�����,��Ҫһ��ָ���¼ǰ��ڵ�
		ListNode fakeNode = new ListNode(-1);
		fakeNode.next = head;
		if (head == null)
			return null;
		ListNode cur = head.next;// �ӵڶ����ڵ㿪ʼ����
		ListNode pre = head;// �ź�������һ���ڵ�
		while (cur != null) {
			if (cur.val < pre.val) {
				ListNode nextNode = cur.next;// ������һ����Ҫ�����Ľڵ�

				// Ѱ�Ҳ���ĺ���λ��
				ListNode aleadySort = fakeNode.next;
				ListNode temp = fakeNode;// ��¼aleadySortǰ��һ���ڵ�
				while (cur.val > aleadySort.val && aleadySort != pre) {
					temp = aleadySort;
					aleadySort = aleadySort.next;
				}
				// ���в���
				temp.next = cur;
				cur.next = aleadySort;
				pre.next = nextNode;
				// ����������һ���ڵ�
				cur = nextNode;
			} else {
				pre = cur;
				cur = cur.next;
			}

		}

		return fakeNode.next;
	}

}

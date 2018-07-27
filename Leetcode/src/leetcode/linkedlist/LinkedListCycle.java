package leetcode.linkedlist;

public class LinkedListCycle {

	public static void main(String[] args) {
		// init
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
//		l.next.next.next.next = l.next;
		// 别遍历 无限 stackoverflow
		// l.print();
		boolean isCycle = hasCycle(l);
		System.out.println(isCycle);

		// 求两个链表是否相交,转换问题,将其中一个链表首尾相连,就又变成是否有环的问题了
	}

	private static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}

		return false;
	}

}

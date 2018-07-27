package base.datastruct.linkedlist;

/*
 * 快慢指针找中点（注意奇数偶数）
 */
public class FindMidListNode {
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
//		l.next.next.next.next = new ListNode(5);
		l.print();
		ListNode mid = findMid(l);
		System.out.println();
		System.out.println(mid.val);
	}

	private static ListNode findMid(ListNode l) {
		// 一般偶数个数取后边的
		ListNode slow = l;
		ListNode fast = l;
		while (fast != null && fast.next != null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
}

package base.datastruct.linkedlist;

/*
 * ����ָ�����е㣨ע������ż����
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
		// һ��ż������ȡ��ߵ�
		ListNode slow = l;
		ListNode fast = l;
		while (fast != null && fast.next != null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
}

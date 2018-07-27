package base.datastruct.linkedlist;

/**
 * @author qizy
 *
 */
public class FindbackWardN {

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		l.print();
		// 如倒数第二个
		ListNode n = backWard(l, 1);
		System.out.println();
		System.out.println(n.val);
	}

	private static ListNode backWard(ListNode l, int n) {
		ListNode slow = l;
		ListNode fast = l;
		while(fast!=null&&fast.next!=null&&n>1) {
			n--;
			fast=fast.next;
		}
		while(fast.next!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		return slow;
	}

}

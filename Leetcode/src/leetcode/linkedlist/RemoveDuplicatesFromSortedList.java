package leetcode.linkedlist;

public class RemoveDuplicatesFromSortedList {

//	Given 1->1->2, return 1->2.
//			Given 1->1->2->3->3, return 1->2->3.
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(1);
		l.next.next = new ListNode(2);
		l.next.next.next = new ListNode(3);
		l.next.next.next.next = new ListNode(3);
		l.print();
		
		l =removeDuplicate(l);
		l.print();
	}

	private static ListNode removeDuplicate(ListNode head) {
		ListNode prev = head;
		ListNode p = head.next;
		//1->1->2->3->3
		while(p!=null) {
			if(p.val==prev.val) {
				prev.next = p.next;
			}else {
				prev = prev.next;
			}
			p = p.next;
		}
		return head;
	}
}

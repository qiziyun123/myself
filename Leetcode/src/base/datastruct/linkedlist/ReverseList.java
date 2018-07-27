package base.datastruct.linkedlist;


public class ReverseList {

	public static void main(String[] args) {
		// init
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		l.print();
		l = reverse(l);
		System.out.println();
		l.print();
	}

	private static ListNode reverse(ListNode head) {
		ListNode p = head;
		
		ListNode q = head.next;
		head.next=null;
		while(q!=null) {
			ListNode r = q.next;
			// 反转
			q.next = p;
			// 指针移动
			p=q;
			q=r;
		}
		head =p;
		return head;
	}

}

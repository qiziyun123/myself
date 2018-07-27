package leetcode.linkedlist;

public class PartionList {

	public static void main(String[] args) {
		// For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
		// 1 3 4 6 7
		ListNode l = new ListNode(1);
		l.next = new ListNode(4);
		l.next.next = new ListNode(2);
		l.next.next.next = new ListNode(7);
		l.next.next.next.next = new ListNode(6);
		int p = 5;
		l = partition(l,p);
	}

	private static ListNode partition(ListNode head, int partion) {
        if(head == null) return null;
 
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;
 
        ListNode p1 = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
 
        while(p1 != null){
            if(p1.val < partion){
                p1 = p1.next;
                prev = prev.next;
            }else{
 
                p2.next = p1;
                prev.next = p1.next;
 
                p1 = prev.next;
                p2 = p2.next;
            } 
        }
 
        p2.next = null;
 
        prev.next = fakeHead2.next;
 
        return fakeHead1.next;
	}
}

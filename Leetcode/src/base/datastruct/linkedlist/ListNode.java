package base.datastruct.linkedlist;


public class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}

	public void print() {
		System.out.print(this.val + " --> ");
		
		if(this.next!=null) {
			this.next.print();
		}
		
	}
}

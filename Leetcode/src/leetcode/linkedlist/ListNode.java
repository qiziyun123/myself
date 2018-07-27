package leetcode.linkedlist;

public class ListNode {
	public int val;
	public ListNode next;
 
	public ListNode(int x) {
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

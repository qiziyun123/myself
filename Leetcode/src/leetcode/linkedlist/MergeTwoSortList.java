package leetcode.linkedlist;

public class MergeTwoSortList {

	public static void main(String[] args) {
		// 1 3 4 6 7
		// 2 3 5 8
		ListNode l = new ListNode(1);
		l.next = new ListNode(3);
		l.next.next = new ListNode(4);
		l.next.next.next = new ListNode(6);
		l.next.next.next.next = new ListNode(7);

		ListNode second = new ListNode(2);
		second.next = new ListNode(3);
		second.next.next = new ListNode(5);
		second.next.next.next = new ListNode(8);

		ListNode result = mergeTwoSortList(l, second);
		result.print();
	}

	private static ListNode mergeTwoSortList(ListNode f, ListNode s) {
		// 有地方叫虚拟节点法,有点形象
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		while(f!=null||s!=null) {
			if(f!=null&&s!=null) {
				if(f.val<s.val) {
					p.next =f;
					p=p.next;
					f=f.next;
				}else {
					p.next =s;
					p=p.next;
					s=s.next;
				}
			}else if(f==null) {
				p.next = s;
				break;
			}else if(s==null) {
				p.next = f;
				break;
			}
		}
		return head.next;
	}

}

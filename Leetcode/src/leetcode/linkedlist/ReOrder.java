package leetcode.linkedlist;

/**
 * 	归类：链表操作，请反复练习快慢指针，反转链表等操作，后面的就很容易了 反转操作
 * 	base.datastruct.linkedlist.ReverseList
 * 	求中点操作base.datastruct.linkedlist.FindMidListNode
 * 
 * @author qizy
 *
 */
public class ReOrder {

	public static void main(String[] args) {
		// For example, given {1,2,3,4}, reorder it to {1,4,2,3}.
		// You must do this in-place without altering the nodes' values.
		// 就是首尾相互交换位置但不能用额外的空间,链表问题,没有太复杂的算法,但很考察编码基本功

		// init
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		// leetcode没有定义ListNode遍历,
		// 这里自己定义一个.
		// 为什么不定义其他添加等方法,因为leetcode就想考你链表操作,刷一遍就明白了人家想考察什么了
		reorder(l);
		System.out.println();
		l.print();
	}

	/**
	 * 不用额外空间
	 * 
	 * @param l
	 */
	private static void reorder(ListNode l) {
		// 没有定义链表长度的方法,但全部遍历效率太低了
		// 先求中点，后面的部分反转，在合并
		// 此题不难挺有代表性，考察了链表的遍历，反转，查找，合并
		ListNode mid = findMid(l);
		System.out.println(mid.val);
		ListNode second =reverse(mid);
		// merge the two list 无论奇数偶数 右边一定更长
		ListNode p1 = l;
		p1.print();
		System.out.println();
		ListNode p2 = second;
		p2.print();
		System.out.println();

		while(p2!=null) {
			ListNode t1 = p1.next;
			ListNode t2 = p2.next;
			p1.next = p2;
			p2.next = t1;
			p1=t1;
			p2=t2;
		}
		
	}

	private static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		head.next=null;
		while(q!=null) {
			ListNode r = q.next;
			q.next=p;
			p = q;
			q = r;
		}
		
		return p;
	}

	private static ListNode findMid(ListNode l) {
		ListNode s=l;
		ListNode f=l;
		ListNode p=l;
		while(f!=null&&f.next!=null) {
			f=f.next.next;
			p=s;
			s=s.next;
		}
		p.next=null;
		return s;
	}

}

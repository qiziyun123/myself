package leetcode.linkedlist;

/**
 * 	���ࣺ����������뷴����ϰ����ָ�룬��ת����Ȳ���������ľͺ������� ��ת����
 * 	base.datastruct.linkedlist.ReverseList
 * 	���е����base.datastruct.linkedlist.FindMidListNode
 * 
 * @author qizy
 *
 */
public class ReOrder {

	public static void main(String[] args) {
		// For example, given {1,2,3,4}, reorder it to {1,4,2,3}.
		// You must do this in-place without altering the nodes' values.
		// ������β�໥����λ�õ������ö���Ŀռ�,��������,û��̫���ӵ��㷨,���ܿ�����������

		// init
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		// leetcodeû�ж���ListNode����,
		// �����Լ�����һ��.
		// Ϊʲô������������ӵȷ���,��Ϊleetcode���뿼���������,ˢһ����������˼��뿼��ʲô��
		reorder(l);
		System.out.println();
		l.print();
	}

	/**
	 * ���ö���ռ�
	 * 
	 * @param l
	 */
	private static void reorder(ListNode l) {
		// û�ж��������ȵķ���,��ȫ������Ч��̫����
		// �����е㣬����Ĳ��ַ�ת���ںϲ�
		// ���ⲻ��ͦ�д����ԣ�����������ı�������ת�����ң��ϲ�
		ListNode mid = findMid(l);
		System.out.println(mid.val);
		ListNode second =reverse(mid);
		// merge the two list ��������ż�� �ұ�һ������
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

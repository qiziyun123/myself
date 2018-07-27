package leetcode.sort;

import leetcode.linkedlist.ListNode;

/**
 * ���ࣺû�й�Ϊ������Ϊʵ���뿼��������� in O(n log n) time��ʱ�临�Ӷȶ������ using constant space
 * complexity. �ռ临�Ӷ��ù̶��Ŀռ� �������������Ҫ�����
 * �鲢�Ͷ����򣬶���ϸ���£��ռ��ǹ̶��ģ�Ҳ������������������������������ǹ鲢�� �������⣬һ�ǿ���鲢��˼�룬���ǿ���ϲ����������so easy
 * 
 * @author qizy
 *
 */
public class SortList {

	public static void main(String[] args) {
		// ����Ĺ鲢���� base.arraysort������
		// ���������Ҫ�Ȼ�Ļ����������鲢�����߼����ݹ飬����ָ�����е㣬�ϲ��������ϲ����ȱ𿴴���
		// 4 3 1 7 6
		ListNode l = new ListNode(4);
		l.next = new ListNode(3);
		l.next.next = new ListNode(1);
		l.next.next.next = new ListNode(7);
		l.next.next.next.next = new ListNode(6);
		l = sortList(l);
		l.print();
	}

	private static ListNode sortList(ListNode head) {
		// ��ֹ�ݹ�������Ҳ���Ǿ�һ������2���ڵ�
		if (head == null || head.next == null) {
			return head;
		}
		// 4 3 (1) 7 6
		ListNode p1 = head;
		ListNode firstEnd = getFirstEnd(head);
		ListNode p2 = firstEnd.next;
		// this is the key
		firstEnd.next = null;

		p1 = sortList(p1);
		p2 = sortList(p2);

		return merge(p1, p2);
		// ������Ĺ鲢д��һ�����������е�ͺϲ���һ��
	}

	// ���е�ż���Ļ����е�����ߣ���Ϊ�Ƿ��ε�ĩβ�ڵ�
	private static ListNode getFirstEnd(ListNode head) {
		// 4 3 1 7 6
		ListNode s = head;
		ListNode f = head;
		while (s != null && f != null) {
			if (f.next == null ||
					// ����
					f.next.next == null) {// ż��
				return s;
			}

			s = s.next;
			f = f.next.next;
		}

		return head;
	}


	private static ListNode merge(ListNode n1, ListNode n2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		ListNode p1 = n1;
		ListNode p2 = n2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}

			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return head.next;
	}
}

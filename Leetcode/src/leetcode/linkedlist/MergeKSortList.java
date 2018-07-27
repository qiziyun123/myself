package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 补充:用PriorityQueue解决选择最小的K个数问题,类似求findKth问题,PriorityQueue就是堆排序
 * @author qizy 
 *
 */
public class MergeKSortList {

	public static void main(String[] args) {
		// 1 3 4 6 7
		ListNode l = new ListNode(1);
		l.next = new ListNode(3);
		l.next.next = new ListNode(4);
		l.next.next.next = new ListNode(6);
		l.next.next.next.next = new ListNode(7);
		// 2 3 5 8
		ListNode second = new ListNode(2);
		second.next = new ListNode(3);
		second.next.next = new ListNode(5);
		second.next.next.next = new ListNode(8);
		// 4 6 7 9
		ListNode t = new ListNode(4);
		t.next = new ListNode(3);
		t.next.next = new ListNode(5);
		t.next.next.next = new ListNode(8);
		
		ListNode[] arr = {l,t,second};

		ListNode result = mergeKLists(arr);
	}
	
	

	private static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
	        public int compare(ListNode l1, ListNode l2){
	            return l1.val - l2.val;
	        }
	    });
		// 优先队列插入和删除都 会调整,跟堆调整一个意思
		ListNode head = new ListNode(0);
	    ListNode p = head;
		for(ListNode list: lists){
	        if(list!=null)
	        	
	            queue.offer(list);
	    }
		// 巧妙的遍历
		while(!queue.isEmpty()){
	        ListNode n = queue.poll();
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }
		// debug一下队列的结构
		return head.next;
	} 
 
}

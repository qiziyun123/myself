package leetcode.linkedlist;

/**
 * leetcode网站帮你定义好了链表,为了方便放入该包下面了
 * 
 * @author qizy
 *
 */
public class AddTwoNum {

	public static void main(String[] args) {
//		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//		Output: 7 -> 0 -> 8

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry =0;
		
        // 链表题中,经常用一个指针指向结果指针,这个编码技巧很重要,因为不这样,遍历以后,无法找到头结点.平时Java封装的linked list别混淆
        // 人家是想考你 基本数据结构
        ListNode p = new ListNode(0);
        while(l1!=null||l2!=null) {
        	if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
 
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            p = p.next;
            carry /= 10;
        }
        if(carry==1) 
            p.next=new ListNode(1);
        return p.next;
	}


}

package leetcode.linkedlist;

/**
 * leetcode��վ���㶨���������,Ϊ�˷������ð�������
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
		
        // ��������,������һ��ָ��ָ����ָ��,������뼼�ɺ���Ҫ,��Ϊ������,�����Ժ�,�޷��ҵ�ͷ���.ƽʱJava��װ��linked list�����
        // �˼����뿼�� �������ݽṹ
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

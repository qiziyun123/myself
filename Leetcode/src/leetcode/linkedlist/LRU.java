package leetcode.linkedlist;

import java.util.HashMap;

/**
 * �ο�:���ͼ������ https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * 
 * @author qizy
 *
 */
public class LRU {
	/*
	 * ����˼·: ���һ��˫������,����ֻ����int���� hashmap��֤get set�����ĸ��ӵ���o(1)
	 * ֻҪ,get��set������,����Ϊ���key�ǵ�ǰ���µ�,�ͷ�ͷ�ڵ��,β���ڵ����Ҫ��̭��
	 */
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRU(int c) {
		this.capacity = c;
	}

	public int get(int key) {
		Node old = map.get(key);
		if (old == null) {
			return -1;
		} else {
			// �Ƴ�
			remove(old);
			// �����ֵ���·ŵ�ͷ�ڵ�
			setHead(old);
		}
		return old.value;
	}

	/**
	 * Ϊʲô�������������������������Ҫ�ľ���setHead �� remove����
	 * 
	 * @param old
	 */
	private void setHead(Node old) {
		old.next = head;
		old.pre =null;
		if(head!=null)
            head.pre = old;
 
        head = old;
 
        if(end ==null)
            end = head;

	}
	/**
	 * Ϊʲô�������������������������Ҫ�ľ���setHead �� remove����
	 * 
	 * @param old
	 */
	private void remove(Node old) {
		if(old.pre!=null) {
			old.pre.next = old.next;
		}else {
			head= old.next;
		}
		if(old.next!=null) {
			old.next.pre = old.pre;
		}else {
			end =old.pre;
		}

	}

	public void set(int key, int value) {
		// �鿴�Ƿ�exist
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}



}

/**
 * ����ඨ��
 *
 */
class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
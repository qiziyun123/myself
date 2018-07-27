package leetcode.linkedlist;

import java.util.HashMap;

/**
 * 参考:这个图很形象 https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * 
 * @author qizy
 *
 */
public class LRU {
	/*
	 * 整体思路: 设计一个双向链表,假设只保存int类型 hashmap保证get set操作的复杂的是o(1)
	 * 只要,get和set操作了,就认为这个key是当前最新的,就放头节点放,尾部节点就是要淘汰的
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
			// 移除
			remove(old);
			// 把这个值重新放到头节点
			setHead(old);
		}
		return old.value;
	}

	/**
	 * 为什么把这个问题算在链表里面最重要的就是setHead 和 remove方法
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
	 * 为什么把这个问题算在链表里面最重要的就是setHead 和 remove方法
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
		// 查看是否exist
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
 * 结点类定义
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
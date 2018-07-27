package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
   * ����һ���ѵ�һ�� ����������ϸ����
   * ��ͼ��ɣ�����̫�ѽ����ˣ�Ҳû�ҵ��ĸ��������ر�õ�ͼ����ͣ��Լ����˸���ͼ
 * 
 * @author qizy
 *
 */
public class WordLadder2 {

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		//		dict = ["hot","dot","dog","lot","log"]
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		// ���ؽ��
		// ["hit","hot","dot","dog","cog"],
	    // ["hit","hot","lot","log","cog"]
		// ͼ��ʵ�������£�ʵ�������·���������ߵľͲ������·��
//					hit
//					 |
//					hot
//				  /		\
//				dot-----lot
//				 |		 |
//				dog-----log
//				  \     /
//					cog
		//������β���ʵ��ֵ��У�Ȼ����ÿ���ֵ�����ڵ�map<str,set>���Ա�ʾ
		//�磺hit <hot>,hot<hit> ,dot<hot,lot,dog>
		//	  lot<dot,lot,log>
		// �� lot �� ���ڽ�� ��hot,dot,log����Ϊ�ǲ�α�����lot���ڵ�ֻ��hot��ע��cog�������ڵ�
		// ��ͨ�����ڵ��set�����У���ȥ���ڵ㣬�����ڵ����ϵݹ���ң�ȷ���ӽڵ�
		List<List<String>> result = findLength(start,end,dict);
		System.out.println(result);
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	private static List<List<String>> findLength(String start, String end, Set<String> dict) {
		Map<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();     
		dict.add(start);  
		dict.add(end);
		// ���
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(String str : dict){ 
			 // ��һ��ʼ�����ڼ���
			 initNeighbours(neighbours, str, dict);  
		}
		// {lot=[log, dot, hot], hit=[hot], log=[lot, cog, dog],
		//	dot=[lot, hot, dog], cog=[log, dog], 
		//	hot=[lot, hit, dot], dog=[log, dot, cog]}
		// bfs��ʼ���ö���ѭ�������Ļ���˼·����һ��û��
		// ��ʼ����һ������
		WordNode first = new WordNode(null,start,1);
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(first);
		// BFS level  
		int previousLevel = 0; 
		// ���ʼ�¼,value �Ǽ��������ж�ѭ����·�����
		HashMap<String, Integer> visited = new HashMap<String, Integer>(); 
		while(!queue.isEmpty()) {
			// ȡ��һ��������remove,�շ����
			WordNode curNode = queue.pollFirst();
			if(curNode.word.equals(end)) {
				if(previousLevel == 0 || curNode.level == previousLevel){  
					 previousLevel = curNode.level;  
					 findPath(curNode, result);                      
				}else {  
					 // ������̵Ķ��ҵ���  
					 break;  
				}           
			}else {
				HashSet<String> possibleNode = neighbours.get(curNode.word);
				if(possibleNode == null || possibleNode.isEmpty()) {
					continue; 
				}
				ArrayList<String> toRemove = new ArrayList<String>();
				for (String s : possibleNode) {
					if(visited.containsKey(s)){  
						 Integer occurLevel = visited.get(s);  
						 if(curNode.level+1 > occurLevel){  
						 	neighbours.get(s).remove(curNode.word);  
						 	toRemove.add(s);  
						 	continue;  
						 }  
					}  
					visited.put(s,  curNode.level+1);  
					queue.add(new WordNode(curNode, s, curNode.level + 1));  
					if(neighbours.containsKey(s)) {
						neighbours.get(s).remove(curNode.word);
					}
						 	
				}
				for(String s: toRemove){  
					possibleNode.remove(s);  
				}
			}
		}
		return null;
		
	}

	

	private static void findPath(WordNode curNode, List<ArrayList<String>> result) {
		ArrayList<String> path = new ArrayList<String>();  
		WordNode p = curNode;  
		while(p != null){  
			path.add(0, p.word);  
			p = p.prev;   
		}  
		result.add(path);
		
	}

	private static void initNeighbours(Map<String, HashSet<String>> neighbours, String str, Set<String> dict) {
		int length = str.length();  
		char [] chars = str.toCharArray();  
		for (int i = 0; i < length; i++) {
		    char old = chars[i];   
		    for (char c = 'a'; c <= 'z'; c++) {
		    	if (c == old) {
		    		continue; 
		    	
		    	}
		        chars[i] = c;  
		        String newstr = new String(chars);   
		        if (dict.contains(newstr)) {
		        	HashSet<String> set = neighbours.get(str);  
		        	if (set != null) {  
		            	set.add(newstr);  
		            } else {  
		            	HashSet<String> newset = new HashSet<String>();  
		                newset.add(newstr);  
		                neighbours.put(str, newset);  
		            }  
		        }                  
		    }  
		    chars[i] = old;  
		} 
		
	}



	static class WordNode{
		// ��������ؼ�������
		WordNode prev;
	    String word;
	    int level;
	 
	    public WordNode(WordNode prev,String word, int level){
	        this.word = word;
	        this.level = level;
	    }
	}
}

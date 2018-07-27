package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
   * 比上一题难的一逼 啊，费死脑细胞了
   * 看图解吧，语言太难解释了，也没找到哪个网上有特别好的图解解释，自己画了个草图
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
		// 返回结果
		// ["hit","hot","dot","dog","cog"],
	    // ["hit","hot","lot","log","cog"]
		// 图其实就是如下：实线是最短路径，有虚线的就不是最短路径
//					hit
//					 |
//					hot
//				  /		\
//				dot-----lot
//				 |		 |
//				dog-----log
//				  \     /
//					cog
		//加入首尾单词到字典中，然后求每个字典的相邻点map<str,set>可以表示
		//如：hit <hot>,hot<hit> ,dot<hot,lot,dog>
		//	  lot<dot,lot,log>
		// 如 lot 的 相邻结点 有hot,dot,log，因为是层次遍历，lot父节点只有hot，注意cog两个父节点
		// 可通过相邻点的set集合中，刨去父节点，其他节点往上递归查找，确定子节点
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
		// 结果
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(String str : dict){ 
			 // 逐一初始化相邻集合
			 initNeighbours(neighbours, str, dict);  
		}
		// {lot=[log, dot, hot], hit=[hot], log=[lot, cog, dog],
		//	dot=[lot, hot, dog], cog=[log, dog], 
		//	hot=[lot, hit, dot], dog=[log, dot, cog]}
		// bfs开始，用队列循环遍历的基本思路跟第一题没变
		// 初始化第一个顶点
		WordNode first = new WordNode(null,start,1);
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(first);
		// BFS level  
		int previousLevel = 0; 
		// 访问记录,value 是级别，用来判断循环回路的情况
		HashMap<String, Integer> visited = new HashMap<String, Integer>(); 
		while(!queue.isEmpty()) {
			// 取第一个，不是remove,刚放入的
			WordNode curNode = queue.pollFirst();
			if(curNode.word.equals(end)) {
				if(previousLevel == 0 || curNode.level == previousLevel){  
					 previousLevel = curNode.level;  
					 findPath(curNode, result);                      
				}else {  
					 // 所有最短的都找到了  
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
		// 比上题最关键的属性
		WordNode prev;
	    String word;
	    int level;
	 
	    public WordNode(WordNode prev,String word, int level){
	        this.word = word;
	        this.level = level;
	    }
	}
}

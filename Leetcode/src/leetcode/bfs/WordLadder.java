package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
   * 基础知识点：1图 参考datastruct.grahp例子
 * 		  2 dfs算法
 * 
 * @author qizy
 *
 */
public class WordLadder {

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
		// One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", 
		// the program should return its length 5.
		int length = findLength(start,end,dict);
		System.out.println(length);
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	private static int findLength(String start, String end, Set<String> dict) {
		// 如果 我们假设 把start，end都放入字典里面
		// 等于 dict就是图的结构，从顶点start 查找到end最短路径问题
		// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
		// 所以利用bfs就要把结果，也当作字典的一部分
		dict.add(end);
		// 树，图，大多数 层次遍历都用队列实现,参考图的遍历方法
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		// LinkedList 出列操作 是remove方法
		WordNode first = new WordNode(start,1);
		queue.add(first);
		// 上一次数量,终于知道为什么大多数例子都定义一个node类，记录这个节点的遍历次数，一个统一计数器有点复杂
		// int lastNum =0 ;
		// 遍历
		while(queue.size()!=0) {
			WordNode top = queue.remove();
			if(top.word.equals(end)) {
				return top.numSteps;
			}
			//当前字符串单词，改变其中一个字母可形成太多单词可能，但在字典中的才有效，不再字典中，相当于图中此路径无法继续查找
			List<WordNode> existWords = createWord(top,dict);
			queue.addAll(existWords);
			
		}
		return 0;
	}

	private static List<WordNode> createWord(WordNode wordnode,Set<String> dict) {
		List<WordNode> existWords = new ArrayList<WordNode>();
		char[] oldarr = wordnode.word.toCharArray();
		int wordlength = oldarr.length;
		
		// 逐个字母改变
		for (int i =0;i<wordlength;i++) {
			// 原字母当前字符
			char current = wordnode.word.charAt(i);
			// a-z除当前字符以外的字符,这个char如何遍历还真忘了，不过不是重点，百度一下API即可
			for(char c='a'; c<='z'; c++){
				if(c!= current) {
					char[] temp = new char[wordlength];
					for (int j =0;j<wordlength;j++) {
						if(j==i) {
							temp[j]= c;
						}else {
							
							temp[j]= oldarr[j];
						}
					}
					String newword = new String(temp);
					
					if(dict.contains(newword)) {
						WordNode newwordNode = new WordNode(newword,wordnode.numSteps+1);
						existWords.add(newwordNode);
						//实验好几次没成功是，一定要字典排除，防止循环 hot dot hot dot hot
						dict.remove(newword);
					}
				}
			}
		}
		return existWords;
	}

	static class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
}

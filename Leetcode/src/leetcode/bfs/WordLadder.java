package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
   * ����֪ʶ�㣺1ͼ �ο�datastruct.grahp����
 * 		  2 dfs�㷨
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
		// ��� ���Ǽ��� ��start��end�������ֵ�����
		// ���� dict����ͼ�Ľṹ���Ӷ���start ���ҵ�end���·������
		// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
		// ��������bfs��Ҫ�ѽ����Ҳ�����ֵ��һ����
		dict.add(end);
		// ����ͼ������� ��α������ö���ʵ��,�ο�ͼ�ı�������
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		// LinkedList ���в��� ��remove����
		WordNode first = new WordNode(start,1);
		queue.add(first);
		// ��һ������,����֪��Ϊʲô��������Ӷ�����һ��node�࣬��¼����ڵ�ı���������һ��ͳһ�������е㸴��
		// int lastNum =0 ;
		// ����
		while(queue.size()!=0) {
			WordNode top = queue.remove();
			if(top.word.equals(end)) {
				return top.numSteps;
			}
			//��ǰ�ַ������ʣ��ı�����һ����ĸ���γ�̫�൥�ʿ��ܣ������ֵ��еĲ���Ч�������ֵ��У��൱��ͼ�д�·���޷���������
			List<WordNode> existWords = createWord(top,dict);
			queue.addAll(existWords);
			
		}
		return 0;
	}

	private static List<WordNode> createWord(WordNode wordnode,Set<String> dict) {
		List<WordNode> existWords = new ArrayList<WordNode>();
		char[] oldarr = wordnode.word.toCharArray();
		int wordlength = oldarr.length;
		
		// �����ĸ�ı�
		for (int i =0;i<wordlength;i++) {
			// ԭ��ĸ��ǰ�ַ�
			char current = wordnode.word.charAt(i);
			// a-z����ǰ�ַ�������ַ�,���char��α����������ˣ����������ص㣬�ٶ�һ��API����
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
						//ʵ��ü���û�ɹ��ǣ�һ��Ҫ�ֵ��ų�����ֹѭ�� hot dot hot dot hot
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

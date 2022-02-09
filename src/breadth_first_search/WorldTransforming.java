//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/43163

package breadth_first_search;

import java.util.Queue;
import java.util.LinkedList;

class Word{
    public String word;
    public int count;
    
    public Word(String word, int count){
        this.word = word;
        this.count = count;
    }
}

public class WorldTransforming {

	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	
	public static int solution(String begin, String target, String[] words) {
        return BFS(begin, target, words);
    }
    
    public static int BFS(String begin, String target, String[] words){
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        int len = target.length();
        
        while(!queue.isEmpty()){
            Word w = queue.poll();
            String word = w.word;
            int count = w.count;
            
            if(word.equals(target)) return count;
            
            for(int i=0; i<words.length; i++){
                if(visited[i]) continue;
                
                int cnt = 0;
                for(int j=0; j<len; j++){
                    if(word.charAt(j) == words[i].charAt(j)) cnt++;
                }
                if(cnt >= len - 1){
                    queue.offer(new Word(words[i], count + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

}

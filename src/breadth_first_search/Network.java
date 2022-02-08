//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/43162
package breadth_first_search;

import java.util.Queue;
import java.util.LinkedList;

public class Network {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
	}
	
	public static int solution(int n, int[][] computers) {
        return BFS(n, computers);
    }
    
    public static int BFS(int n, int[][] computers){
        int[] visited = new int[n];
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(visited[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = 1;

            while(!q.isEmpty()){
                int start = q.poll();
                for(int k=0; k<n; k++){
                    if(k == start) continue;
                    if(visited[k] != 0) continue; 
                    if(computers[start][k] != 1) continue;
                    q.offer(k);
                    visited[k] = 1;
                }
            }
            count++;
        }
        return count;
    }
}

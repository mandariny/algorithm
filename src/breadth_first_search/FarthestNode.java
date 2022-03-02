//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/49189
package breadth_first_search;

import java.util.Queue;
import java.util.LinkedList;

public class FarthestNode {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
	}
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] check = new int[n + 1];
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new LinkedList<Integer>());
        }
        
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][1]).add(edge[i][0]);
            graph.get(edge[i][0]).add(edge[i][1]);
        }
        
        bfs(n, graph, check);
        
        int max = 0;
        for(int i : check){
            if(max < i){
                max = i;
                answer = 1;
            }else if(max == i){
                answer++; 
            }
        }
        
        return answer;
    }
    
    public static void bfs(int n, LinkedList<LinkedList<Integer>> graph, int[] check){
        Queue<Integer[]> queue = new LinkedList<>();
        
        queue.offer(new Integer[] {1, 1});
        check[1] = 1;
        
        while(!queue.isEmpty()){
            Integer[] q = queue.poll();
            Integer v = q[0];
            Integer d = q[1];
            
            for(int i : graph.get(v)){
                if(check[i] != 0) continue;
                check[i] = d + 1;
                queue.offer(new Integer[] {i, d + 1});
            }
        }
    }
}

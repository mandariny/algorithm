//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42583
package stack_queue;

import java.util.Queue;
import java.util.LinkedList;

public class TruckOnBridge {

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        
        int i = 0;
        while(i < truck_weights.length){
            int p = q.poll();
            w -= p;
            if(w + truck_weights[i] <= weight){
                q.offer(truck_weights[i]);
                w += truck_weights[i];
                i ++;
            }else if(w + truck_weights[i] > weight){
                q.offer(0);
            }
            answer ++;
        }
        
        while(!q.isEmpty()){
            q.poll();
            answer++;
        }
        
        return answer;
    }

}

//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42587
package stack_queue;

import java.util.Queue;
import java.util.LinkedList;

public class Printer {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Integer[] {i, priorities[i]});
        }
        
        while(!queue.isEmpty()){
            Integer[] p = queue.peek();
            int n = (int)p[1];
            boolean flag = true;
            
            for(int i=1; i<queue.size(); i++){
                p = (Integer[])((LinkedList)queue).get(i);
                if(p[1] > n){
                    queue.offer(queue.poll());
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                Integer[] q = queue.poll();
                answer++;
                if(q[0] == location)
                    return answer;
            }
        }
        
        return answer;
    }
}

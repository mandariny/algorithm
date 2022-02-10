//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42586

package stack_queue;

import java.util.ArrayList;

public class Development_Function {

	public static void main(String[] args) {
		int[] answer = solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		
		for(int a : answer) {
			System.out.print(a);
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int i = 0;
        while(i<progresses.length){
            int count = 0;
            while(progresses[i] < 100){
                for(int j=i; j<progresses.length; j++){
                    progresses[j] += speeds[j];
                }
            }
            for(int j=i; j<progresses.length; j++){
                if(progresses[j] < 100) {
                    i = j; 
                    break;
                }
                count++;
                
                if(j == progresses.length - 1) i = j + 1;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(k -> k).toArray();
    }

}

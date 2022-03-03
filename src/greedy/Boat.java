//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42885
package greedy;

import java.util.Arrays;

public class Boat {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100));
	}
	
	public static int solution(int[] people, int limit) {
        int answer = 0;
        int s = 0;
        int e = people.length - 1;
        Arrays.sort(people);
        
        while(s < e){
            if(people[s] + people[e] <= limit){
                answer++;
                s++;
                e--;
            }else{
                answer++;
                e--;
            }
        }
        
        if(s == e) answer++;
        
        return answer;
    }
}

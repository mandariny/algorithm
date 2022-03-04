//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42747
package sorting;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
	}
	
	public static int solution(int[] citations) {
        Arrays.sort(citations);
        
        int max = 0;
        
        for(int i=0; i<citations.length; i++){
            if(citations[i] <= citations.length - i){
                max = citations[i];
            }else{
                break;
            }
        }
        
        while(true){
            max++;
            if(citations.length - max < 0 || citations[citations.length - max] < max){
                max--;
                break;
            }
        }
        
        return max;
    }
}

//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/43238#

package binary_search;

public class Immigration {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7, 10}));
	}
	
	public static long solution(int n, int[] times) {
        return binarySearch(n, times);
    }
    
    public static long binarySearch(int n, int[] times){
        long left = 0;
        long right = Long.MAX_VALUE;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(int i : times){
                sum += mid / i;
                
                if(sum >= n) 
                    break;
            }
            
            if(sum < n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right + 1;
    }

}

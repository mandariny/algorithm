// ¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/43165

package backtracking;

public class TargetNum {
	public static int answer = 0;
    
    public static int solution(int[] numbers, int target) {
        recursion(numbers, target, 0, 0);

        return answer;
    }
    
    public static void recursion(int[] numbers, int target, int k, int sum){
        if(k == numbers.length){
            if(sum == target) answer++;
            return;
        }
        
        recursion(numbers, target, k + 1, sum + numbers[k]);
        recursion(numbers, target, k + 1, sum - numbers[k]);
    }

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
	}

}

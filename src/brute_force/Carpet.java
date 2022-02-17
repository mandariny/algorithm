//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42842
package brute_force;

public class Carpet {

	public static void main(String[] args) {
		int[] answer = solution(10, 2);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static int[] solution(int brown, int yellow) {
        return bruteForce(brown, yellow);
    }
    
    public static int[] bruteForce(int brown, int yellow){
        double s = Math.sqrt(yellow);
        for(int i=1; i<=s; i++){
            if(yellow % i == 0){
                int y = yellow / i;
                int b = 2 * (y + i + 2);
                if(b == brown) 
                    return new int[] {y + 2, i + 2};
            }
        }
        return null;
    }

}

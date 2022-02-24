//문제 : https://www.acmicpc.net/status?user_id=thrkflsk&problem_id=6603&from_mine=1
package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lotto {
	public static ArrayList<int[]> arr = new ArrayList<>();
	//check 필요 없음,,, 어차피 다음 수부터 for문을 반복하니까,,,
	public static ArrayList<boolean[]> check = new ArrayList<>();
	public static int[] answer = new int[6];
	public static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] s = br.readLine().split(" ");
			
			int n = Integer.parseInt(s[0]);
			
			if(n == 0) {
				break;
			}
			
			int[] nArr = new int[n];
			boolean[] nCheck = new boolean[n];
			
			for(int i=0; i<n; i++) {
				nArr[i] = Integer.parseInt(s[i + 1]);
			}
			
			arr.add(nArr);
			check.add(nCheck);
		}
		
		
		br.close();
	}
	
	public static void recursion(int k, int index, int pre) {
		if(k == 6) {
			for(int i : answer) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		int[] a = arr.get(index);
		boolean[] c = check.get(index);
		
		for(int i=pre; i<a.length; i++) {
			if(!c[i]) {
				check.get(index)[i] = true;
				answer[k] = a[i];
				recursion(k + 1, index, i + 1);
				check.get(index)[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		int n = arr.size();
		for(int i=0; i<n; i++){
			recursion(0, i, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

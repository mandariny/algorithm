package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSequence {
	private static int N, S, count;
	private static int[] sequence;
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		
		sequence = new int[N];
		s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			sequence[i] = Integer.parseInt(s[i]);
		}
	}
	
	public static void recursion(int k, int sum) {
		if(k == N) {
			if(sum == S)
				count++;
			return;
		}
		
		recursion(k + 1, sum + sequence[k]);
		recursion(k + 1, sum);	
	}

	public static void main(String[] args) throws IOException {
		init();
		recursion(0, 0);
		
		if(S == 0) // 공집합인 경우 -1
			count--;
		
		System.out.println(count);
	}

}

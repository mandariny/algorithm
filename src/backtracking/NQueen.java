package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NQueen {
	private static int N, count;
	private static boolean[] check1, check2, check3;
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check1 = new boolean[N];
		check2 = new boolean[N * 2];
		check3 = new boolean[N * 2];
	}
	
	public static void recursion(int k) {
		if(k == N) {
			count++;
			return;
		}

		for(int i=0; i<N; i++) {
			if(!check1[i] && !check2[k + i] && !check3[k - i + N]) {
				check1[i] = true;
				check2[k + i] = true;
				check3[k - i + N] = true;
				recursion(k + 1);
				check1[i] = false;
				check2[k + i] = false;
				check3[k - i + N] = false;	
			}
		}	
		
	}
	
	public static void main(String[] args) throws IOException{
		init();
		recursion(0);
		System.out.println(count);
	}

}

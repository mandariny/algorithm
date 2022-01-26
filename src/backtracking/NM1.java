package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class NM1 {
	static int N, M;
	static int[] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		arr = new int[M];
		check = new boolean[N + 1];
	}
	
	public static void recursion(int k) {
		if(k == M) {
			for(int i=0; i<k; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i ++) {
			if(!check[i]) {
				arr[k] = i;
				check[i] = true;
				recursion(k + 1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		recursion(0);
		System.out.println(sb);
	}

}

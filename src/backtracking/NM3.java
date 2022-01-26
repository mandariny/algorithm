package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NM3 {
	private static int N, M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		arr = new int[M];
	}
	
	public static void recursion(int k) {
		if(k == M) {
			for(int a : arr) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[k] = i;
			recursion(k + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		recursion(0);
		System.out.println(sb);
	}
}

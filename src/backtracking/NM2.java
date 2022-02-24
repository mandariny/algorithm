package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class NM2 {
	static int N, M;
	static int[] arr;
	//check 필요 없음,,, 어차피 다음 수부터 for문을 반복하니까,,,
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
	
	public static void recursion(int k, int s) {
		if(k == M) {
			for(int a : arr) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = s; i <= N; i ++) {
			if(!check[i]) {
				arr[k] = i;
				check[i] = true;
				recursion(k + 1, i + 1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		recursion(0, 1);
		System.out.println(sb);
	}

}



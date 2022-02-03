package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Sum123 {
	private static int[]D;
	private static int T, max;
	private static int[] n;
	private static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		n = new int[T];
		
		max = 0;
		for(int i=0; i<T; i++) {
			n[i] = Integer.parseInt(br.readLine());
			max = max < n[i] ? n[i] : max;
		}
		D = new int [max + 1];
		
		br.close();
	}
	
	public static void dp() {
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i=4; i<=max;i++) {
			D[i] = D[i - 1];
			D[i] += D[i - 2];
			D[i] += D[i - 3];
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		dp();
		for(int i=0; i<T; i++) {
			sb.append(D[n[i]] + "\n");
		}
		System.out.println(sb);
	}

}

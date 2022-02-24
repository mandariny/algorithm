//¹®Á¦ : https://www.acmicpc.net/problem/1003
package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Fibonacci {
	public static int[] arr;
    public static int[] dp0 = new int[41];
	public static int[] dp1 = new int[41];
	public static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
	}
	
	public static void fibonacci() {
		dp0[0] = 1;
		dp0[1] = 0;
		dp1[0] = 0;
		dp1[1] = 1;
		
		for(int i=2; i<41; i++) {
			dp0[i] = dp0[i - 1] + dp0[i - 2];
			dp1[i] = dp1[i - 1] + dp1[i - 2];
		}
	}

	public static void main(String[] args) throws IOException {
		init();
        fibonacci();
		for(int i=0; i<arr.length; i++) {
			sb.append(dp0[arr[i]] + " " + dp1[arr[i]] + "\n");
		}
		System.out.println(sb);
	}
}

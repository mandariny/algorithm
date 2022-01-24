package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Binary {
	
	static long N;
	static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
	}
	
	public static void recursion(long n) {
		if(n == 1) {
			sb.append(1);
			return;
		}
		
		recursion(n / 2);
		sb.append(n % 2);
		return;
	}

	public static void main(String[] args) throws IOException {
		init();
		//recursion(N);
		
		while(N >= 1) {
			sb.append(N % 2);
			N /= 2;
		}
		
		System.out.println(sb.reverse());
	}

}

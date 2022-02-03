package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MakeNumber1 {
	private static int[] D;
	private static int n;
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		D = new int[n + 1];
		
		br.close();
	}
	
	public static void dp() {
		D[1] = 0;
		for(int i=2; i<=n; i++) {
			int min = 1000000;
			if(i % 3 == 0) {
				min = (min > D[i/3] + 1)? D[i/3] + 1 : min;
			}
			if(i % 2 == 0) {
				min = (min > D[i/2] + 1)? D[i/2] + 1 : min;
			}
			min = (min > D[i-1] + 1)? D[i-1] + 1 : min;
			
			D[i] = min;
		}
	}

	public static void main(String[] args) throws IOException{
		init();
		dp();
		System.out.println(D[n]);
	}

}

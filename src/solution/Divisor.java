//¹®Á¦ : https://www.acmicpc.net/problem/1037
package solution;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Divisor {
	public static int N, min = Integer.MAX_VALUE, max = 0;
	
	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
	
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(s[i]); 
            min = min > n ? n : min;
            max = max < n ? n : max;
		}
		
		
		System.out.println(min * max);
		
		br.close();
	}

}

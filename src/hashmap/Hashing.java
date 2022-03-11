//¹®Á¦ : https://www.acmicpc.net/problem/15829
package hashmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Hashing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		System.out.println(hashing(L, s));
		
		br.close();
	}
	
	public static long hashing(int len, String s) {
		long sum = 0;
		long r = 1;
		int M = 1234567891;
		char[] arr = s.toCharArray();
		for(int i=0; i<len; i++) {
			sum += (arr[i] - 'a' + 1) * r % M;
			r = r * 31 % M;
			sum %= M;
		}
		
		return sum;	
	}
}

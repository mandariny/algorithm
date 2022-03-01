//¹®Á¦ : https://www.acmicpc.net/problem/5692
package arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Factorial {
	public static StringBuilder sb = new StringBuilder();
	
	public static void factorial(int temp) {
		int f = 1;
		int i = 1;
		int result = 0;
		
		while(temp > 0) {
			result += (temp % 10) * f;
			temp /= 10;
			i++;
			f *= i;
		}
		
		sb.append(result + "\n");
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			factorial(n);
		}
		
		System.out.println(sb);
		br.close();
	}
}

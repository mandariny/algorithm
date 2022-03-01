//¹®Á¦ : https://www.acmicpc.net/problem/2745
package arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ChangeNotation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[1]);
		int power = 1;
		int len = s[0].length();
		int result = 0;
		
		for(int i= len - 1; i >= 0; i--) {
			int c = s[0].charAt(i);
			
			if(c >= 'A' && c <= 'Z') {
				c -= 55;
			}else {
				c -= 48;
			}
			
			result += c * power;
			power *= n;
		}
		
		System.out.println(result);
		br.close();
	}
}

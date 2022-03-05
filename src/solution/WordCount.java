//¹®Á¦ : https://www.acmicpc.net/problem/19844
package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WordCount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = " ";
		s += br.readLine();
		
		s = s.replaceAll("[-]", " ");
		s = s.replaceAll("( c| j| n| m| t| s| l| d| qu)'[aeiouh]", " a a");
		s = s.replaceAll("^[ ]", "");
		
		System.out.println(s.split(" ").length);
		
		br.close();
	}
}

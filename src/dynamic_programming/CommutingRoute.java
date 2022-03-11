package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CommutingRoute {
	public static int w, h;
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		w = Integer.parseInt(s[0]);
		h = Integer.parseInt(s[1]);
		
		dp = new int[h][w];
		
		dynamic(w, h, dp);
		
		System.out.println(dp[h - 1][w - 1]);
		
		br.close();
	}
	
	public static void dynamic(int w, int h, int[][] dp) {
		dp[0][0] = 1;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(i == 0 && j == 0) continue;
				if(i > 0) {
					dp[i][j] += dp[i - 1][j];
				}
				if(j > 0) {
					dp[i][j] += dp[i][j - 1];
				}
				if(i != j && i > 0 && j > 0) {
					dp[i][j] -= 1;
				}
				dp[i][j] %= 100000;
			}
		}
	}
}

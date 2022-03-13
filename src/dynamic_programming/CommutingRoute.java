package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CommutingRoute {
	public static int w, h;
	public static int[][][][] dp;
	public static int mod = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		w = Integer.parseInt(s[0]);
		h = Integer.parseInt(s[1]);
		
		//세로, 가로, 동서(0) or 남북(1), 회전 여부(0: x, 1: o)
		dp = new int[h][w][2][2];
		
		dynamic(w, h, dp);
		
		System.out.println((dp[h - 1][w - 1][0][0] + dp[h - 1][w - 1][1][0]) % mod);
		
		br.close();
	}
	
	public static void dynamic(int w, int h, int[][][][] dp) {
		for(int i=0; i<w; i++) {
			dp[0][i][0][1] = 1;
		}
		
		for(int i=0; i<h; i++) {
			dp[i][0][1][1] = 1;
		}
		
		for(int i=1; i<h; i++) {
			for(int j=1; j<w; j++) {
				dp[i][j][0][0] = (dp[i][j - 1][0][0] + dp[i][j - 1][1][1]) % mod;
				dp[i][j][0][1] = (dp[i][j - 1][0][0]) % mod;
				dp[i][j][1][0] = (dp[i - 1][j][1][0] + dp[i - 1][j][0][1]) % mod;
				dp[i][j][1][1] = (dp[i - 1][j][1][0]) % mod;
			}
		}
	}
}

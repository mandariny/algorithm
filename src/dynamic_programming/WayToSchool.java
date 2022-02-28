package dynamic_programming;

public class WayToSchool {
	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] {{2, 2}}));
	}
	
	public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0) continue;
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                } 
                if(i > 0){
                    dp[i][j] += dp[i - 1][j];
                }
                
                if(j > 0){
                    dp[i][j] += dp[i][j - 1];
                }
                
                dp[i][j] %= 1000000007;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

// 45 * 46 = 2070 -> n은 최대 45
public class Solution_10448_유레카_이론 {
    private static int n;
    private static int k;
    private static int[] nums;

    private static void init(){
        for(int i=1; i<46; i++){
            nums[i] = nums[i - 1] + i;
        }
    }

    private static int dfs(int start, int sum, int depth){
        if(depth == 3) {
            if(sum == k) return 1;
            if(sum > k) return -1;
            if(sum < k) return 0;
        }

        if(sum >= k) return -1;

        for(int i=start; i<46; i++){
            int res = dfs(i, sum + nums[i], depth + 1);
            if(res == -1) return 0;
            if(res == 1) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int [46];
        init();
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            k = Integer.parseInt(br.readLine());
            System.out.println(dfs(1, 0, 0));
        }
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1236_성_지키기 {
    private static int n, m;
    private static char[][] map;

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[55][55];

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init();

        int row = 0, col = 0;

        // check row
        for(int i=0; i<n; i++){
            boolean flag = true;
            for(int j=0; j<m; j++){
                if(map[i][j] == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag) row++;
        }

        // check col
        for(int i=0; i<m; i++){
            boolean flag = true;
            for(int j=0; j<n; j++){
                if(map[j][i] == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag) col++;
        }

        System.out.println(Math.max(row, col));
    }
}

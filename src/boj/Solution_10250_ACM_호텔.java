package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_10250_ACM_호텔 {
    private static int t, h, w, n;

    private static int getAnswer(){
        int room = (n - 1) / h;
        room++;
        int floor = n % h;
        if(floor == 0) floor = h;
        return floor * 100 + room;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String[] inputs = br.readLine().split(" ");
            h = Integer.parseInt(inputs[0]);
            w = Integer.parseInt(inputs[1]);
            n = Integer.parseInt(inputs[2]);

            System.out.println(getAnswer());
        }
    }
}

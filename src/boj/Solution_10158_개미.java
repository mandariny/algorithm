package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_10158_개미 {

    static int w, h;
    static int x, y;
    static int t;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        t = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException{
        init();

        int wResert = (x + t) / w;
        int hResert = (y + t) / h;
        int wRest = (x + t) % w;
        int hRest = (y + t) % h;

        if(wResert % 2 == 0){
            System.out.print(wRest + " ");
        }else{
            System.out.print((w - wRest) + " ");
        }
        if(hResert % 2 == 0){
            System.out.print(hRest);
        }else{
            System.out.print(h - hRest);
        }
    }
}

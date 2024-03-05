package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2744_대소문자_바꾸기 {
    static char[] input;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();

        int len = input.length;
        int gap = 'a' - 'A';
        for(int i=0; i<len; i++){
            char c = input[i];
            if(c < 'a'){
                System.out.print((char)(c + gap));
            }else{
                System.out.print((char)(c - gap));
            }
        }
    }
}

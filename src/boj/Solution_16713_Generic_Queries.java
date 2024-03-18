package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_16713_Generic_Queries {

    private static int N, Q;
    private static ArrayList<Integer> arr = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void init() throws IOException {


        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        Q = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        arr.add(0);
        for(int i=0; i< inputs.length; i++){
            arr.add(Integer.parseInt(inputs[i]) ^ arr.get(i));
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        int sum = 0;
        for(int i=0; i<Q; i++){
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            sum ^= arr.get(b) ^ arr.get(a - 1);
        }
        System.out.println(sum);
    }
}

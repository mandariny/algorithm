package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution_1181_단어정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> setArr = new HashSet<>();
        for (int i = 0; i < N; i++) setArr.add(br.readLine());

        String[] arr = new String[setArr.size()];
        arr = setArr.toArray(arr);

        Arrays.sort(arr, (s1, s2) -> {
            if(s1.length() == s2.length()){
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });

        for(String s : arr){
            bw.write(s + "\n");
        }

        bw.flush();
    }
}

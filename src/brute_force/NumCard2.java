//¹®Á¦ : https://www.acmicpc.net/problem/10816
package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class NumCard2 {
	static int N, M;
	static int[] arrN, arrM;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		init();
		bruteForce();
		System.out.println(sb);
	}
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		arrN = Arrays.stream(str).mapToInt(i -> Integer.parseInt(i)).toArray();
		
		M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		
		arrM = Arrays.stream(str).mapToInt(i -> Integer.parseInt(i)).toArray();
		
		br.close();
	}
	
	public static void bruteForce() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i : arrM) {
			map.put(i, 0);
		}

		for(int i : arrN) {
			if(map.containsKey(i)) {
				map.replace(i, map.get(i) + 1);
			}
		}
		
		for(int i : arrM) {
			sb.append(map.get(i) + " ");
		}
	}

}

//¹®Á¦ : https://www.acmicpc.net/problem/15686
package breadth_first_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChickenDelivery {
	public static int N, M, h = 0, c = 0;
	public static int[] arr;
	public static Integer[][] house, chicken;
	public static ArrayList<Integer[][]> chickenList = new ArrayList<>();
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N= Integer.parseInt(s[0]);
		M= Integer.parseInt(s[1]);
		
		house = new Integer[2 * N][2];
		chicken = new Integer[13][2];
		arr = new int[M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				int k = Integer.parseInt(s[j]);
				if(k == 1) {
					house[h++] = new Integer[] {i, j};
				}
				if(k == 2) {
					chicken[c++] = new Integer[] {i, j};
				}
			}
		}
		
		br.close();
	}
	
	public static int distance(Integer[][] store) {
		int cnt = 0;
		
		for(int i=0; i<h; i++) {
			int min = N * N;
			for(int j=0; j<M; j++) {
				int d = Math.abs(house[i][0] - store[j][0]) + Math.abs(house[i][1] - store[j][1]);
				min = min > d ? d : min;
			}
			cnt += min;
		}
		
		return cnt;
	}
	
	public static void recursion(int k, int at) {
		if(k == M) {
			Integer[][] nArr = new Integer[M][2];
			for(int i=0; i<M; i++) {
				nArr[i] = chicken[arr[i]];
			}
			chickenList.add(nArr);
			return;
		}
		
		for(int i=at; i<c; i++) {
			arr[k] = i;
			recursion(k + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException{
		init();
		if(M == c) {
			System.out.println(distance(chicken));
		}else {
			recursion(0, 0);
			int min = Integer.MAX_VALUE;
			int m;
			
			for(Integer[][] list : chickenList) {
				m = distance(list);
				min = min > m ? m : min;
			}
			
			System.out.println(min);
		}
		
	}
}

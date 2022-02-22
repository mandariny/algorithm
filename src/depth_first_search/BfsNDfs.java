//¹®Á¦ : https://www.acmicpc.net/problem/1260
package depth_first_search;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BfsNDfs {
	public static int N, M, start;
	public static int[][] map;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		start = Integer.parseInt(s[2]);
		
		map = new int[N + 1][N + 1];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		visit = new boolean[N + 1];
		
		br.close();
	}
	
	public static void dfs(int s) {
		visit[s] = true;
		sb.append(s + " ");
		
		for(int i=1; i<N+1; i++) {
			if(visit[i]) continue;
			if(map[s][i] != 1) continue;
			dfs(i);
		}
	}
	
	public static void bfs() {
		visit = new boolean[N + 1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			sb.append(q + " ");
			
			for(int i=1; i<N+1; i++) {
				if(visit[i]) continue;
				if(map[q][i] != 1) continue;
				
				queue.offer(i);
				visit[i] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		init();
		dfs(start);
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}

}

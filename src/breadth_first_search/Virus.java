//¹®Á¦ : https://www.acmicpc.net/problem/2606
package breadth_first_search;

import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Virus {
	static int[][] network;
	static boolean[] visit;
	static int N, M;

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		network = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			network[x][y] = 1;
			network[y][x] = 1;
		}
		
		br.close();
	}
	
	public static int bfs() {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i=1; i<N + 1; i++) {
				if(visit[i]) continue;
				if(network[n][i] != 1) continue;
				
				queue.offer(i);
				visit[i] = true;
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(bfs());
	}

}

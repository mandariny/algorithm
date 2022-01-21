package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cheese {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<int[]> lastCheese = new ArrayList<>();
		int N, M, hour = 1;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[][] map, visited;
		
		String[]str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited = new int [N][M];			
			queue.offer(new int[] {0,0});
			visited[0][0] = 1;
			int cheese = 0;
			
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				int x = q[0];
				int y = q[1];
				
				for(int k=0; k<4; k++) {
					int cx = x + dx[k];
					int cy = y + dy[k];
					
					if(cx < 0 || cx >= N || cy < 0 || cy >= M) continue;
					if(visited[cx][cy] == 1) continue;
					
					if(map[cx][cy] == 0) {
						queue.offer(new int[] {cx, cy});
					}else {
						cheese++;
						map[cx][cy] = 0;
					}
					visited[cx][cy] = 1;
				}
			}
			
			if(cheese == 0)
				break;
			
			lastCheese.add(new int[] {hour++, cheese});
		
		}
		System.out.println(hour - 1);
		System.out.println(lastCheese.get(hour - 2)[1]);
	}

}

package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BlockArea {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> areas = new ArrayList<>();
		Queue<int[]> queue = new LinkedList();
		StringTokenizer st;
		int M, N, K, count = 0;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[][] map, visited;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int downY = Integer.parseInt(st.nextToken());
			int downX = Integer.parseInt(st.nextToken());
			int upY = Integer.parseInt(st.nextToken());
			int upX = Integer.parseInt(st.nextToken());

			for(int j=downX; j<upX; j++) {
				for(int d=downY; d<upY; d++) {
					map[j][d] = 1;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 || visited[i][j] == 1) continue;
				
				queue.offer(new int[] {i, j});
				visited[i][j] = 1;
				int area = 1;
				
				while(!queue.isEmpty()) {
					int[] q = queue.poll();
					int x = q[0];
					int y = q[1];
					
					for(int k=0; k<4; k++) {
						int cx = x + dx[k];
						int cy = y + dy[k];
						
						if(cx < 0 || cx >= M || cy < 0 || cy >= N) continue;
						if(map[cx][cy] == 1 || visited[cx][cy] == 1) continue;
						
						queue.offer(new int[] {cx, cy});
						visited[cx][cy] = 1;
						area++;
						
					}
				}
				
				count++;
				areas.add(area);
			}
		}
		
		System.out.println(count);
		Collections.sort(areas);
		for(int a : areas)
			System.out.print(a+" ");
		
	}

}

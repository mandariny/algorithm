package breadth_first_search;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P{
	int x;
	int y;
	
	P(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class ApartmentComplex {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, count = 0;
		ArrayList<Integer> houseCnt = new ArrayList<>();
		int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
		int[][] map, visited;
		Queue<P> queue = new LinkedList<>();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0' ;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] != 0 || map[i][j] != 1) continue;
				
				queue.offer(new P(i, j));
				visited[i][j] = 1;
				count++;
				int cnt = 1;
				
				while(!queue.isEmpty()) {
					P e = queue.poll();
					int x = e.x;
					int y = e.y;
					
					for(int k=0; k<4; k++) {
						int cx = x + dx[k];
						int cy = y + dy[k];
						
						if(cx < 0 || cx >= N || cy < 0 || cy >= N) continue;
						if(visited[cx][cy] != 0 || map[cx][cy] != 1) continue;
						
						queue.offer(new P(cx, cy));
						visited[cx][cy] = 1;
						cnt++;
					}
				}
				
				houseCnt.add(cnt);
			}
		}
		
		System.out.println(count);
		Collections.sort(houseCnt);
		for(int i : houseCnt) {
			System.out.println(i);
		}
		
	}

}

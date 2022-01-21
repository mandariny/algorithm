package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 class Pair{
	int x;
	int y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Maze {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] maze;
		int[][] distance;
		int N, M;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		maze = new int[N][M];
		distance = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = (int)s.charAt(j)-'0'; //charAt을 쓰면 아스키값이 들어가게 됨...
				distance[i][j] = -1;
			}
		}
		
		Queue<Pair> queue = new LinkedList<>();
		
		queue.add(new Pair(0,0));
		distance[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				
				int cx = x + dx[k];
				int cy = y + dy[k];
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M)
					continue;
				if(distance[cx][cy] != -1 || maze[cx][cy] == 0)
					continue;
				distance[cx][cy] = distance[x][y] + 1;
				queue.add(new Pair(cx, cy));
				
			}
		}
		
		System.out.println(distance[N-1][M-1]);
		
	}

}

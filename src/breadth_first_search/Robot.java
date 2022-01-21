package breadth_first_search;

import java.util.*;
import java.io.*;

public class Robot {
	private static int M, N;
	private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0}; //동서남북 순서
	private static int[][] map;
	private static int[][][] visited;
	private static RobotDir start;
	private static RobotDir end;
	
	static class RobotDir{
		int x, y, dir, move;
		
		public RobotDir(int x, int y, int dir, int move) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.move = move;
		}
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int [M][N][4];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		start = new RobotDir(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
		
		st = new StringTokenizer(br.readLine());
		end = new RobotDir(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
	}
	
	public static void bfs() {
		Queue<RobotDir> queue = new LinkedList<>();		
		queue.offer(start); 
		visited[start.x][start.y][start.dir] = 1;
		
		while(!queue.isEmpty()) {
			RobotDir r = queue.poll();
			int x = r.x;
			int y = r.y;
			int d = r.dir;
			int m = r.move;
			
			if(x == end.x && y == end.y && d == end.dir) {
				System.out.println(m);
				return;
			}
			
			for(int i=1; i<4; i++) {
				int nx = x + dx[d] * i;
				int ny = y + dy[d] * i;
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) break;
				if(map[nx][ny] == 1) break;
				if(visited[nx][ny][d] == 1) continue;
				queue.offer(new RobotDir(nx, ny, d, m + 1)); //++m으로 하면 다른 for문에 영향을 줘서 안됨
				visited[nx][ny][d] = 1;
			}
			
			for(int i=0; i<4; i++) {
				if(d == i) continue;
				if(visited[x][y][i] == 1) continue;
				
				int turn = 1;
				
				if((d + i) == 1 || (d + i) == 5) {
					turn ++;
				}
				
				queue.offer(new RobotDir(x, y, i, m + turn));
				visited[x][y][i] = 1;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		init();
		bfs();
	}
}

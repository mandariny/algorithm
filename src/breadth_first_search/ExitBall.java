package breadth_first_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class ExitBall {
	private static int N, M;
	private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0}, R, B; //동서남북
	private static int[][] map; // -1 : 벽, 0 : 길, 1 : 탈출구
	private static int[][][] visited; // 0 : 방문 가능, 1 : 이미 방문함
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		visited = new int[N][M][4];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split("");
			for(int j=0; j<M; j++) {
				String ss = s[j];
				if(ss == "#") map[i][j] = -1;
				else if(ss == ".") map[i][j] = 0;
				else if(ss == "O") map[i][j] = 1;
				else if(ss == "R") R = new int[] {i, j, 0};
				else if(ss == "B") B = new int[] {i, j, 0};
			}
		}
		
		br.close();
	}
	
	public static void bfs() {
		Queue<int[][]> q = new LinkedList<>();
		q.offer(new int[][] {R, B});
		
		while(!q.isEmpty()) {
			int[][] qq = q.poll();
			R = qq[0];
			B = qq[1];
			
			for(int i=0; i<4; i++) {
				int x = dx[i];
				int y = dy[i];
				int xR = R[0];
				int yR = R[1];
				int xB = B[0];
				int yB = B[1];
				int count = R[2];
				
				while(true) {
					xR += x;
					yR += y;
					xB += x;
					yB += y;
					
					//if()
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

	}

}

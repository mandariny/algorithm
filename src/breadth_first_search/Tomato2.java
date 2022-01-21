package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tomato2 {
	
	private static int N, M, H;
	private static int[][][] map, date;
	private static int min = -1;
	private static Queue<int[]> queue = new LinkedList();
	private static int[] dx = {1, 0, -1, 0, 0, 0};
	private static int[] dy = {0, 1, 0, -1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, 1, -1};
	
	public static int getDate() {
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);
		
		map = new int [N][M][H];
		date = new int [N][M][H];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					//map[j][k][i] = Character.getNumericValue(s.charAt(k));
					date[j][k][i] = -1;
					if(map[j][k][i] == 1) {
						queue.offer(new int[] {j, k, i});
						date[j][k][i] = 0;
					}
					if(map[j][k][i] == 0)
						flag = false;
				}
			}
		}
		
		if(flag) {
			System.out.println(0);
			return;
		}
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			int z = q[2];
			for(int d=0; d<6; d++) {
				int cx = x + dx[d];
				int cy = y + dy[d];
				int cz = z + dz[d];
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M || cz < 0 || cz >= H) continue;
				if(map[cx][cy][cz] != 0) continue;
				//if(date[cx][cy][cz] != -1) continue;
				
				queue.offer(new int[] {cx, cy, cz});
				date[cx][cy][cz] = date[x][y][z] + 1;
				map[cx][cy][cz] = 1;
				//System.out.println(cx+", "+cy+", "+cz);
				
			}
		}
				
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					//System.out.print(date[j][k][i]);
					if(map[j][k][i] == 0) {
						System.out.println(-1);
						return;
					}
					if(date[j][k][i] > min)
						min = date[j][k][i];
				}
				//System.out.println();
			}
		}
		
		System.out.println(min);
	}

}

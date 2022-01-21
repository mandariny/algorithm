package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Info {
	private int x;
	private int y;
	private boolean possible;
	
	public Info(int x, int y, boolean possible){
		this.x = x;
		this.y = y;
		this.possible = possible;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getPossible() {
		return this.possible;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPossible(boolean possible) {
		this.possible = possible;
	}
}

public class BreakeWall {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int map[][], distance[][][];
		Queue<Info> queue = new LinkedList();
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int [N][M];
		distance = new int [N][M][2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		queue.offer(new Info(0, 0, true));
		distance[0][0][0] = 1;
		
		if( N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			
			int x = info.getX();
			int y = info.getY();
			boolean possible = info.getPossible();
			
			if(x == (N-1) && y == (M-1)) {
				if(possible) {					
					System.out.println(distance[x][y][0]);
					return;
				}else {
					System.out.println(distance[x][y][1]);
					return;					
				}
			}
			
			for(int k=0; k<4; k++) {
				int cx = x + dx[k];
				int cy = y + dy[k];
				boolean cpossible = possible;
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M) continue;
				if(map[cx][cy] == 1) {
					if(!cpossible) {
						continue;
					}else {
						queue.offer(new Info(cx, cy, false));
						
						//System.out.println(cx + " " + cy + " " + cpossible);
						
						distance[cx][cy][1] = distance[x][y][0] + 1;
					}
				}else {
					if(cpossible) {						
						if(distance[cx][cy][0] != 0) continue;
											
						queue.offer(new Info(cx, cy, cpossible));
						//System.out.println(cx + " " + cy + " " + cpossible);
						distance[cx][cy][0] = distance[x][y][0] + 1;
					}else {
						if(distance[cx][cy][1] != 0) continue;
						
						queue.offer(new Info(cx, cy, cpossible));
						//System.out.println(cx + " " + cy + " " + cpossible);
						distance[cx][cy][1] = distance[x][y][1] + 1;
					}
				}
				
			}
		}
		
		System.out.println(-1);
		
	}

}

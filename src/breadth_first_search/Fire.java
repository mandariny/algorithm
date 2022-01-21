package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Pairs{
	int x;
	int y;
	
	Pairs(){
		
	}
	
	Pairs(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Fire {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map, jihun, fire;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int R, C, min_dist = 10000000;
		Queue<Pairs> queue = new LinkedList();
		
		String[] str = br.readLine().split(" ");
		
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		map = new int[R][C];
		jihun = new int[R][C];
		fire = new int[R][C];
		
		Pairs J = new Pairs();
				
		for(int i=0; i<R; i++) {
			
			String s = br.readLine();
			
			for(int j=0; j<C; j++) {
				
				if(s.charAt(j) == '.')
					map[i][j] = 1;
				else if(s.charAt(j) == 'J') {
					J.x = i;
					J.y = j;
					jihun[i][j] = 1;
				}
					
				else if(s.charAt(j) == 'F'){
					queue.offer(new Pairs(i, j));
					fire[i][j] = 1;
				}
				
			}
		}
		
		while(!queue.isEmpty()) {
			Pairs p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int cx = x + dx[k];
				int cy = y + dy[k];
				
				if(cx < 0 || cx >= R || cy < 0 || cy >= C) continue;
				if(map[cx][cy] == 0) continue;
				if(fire[cx][cy] != 0)continue;
				
				fire[cx][cy] = fire[x][y] + 1;
				queue.offer(new Pairs(cx, cy));
			}
		}
		
		queue.offer(J);
		
		while(!queue.isEmpty()) {
			Pairs p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int cx = x + dx[k];
				int cy = y + dy[k];
				
				if(cx < 0 || cx >= R || cy < 0 || cy >= C) continue;
				if(map[cx][cy] == 0) continue;
				if(jihun[cx][cy] != 0)continue;
				if((jihun[x][y]+1) >= fire[cx][cy] && fire[cx][cy] != 0)continue;
				
				jihun[cx][cy] = jihun[x][y] + 1;
				queue.offer(new Pairs(cx, cy));
			}
		}
		
		for(int i=0; i<R; i++) {
			
			if(jihun[i][0] != 0 && jihun[i][0] < min_dist)
				min_dist = jihun[i][0];
			
			if(jihun[i][C-1] != 0 && jihun[i][C-1] < min_dist)
				min_dist = jihun[i][C-1];
			
		}
		
		for(int i=0; i<C; i++) {
			
			if(jihun[0][i] != 0 && jihun[0][i] < min_dist)
				min_dist = jihun[0][i];
			
			if(jihun[R-1][i] != 0 && jihun[R-1][i] < min_dist)
				min_dist = jihun[R-1][i];
			
		}
		
		if(min_dist == 10000000) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(min_dist);
		}
		
	}

}

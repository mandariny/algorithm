package breadth_first_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Pair{
//	
//	int x;
//	int y;
//	
//	public Pair(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//}

public class Tomato {

	public static void main(String[] args) throws Exception {
		int N, M;
		int[][] box, date;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0 ,-1};
		int max = 0;
		int min = 0;
		Queue<Pair> queue = new LinkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[1]);
		M = Integer.parseInt(str[0]);
		
		box = new int [N][M];
		date = new int [N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					queue.offer(new Pair(i, j));
				}else if(box[i][j] == 0) {
					date[i][j] = -1;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();

			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int cx = x + dx[k];
				int cy = y + dy[k];
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M) 
					continue;
				if(date[cx][cy] != -1) 
					continue;
				
				date[cx][cy] = date[x][y] + 1;
				box[cx][cy] = 1;
				queue.offer(new Pair(cx, cy));
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(date[i][j] > max)
					max = date[i][j];
				if(date[i][j] < min)
					min= date[i][j];
			}
		}
		
		if(min < 0)
			System.out.println(min);
		else
			System.out.println(max);
	}

}

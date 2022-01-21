package breadth_first_search;

import java.io.*;
import java.util.*;

class ComparatorPair implements Comparable<ComparatorPair>{
	Integer mirror;
	int x;
	int y;
	int direction;
	
	public ComparatorPair(int m, int x, int y, int d) {
		this.mirror = m;
		this.x = x;
		this.y = y;
		this.direction = d;
	}
	
	@Override
	public int compareTo(ComparatorPair c) {
		if(this.mirror >= c.mirror) {
			return 1;
		}
		return -1;
	}
}

public class Lazer {
	private static int H, W;
	private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	private static int[][] map, visited;
	private static ComparatorPair[] cPoints = new ComparatorPair[2];

	public static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		H = Integer.parseInt(str[1]);
		W = Integer.parseInt(str[0]);
		
		map = new int[H][W];
		visited = new int[H][W];
				
		int cnt = 0;
		for(int i=0; i<H; i++) {
			str = br.readLine().split("");
			for(int j=0; j<W; j++) {
				if(str[j].equals(".")) {
					visited[i][j] = -1;
				}else if(str[j].equals("*")) {
					map[i][j] = 1;
				}else if(str[j].equals("C")) {
					cPoints[cnt++] = new ComparatorPair(0, i, j, -1);
					visited[i][j] = -1;
				}
			}
		}
	}
	
	public static void bfs() {
		PriorityQueue<ComparatorPair> queue = new PriorityQueue<>();
		queue.offer(cPoints[0]);
		visited[cPoints[0].x][cPoints[0].y] = 0;
		
		while(!queue.isEmpty()) {
			ComparatorPair q = queue.poll();
			int mirror = q.mirror;
			int x = q.x;
			int y = q.y;
			int direction = q.direction;
			
			if(x == cPoints[1].x && y == cPoints[1].y) {
				System.out.println(mirror);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nm = mirror;
				
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if(map[nx][ny] == 1) continue;
				if(direction != -1 && direction != i) 
					nm++;
				if(visited[nx][ny] != -1 && visited[nx][ny] < nm) continue; //왜 꼭 같을 때에도 들러줘야하는가,,,
				queue.offer(new ComparatorPair(nm, nx, ny, i));
				visited[nx][ny] = nm;				
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		init();
		bfs();
	}
}

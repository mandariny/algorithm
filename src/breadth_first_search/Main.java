package breadth_first_search;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> queue = new LinkedList<>();
		int[] points = new int[4];
		int H, W, c = 0;
		int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
		int[][] map, mirrors;
		int answer = Integer.MAX_VALUE;
		
		String[] str = br.readLine().split(" ");
		W = Integer.parseInt(str[0]);
		H = Integer.parseInt(str[1]);
		
		map = new int[H][W];
		mirrors = new int[H][W];
		
		for(int i=0; i<H; i++) {
			String s = br.readLine();
			for(int j=0; j<W; j++) {
				mirrors[i][j] = -1;
				if(s.charAt(j) == '*') {
					map[i][j] = 1;
				}else if(s.charAt(j) == 'C') {
					points[c++] = i;
					points[c++] = j;
				}
			}
		}
	
		queue.offer(new int[] {points[0], points[1], -1});
		mirrors[points[0]][points[1]] = 0;
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1]; 
			int d = q[2];
            int m = mirrors[x][y];

			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
                int cm = m;
				
				if(cx < 0 || cx >= H || cy < 0 || cy >= W) continue;
				if(map[cx][cy] == 1) continue;
                if(d != -1 && d != i) {
					cm++;
				}
				if(mirrors[cx][cy] != -1 && mirrors[cx][cy] < cm) continue;
				
				mirrors[cx][cy] = cm;
			    queue.offer(new int[] {cx, cy, i});
			}
		}
		
		System.out.println(mirrors[points[2]][points[3]]);		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(mirrors[i][j] == -1) {
					System.out.print(" ");
				}else
					System.out.print(mirrors[i][j]);
			}
			System.out.println();
		}
	}
}

//15 10
//...*...***.C..*
//.*.*.*........*
//.*...*...*....*
//.*.*....****.**
//.*..**........*
//.**..********.*
//.*...*...*..*.*
//.**..***.*.**.*
//C........*.....
//..***..........
//
//answer : 6

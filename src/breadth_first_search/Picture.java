package breadth_first_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Picture {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n, m;
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		int[][] graph = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[] x_a = {1,0,-1,0};
		int[] y_a = {0,1,0,-1};
		int cnt = 0;
		int block_size = 0;
		
		
		for(int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visited[i][j] == true || graph[i][j] != 1)
					continue;
				
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[]{i, j});
				visited[i][j] = true;
				
				cnt++;
				int b_cnt = 1;
				
				while(!q.isEmpty()) {
					int[] l = q.poll();
					
					int nx = l[0];
					int ny = l[1];
								
					for(int k = 0; k < 4; k++) {
						int cx = nx + x_a[k];
						int cy = ny + y_a[k];
						
						if(cx <0 || cx >=n || cy <0 || cy >=m)
							continue;
						if(visited[cx][cy]== true || graph[cx][cy]!=1)
							continue;
						b_cnt++;
						q.add(new int[] {cx, cy});
						visited[cx][cy] = true;
						
					}
				}
				
				if(b_cnt > block_size)
					block_size =b_cnt;
			
			}
		}
		
		sb.append(cnt);
		sb.append("\n");
		sb.append(block_size);
		
		System.out.println(sb);
		
	}

}

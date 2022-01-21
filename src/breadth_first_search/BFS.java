package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

class Elements{
	int x;
	int y;
	
	public Elements() {
		
	}
	
	public Elements(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS {

	public static void main(String[] args) {
		Queue<Elements> elements = new LinkedList<Elements>();
		
		int[][] graph = {{1,1,1,1,1,0,0,0,},{1,1,1,0,0,0,0,0},{1,1,0,0,0,0,0,0},{1,1,1,1,0,0,0,0,},{0,0,1,1,0,0,1,1},{0,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,},{0,0,1,1,1,1,0,0}};
		boolean[][] visited = new boolean[8][8];
		
		int[] x_axis = {1,0,-1,0};
		int[] y_axis = {0,1,0,-1};
		
		int x_size = 7;
		int y_size = 7;
		
		elements.add(new Elements(0, 0));
		visited[0][0] = true;
		
		while(elements.size() != 0) {
			Elements e = elements.poll();
			
			int cx = e.x;
			int cy = e.y;
			System.out.println(cx+", "+cy+" -> ");
			
			for(int i = 0; i < 4; i++) {
				if((cx+x_axis[i]) <0 || (cx+x_axis[i] > x_size || cy+y_axis[i] < 0 || cy+y_axis[i] > y_size))
					continue;
				if(graph[cx+x_axis[i]][cy+y_axis[i]] != 1 || visited[cx+x_axis[i]][cy+y_axis[i]] == true)
					continue;
				elements.add(new Elements(cx+x_axis[i],cy+y_axis[i]));
				visited[cx+x_axis[i]][cy+y_axis[i]] = true;
			}
			
			
		}
		System.out.println("end");	
	
	}

}

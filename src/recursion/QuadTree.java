package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuadTree {
	static int N;
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
	}
	
	public static void recursion(int n, int r, int c) {
		int num = board[r][c];

		int size = n / 2;
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(board[i][j] != num) {
					sb.append("(");
					
					recursion(size, r, c);
					recursion(size, r, c + size);
					recursion(size, r + size, c);
					recursion(size, r + size, c + size);
					
					sb.append(")");
					return;
				}
			}
		}
		
		sb.append(num);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		recursion(N, 0, 0);
		System.out.println(sb);
	}
}

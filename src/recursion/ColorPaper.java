package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ColorPaper {
	static int N;
	static int[][] paper;
	static int blue = 0, white = 0;
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void recursion(int n, int r, int c) {
		int color = paper[r][c];
		for(int i=r; i<r + n; i++) {
			for(int j=c; j<c + n; j++) {
				if(paper[i][j] != color) {
					int half = n / 2;
					recursion(half, r, c);
					recursion(half, r, c + half);
					recursion(half, r + half, c);
					recursion(half, r + half, c + half);
					return;
				}
			}
		}
		if(color == 1) {
			blue++;
		}else {
			white++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		recursion(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

}

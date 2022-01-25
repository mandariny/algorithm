package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PaperCount {
	static int N;
	static int[][] paper;
	static int minus = 0, zero = 0, plus = 0;
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
	
	public static void recursion(int n, int r, int c) {
		int num = paper[r][c];

		int size = n / 3;		
		for(int i=r; i<n + r; i++) {
			for(int j=c; j<n + c; j++) {
				if(paper[i][j] != num) {
					recursion(size, r, c);
					recursion(size, r, c + size);
					recursion(size, r, c + 2 * size);
					recursion(size, r + size, c);
					recursion(size, r + size, c + size);
					recursion(size, r + size, c + 2 * size);
					recursion(size, r + 2 * size, c);
					recursion(size, r + 2 * size, c + size);
					recursion(size, r + 2 * size, c + 2 * size);
					return;
				}
			}
		}
		
		add(num);
	}
	
	public static void add(int num) {
		if(num == -1) {
			minus++;
		}else if(num == 0) {
			zero++;
		}else {
			plus++;
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		init();
		recursion(N, 0, 0);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

}

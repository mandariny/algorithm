package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrintStar {
	static int N;
	static char[][] board;
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N]; //깜빡하고 초기화 안함,,,^^;;
	}

	public static void recursion(int n, int r, int c) {
		if(n < 3) {
			board[r][c] = '*';
			return;
		}
		
		int size = n / 3;
		recursion(size, r, c);
		recursion(size, r, c + size);
		recursion(size, r, c + 2 * size);
		
		recursion(size, r + size, c);
		printSpace(size, r + size, c + size);
		recursion(size, r + size, c + 2 * size);
		
		recursion(size, r + 2 * size, c);
		recursion(size, r + 2 * size, c + size);
		recursion(size, r + 2 * size, c + 2 * size);
	}
	
	public static void printSpace(int n, int r, int c) {
		for(int i=r; i<r + n; i++) {
			for(int j=c; j<c + n; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		recursion(N, 0, 0);
		for(int i=0; i<N; i++) {
			System.out.println(String.valueOf(board[i]));
		} //2중 for문으로 돌렸을 땐 시간 초과였음,,, 이게 더 빠르구나,,
	}

}

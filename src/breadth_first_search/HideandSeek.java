package breadth_first_search;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class HideandSeek {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N, K;
//		HashMap<Integer, Integer> distance = new HashMap<>();
//		Queue<Integer> queue = new LinkedList();
//		
//		String[] str = br.readLine().split(" ");
//		
//		N = Integer.parseInt(str[0]);
//		K = Integer.parseInt(str[1]);
//		
//		distance.put(N, 1);
//		
//		if(N == K)
//			System.out.println(0);
//		else
//			queue.offer(N);
//		
//		while(!queue.isEmpty()) {
//			int x = queue.poll();
//			
//			for(int i=0; i<3; i++) {
//				int cx;
//				
//				if(i == 0){
//					cx = x-1;
//				}else if(i == 1) {
//					cx = x+1;
//				}else {
//					cx = 2*x;
//				}
//				
//				if(cx < 0 || cx > 100000)
//					continue;
//				
//				if(distance.containsKey(cx))
//					continue;
//				
//				if(cx == K) {
//					System.out.println(distance.get(x));
//					return;
//				}
//				
//				distance.put(cx, distance.get(x)+1);
//				queue.offer(cx);
//				
//			}
//		}
//		
//	}
//
//}


import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HideandSeek {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, K;
		int[] distance = new int [100002];
		Queue<Integer> queue = new LinkedList();
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		distance[N] = 1;
		
		if(N == K)
			System.out.println(0);
		else
			queue.offer(N);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int cx : new int[] {x-1, x+1, 2*x}) {
				
//				if(i == 0){
//					cx = x-1;
//				}else if(i == 1) {
//					cx = x+1;
//				}else {
//					cx = 2*x;
//				}
				
				if(cx < 0 || cx > 100002)
					continue;
				
				if(distance[cx] != 0)
					continue;
				
				if(cx == K) {
					System.out.println(distance[x]);
					return;
				}
				
				distance[cx] = distance[x]+1;
				queue.offer(cx);
				
			}
		}
		
	}

}

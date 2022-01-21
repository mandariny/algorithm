package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PowerMod {
	static long A, B, C;	
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		A = Integer.parseInt(str[0]);
		B = Integer.parseInt(str[1]);
		C = Integer.parseInt(str[2]);
	}
	
	public static long findMod(long a, long b, long c) {
		if(b == 1)
			return a % c;
		
		long val = findMod(a, b/2, c);
		val = val * val % c;
		if(b % 2 == 0) {
			return val;
		}else {
			return a * val % c;
		}
//내가 짠 코드! 이것도 맞기는 하지만 쬐애애애끔 시간이 더 걸린다. 홀수일 때 짝수인 경우의 함수를 한 번 더 호출해야해서 그런 것 같다
/*
		if(b == 1)
			return a % c;
	
		if(b % 2 == 0) {
            long val = findMod(a, b/2, c);
		    val = val * val % c;
			return val;
		}else {
            long val = findMod(a, b - 1, c);
			return a * val % c;
		}
*/ 
	}

	public static void main(String[] args) throws IOException{
		init();
		System.out.println(findMod(A, B, C));
	}

}

package backtracking;

public class Main {
	public static void main(String[] args) {
		primeNum(100);
	}
	
	public static void primeNum(int num) {
		boolean[] check = new boolean[num + 1];
		
		check[0] = true;
		check[1] = true;
		
		for(int i=2; i<check.length; i++) {
			for(int j=i * 2; j<check.length; j += i) {
				check[j] = true;
			}
		}
		
		for(int i=2; i<check.length; i++) {
			if(!check[i])
				System.out.print(i + ", ");
		}
	}
}

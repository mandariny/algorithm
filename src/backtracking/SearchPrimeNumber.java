//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42839

package backtracking;

import java.util.HashSet;

public class SearchPrimeNumber {
	private static boolean[] check;
    private static String[] str;
    private static String[] arr;
    private static HashSet<Integer> set = new HashSet<>();
    
	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

    public static int solution(String numbers) {
        str = numbers.split("");
        check = new boolean[str.length];
        arr = new String[str.length];
        
        recursion(0, str);
        
        if(set.contains(0)) set.remove(0);
        if(set.contains(1)) set.remove(1);
        
        return primeNum();
    }
    
    public static void recursion(int k, String[] str){
        int len = str.length;
        String s = "";
        
        for(String a : arr) {
            if(a!=null)
                s += a; 
        }
            
        if(k == len){
            set.add(Integer.parseInt(s));
            return;
        }
        
        if(!set.contains(s) && !s.equals("")){
            set.add(Integer.parseInt(s));
        }
        
        for(int i=0; i<len; i++){
            if(!check[i]){
                arr[k] = str[i];
                check[i] = true;
                recursion(k + 1, str);
                check[i] = false;
                arr[k] = null;
            }
        }
    }
    
    public static int primeNum(){
        int count = 0;
        for(int i : set){
            for(int j=2; j<i; j++){
                if(i % j == 0){
                    count--;
                    break;
                }
            }
            count++;
        }
        return count;
    }
}

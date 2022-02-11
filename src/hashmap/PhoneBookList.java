package hashmap;

import java.util.HashMap;
import java.util.Arrays;

public class PhoneBookList {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
	}
	
	public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        Arrays.stream(phone_book).forEach(i -> map.put(i, 1));

        for(String str : phone_book){
            int len = str.length();
            for(int i=0; i<len; i++){
                if(map.containsKey(str.substring(0,i))){
                    return false;
                }
            }
        }

        return true;
    }
}

//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/72411
package solution;

import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;


public class MenuRenewal {
	public static void main(String[] args) {
		String[] answers = solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4});
		for(String s : answers) {
			System.out.println(s);
		}
	}
	
	public static String[] solution(String[] orders, int[] course) {
        ArrayList<HashMap<String, Integer>> arr = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();
        
        for(int c : course){
            HashMap<String, Integer> map = new HashMap<>();
            for(String s : orders){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dfs(0, 0, String.valueOf(chars), c, new Stack<String>(), map);
            }
            arr.add(map);
        }
        
        for(HashMap<String, Integer> map : arr){
            maxCource(map, answers);
        }
        
        String[] answer = new String[answers.size()]; 
        answers.toArray(answer);
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static void dfs(int k, int at, String order, int course, Stack<String> newCource, HashMap<String, Integer>map){
        if(k == course){
            makeHash(newCource, map);
            return;
        }
        
        int len = order.length();
        for(int i=at; i<len; i++){
            newCource.push(String.valueOf(order.charAt(i)));
            dfs(k + 1, i + 1, order, course, newCource, map);
            newCource.pop();
        }
    }
    
    public static void makeHash(Stack<String> newCource, HashMap<String, Integer>map){
        String str = "";
        for(String s : newCource){
            str += s;
        }
        
        if(!map.containsKey(str)){
            map.put(str, 1);
        }else{
            map.put(str, map.get(str) + 1);
        }
    }
    
    public static void maxCource(HashMap<String, Integer> map, ArrayList<String> answers){
        int max = getMaxValue(map);
        
        for(String s : map.keySet()){
            if(map.get(s) == max && max != 1){
                answers.add(s);
            }
        }
    }
    
    public static int getMaxValue(HashMap<String, Integer> map){
        int max = 0;
        for(Integer i : map.values()){
            max = max < i ? i : max;
        }
        return max;
    }
}

//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/43164
package depth_first_search;

import java.util.Arrays;
import java.util.Comparator;

public class TripRoute {
	public static boolean[] visited;
    public static String[] str;
    public static String[] answer;
    
	public static void main(String[] args) {
		String[] answers = solution(new String[][] {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}});
		
		for(String s : answers) {
			System.out.print(s + " ");
		}
	}
	
    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[]s2){
                if(s1[0].equals(s2[0])){
                    return s1[1].toString().compareTo(s2[1].toString());
                }else{
                    return s1[0].toString().compareTo(s2[0].toString());
                }
            }
        });
        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        str = new String[tickets.length + 1];
        
        dfs(tickets, "ICN", 0);
        
        return answer;
    }
    
    public static void dfs(String[][] tickets, String s, int k){
        if(k >= tickets.length){
            if(answer[k] == null){
                str[k] = s;
                for(int i=0; i<tickets.length + 1; i++){
                    answer[i] = str[i];
                }
            }
            
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(visited[i]) continue;
            if(tickets[i][0].equals(s)){
                visited[i] = true;
                str[k] = tickets[i][0];
                dfs(tickets, tickets[i][1], k + 1);
                visited[i] = false;
            }
        }
    }
}

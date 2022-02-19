//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/42579
package hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Collections;


public class BestAlbum {
	public static void main(String[] args) {
		int[] answer = solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
		for(int i : answer) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer[]> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i])){
                Integer[] p = map.get(genres[i]);
                if(plays[p[0]] < plays[i]){
                    map.put(genres[i], new Integer[] {i, p[0]});
                }else if(p[1] == -1 || plays[p[1]] < plays[i]){
                    map.put(genres[i], new Integer[] {p[0], i});
                }
            }else{
                map.put(genres[i], new Integer[] {i, -1});
            }
            map2.put(genres[i], map2.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map2.entrySet());
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>(){
           public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2){
               return obj1.getValue().compareTo(obj2.getValue()) * -1;
           } 
        });
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(Entry<String, Integer> entry : list_entries){
            String s = entry.getKey();
            Integer[] i = map.get(s);
            
            arr.add(i[0]);
            if(i[1] != -1){
                arr.add(i[1]);
            }
        }
        
        int[] answer = new int[arr.size()];
        int len = arr.size();
        
        for(int i=0; i<len; i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}

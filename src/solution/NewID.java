//¹®Á¦ : https://programmers.co.kr/learn/courses/30/lessons/72410
package solution;

public class NewID {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}
	
	public static String solution(String new_id) {
        new_id = new_id.toLowerCase(); 
        new_id = new_id.replaceAll("[^-_.[a-z][0-9]]", "");
        
        while(true){
            if(new_id.contains("..")){
                new_id = new_id.replace("..",".");
            }else{
                break;
            }
        }
        
        if(new_id.startsWith(".", 0)){
            new_id = new_id.substring(1);
        }
        
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
        }
        
        if(new_id.equals("")){
            new_id = "a";
        }
        
        if(new_id.charAt(new_id.length() - 1) == '.'){
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        if(new_id.length() <= 2){
            String s = String.valueOf(new_id.charAt(new_id.length() - 1));
            new_id = new_id.concat(s).concat(s);
            new_id = new_id.substring(0, 3);
        }
        return new_id;
    }
}

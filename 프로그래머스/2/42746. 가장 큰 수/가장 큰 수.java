import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] number = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            number[i] = numbers[i] + "";
        }
        
        Arrays.sort(number, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if(number[0].equals("0")) return "0";
        for(String s : number){
            answer += s;
        }
        return answer;
    }
}
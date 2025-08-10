import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        int idx = 0;
        for(int n : numbers){
            num[idx++] = Integer.toString(n);
        }
        
        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
        if (num[0].equals("0")) return "0";
        
        for(String s : num){
            answer += s;
        }

        return answer;
    }
}
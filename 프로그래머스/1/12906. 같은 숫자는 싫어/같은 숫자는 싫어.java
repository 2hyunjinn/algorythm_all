import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> q = new Stack<>();
        for(int a : arr){
            if(!q.isEmpty() && q.peek() == a) continue;
            q.push(a);
        }
        int[] answer = new int[q.size()];
        int idx = 0;
        for(int a : q){
            answer[idx] = a;
            idx++;
        }

        return answer;
    }
}
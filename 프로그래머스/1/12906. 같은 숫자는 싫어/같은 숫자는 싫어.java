import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        for(int a : arr){
            if(!s.isEmpty() && s.peek() == a) continue;
            s.push(a);
        }
        return s;
    }
}
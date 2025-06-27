import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.substring(i, i+1).equals("(")) stack.push("(");
            else if(stack.isEmpty()) return false;
            else stack.pop();
        }
        return (stack.isEmpty())? true : false;
    }
}
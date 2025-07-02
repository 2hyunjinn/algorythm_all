import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new LinkedList<>();
        
        for(int[] c : commands){
            int[] list = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(list);
            answer.add(list[c[2]-1]);
        }
        
        return answer;
    }
}
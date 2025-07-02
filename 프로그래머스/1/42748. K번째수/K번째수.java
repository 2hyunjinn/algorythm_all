import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new LinkedList<>();
        
        for(int[] c : commands){
            int i = c[0]-1;
            int j = c[1]-1;
            int k = c[2]-1;
            List<Integer> list = new LinkedList<>();
            for(int idx = i; idx <= j; idx++){
                list.add(array[idx]);
            }
            Collections.sort(list);
            answer.add(list.get(k));
        }
        
        return answer;
    }
}
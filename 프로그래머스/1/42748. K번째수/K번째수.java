import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] c : commands){
            int i = c[0] - 1;
            int j = c[1];
            int k = c[2] - 1;
            int[] arr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(arr);
            answer[idx] = arr[k];
            idx++;
        }
        return answer;
    }
}
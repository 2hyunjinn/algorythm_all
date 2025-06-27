import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++){
            queue.offer(new int[] {i, priorities[i]});
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            boolean hasHigher = queue.stream().anyMatch(p -> p[1] > current[1]);

            if(hasHigher){
                queue.offer(current);
            } else {
                if (current[0] == location) return answer;
                answer++;
            }
        }
        return -1;
    }
}
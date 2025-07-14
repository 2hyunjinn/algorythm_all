import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++){
            q1.offer((long)queue1[i]);
            q2.offer((long)queue2[i]);
        }
        
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();
        
        int cnt = 0;
        while(cnt < queue1.length * 3){
            if(sum1 > sum2){
                long v = q1.poll();
                sum1 -= v;
                sum2 += v;
                q2.offer(v);
            } else if(sum2 > sum1){
                long v = q2.poll();
                sum1 += v;
                sum2 -= v;
                q1.offer(v);
            } else return cnt;
            cnt++;
        }
        return (sum1 == sum2)? cnt : -1;
    }
}
import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        // 각 작업이 완료되는 일수 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (int) Math.ceil((double) remain / speeds[i]);
            daysQueue.offer(days);
        }

        // 배포 그룹 계산
        while (!daysQueue.isEmpty()) {
            int current = daysQueue.poll();
            int count = 1;

            // 현재 작업 완료 일자보다 작은 값은 함께 배포 가능
            while (!daysQueue.isEmpty() && daysQueue.peek() <= current) {
                daysQueue.poll();
                count++;
            }

            answer.add(count);
        }

        return answer;
    }
}

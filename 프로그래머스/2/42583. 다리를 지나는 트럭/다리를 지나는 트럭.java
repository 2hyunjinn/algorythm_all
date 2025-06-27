import java.util.*;

class Solution {
    static class Truck {
        int weight;
        int timeLeft;
        Truck(int weight, int timeLeft) {
            this.weight = weight;
            this.timeLeft = timeLeft;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingQueue = new LinkedList<>();
        Queue<Truck> bridgeQueue = new LinkedList<>();

        for (int truck : truck_weights) {
            waitingQueue.offer(truck);
        }

        int time = 0;
        int totalWeight = 0;

        while (!waitingQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            time++;

            // 다리에서 트럭 한 칸 이동
            if (!bridgeQueue.isEmpty() && bridgeQueue.peek().timeLeft == 1) {
                Truck departed = bridgeQueue.poll();
                totalWeight -= departed.weight;
            }

            // 나머지 트럭의 남은 시간 줄이기
            for (Truck truck : bridgeQueue) {
                truck.timeLeft--;
            }

            // 다음 트럭 올릴 수 있으면 올리기
            if (!waitingQueue.isEmpty() && totalWeight + waitingQueue.peek() <= weight) {
                int nextTruck = waitingQueue.poll();
                bridgeQueue.offer(new Truck(nextTruck, bridge_length));
                totalWeight += nextTruck;
            }
        }

        return time;
    }
}

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = n;

        for (int i = 0; i < wires.length; i++) {
            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>(n + 1);
            for (int j = 0; j <= n; j++) graph.add(new ArrayList<>());

            // i번째 간선만 제외하고 양방향 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int[] w = wires[j];
                int a = w[0], b = w[1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            // 그리고 지금 와이어 노드를 시작으로 몇개나 연결되어 있는지 확인하기
            int a = wires[i][0]; int b = wires[i][1];
            int countA = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(a);
            boolean[] visited = new boolean[n+1];
            while(!q.isEmpty()){
                int now = q.poll();
                visited[now] = true;
                countA++;
                for(int next : graph.get(now)){
                    if(visited[next]) continue;
                    q.offer(next);
                    visited[next] = true;
                }
            }
            int countB = n - countA;
            
            // 그 차이를 기록하기
            minDiff = Math.min(minDiff, Math.abs(countA - countB));
        }
        
        return minDiff;
    }
}
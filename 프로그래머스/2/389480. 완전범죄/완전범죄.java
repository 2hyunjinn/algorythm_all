import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = 1_000_000_000;

        // dp[b] = B 흔적 합이 b일 때의 최소 A 흔적 합
        int[] dp = new int[m];             // b는 0..m-1까지만 유효 (m 이상이면 잡힘)
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int a = item[0];
            int bVal = item[1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue;

                // 1) A가 훔침: B 합 그대로, A 합 + a (단 A 합이 n 미만이어야 유지 가치 있음)
                int aSum = dp[b] + a;
                if (aSum < n) {
                    next[b] = Math.min(next[b], aSum);
                }

                // 2) B가 훔침: B 합 + bVal (단 B 합이 m 미만이어야 함)
                int nb = b + bVal;
                if (nb < m) {
                    next[nb] = Math.min(next[nb], dp[b]);
                }
            }
            dp = next;
        }

        // 최종: B 합 < m 중에서 A 합 최소 (A 합 < n 조건은 위에서 이미 보장되도록 업데이트)
        int ans = Arrays.stream(dp).min().orElse(INF);
        return (ans == INF) ? -1 : ans;
    }
}

import java.util.*;

public class Main {
    static int[] dirX = {-1, 1, 0, 0}; // 위, 아래
    static int[] dirY = {0, 0, -1, 1}; // 왼 오
    private static boolean check(int x, int y, int dx, int dy){
        if(dx >=0 && dx < x && dy >=0 && dy < y) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] tomato = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j] == 1) { // 이미 익었다면
                    q.offer(new int[]{i,j});
                } else if(tomato[i][j] == -1) cnt++;
            }
        }

        int time = -1;
        int sum = n*m - cnt - q.size(); // 총 익어야 하는 토마토 개수
        while(!q.isEmpty()){
            // 현재 익은 아이들 개수
            int nowCnt = q.size();
            time++;

            for(int i = 0; i < nowCnt; i++){
                int[] now = q.poll();
                for(int j = 0; j<4; j++){
                    int dx = now[1] + dirX[j];
                    int dy = now[0] + dirY[j];
                    if(check(m, n, dx, dy) && tomato[dy][dx] == 0){ // 범위 안에 있다면 && 아직 안 익었다면
                        tomato[dy][dx] = 1; // 익히기
                        q.offer(new int[]{dy, dx});
                        sum--;
                    }
                }
            }
        }

        if(sum > 0) System.out.println(-1);
        else System.out.println(time);
    }

}
import java.util.*;
 
class Node{
    int x;
    int y;
    int d;
    
    public Node (int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    private int[] dirX = new int[]{-1, 1, 0, 0}; // 왼 오
    private int[] dirY = new int[]{0, 0, -1, 1}; // 위 아래
    private boolean validRoute(int x, int y, int dx, int dy){
        if(dx >= 0 && dx < x && dy >= 0 && dy < y) return true;
        return false;
    }
    
    public int solution(int[][] maps) {
        int col = maps.length; int row = maps[0].length;
        boolean[][] visited = new boolean[col][row];
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.y][now.x] = true;
            if(now.x == row-1 && now.y == col-1) return now.d;
            for(int i = 0; i < 4; i++){
                int dx = now.x + dirX[i]; int dy = now.y + dirY[i];
                if(validRoute(row, col, dx, dy) && !visited[dy][dx] && maps[dy][dx] == 1) {
                    visited[dy][dx] = true;
                    q.offer(new Node(dx, dy, now.d+1));
                }
            }
        }
        
        return -1;
    }
}
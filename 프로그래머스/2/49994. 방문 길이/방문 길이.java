import java.util.*;

class Node {
    int x;
    int y;
    public Node (int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        String[] dir = dirs.split("");
        Set<String> route = new HashSet<>(); // 현재 정점 -> 다음 정점 / 다음 -> 현재 루트 저장
        Node now = new Node(0,0);
        for(String d : dir){
            int nowX = now.x, nowY = now.y;
            if(d.equals("L") && isValidDir(nowX-1, nowY)){
                now = new Node(nowX-1, nowY);
            } else if(d.equals("R") && isValidDir(nowX+1, nowY)){
                now = new Node(nowX+1, nowY);
            } else if(d.equals("U") && isValidDir(nowX, nowY-1)){
                now = new Node(nowX, nowY-1);
            } else if(d.equals("D") && isValidDir(nowX, nowY+1)){
                now = new Node(nowX, nowY+1);
            }
            
            if(nowX == now.x && nowY == now.y) continue;
            System.out.println(nowX+""+nowY + " : " + now.x+""+now.y);
            route.add(nowX+""+nowY+now.x+""+now.y);
            route.add(now.x+""+now.y+nowX+""+nowY);
        }
        return route.size() / 2;
    }
    
    private boolean isValidDir(int x, int y){
        if(x >= -5 && x <= 5 && y >= -5 && y <= 5) return true;
        return false;
    }
}
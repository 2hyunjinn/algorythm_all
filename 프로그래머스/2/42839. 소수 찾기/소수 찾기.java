import java.util.*;

class Solution {
    private static Set<Integer> set = new HashSet<>();
    private static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        String[] num = numbers.split("");
        visited = new boolean[num.length];
        dfs("", num);

        return set.size();
    }
    
    private void dfs(String now, String[] num){
        if(!now.equals("")){ // 빈 배열이 아니라면
            int n = Integer.parseInt(now);
            if(isPrime(n)) set.add(n);
        }
        
        for(int i = 0; i<num.length; i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            dfs(now+num[i], num);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
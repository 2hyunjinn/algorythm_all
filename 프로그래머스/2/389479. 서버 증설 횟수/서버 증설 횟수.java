class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // M 명 늘 때마다 서버 1대 추가
        // m 명 미만이면 서버 증설 필요 없음
        // n * m ~ (n+1) * m 미만이면 최소 n 대의 증설된 서버가 운영중이어야 함
        // 한번 증설한 서버는 k 시간동안 이용 후 반납
        
        // 하루 동안 모든 이용자가 게임을 하려면 서버 최소 몇 번 증설?
        
        // (현재인원 - m + 1) / m == 증설 서버 횟수
        int minServer = 0; // 현재인원수 / m
        int addServer = 0; // 증가인원수 / m
        int[] nowServer = new int[24];
        
        for(int i = 0; i<24; i++) {
            int p = players[i];
            // 현재운영서버수로 감당가능한지 먼저 체크
            minServer = p / m;
            if(nowServer[i] >= minServer) continue; // 현재 서버로 커버 가능하면 패스~
            
            addServer = minServer - nowServer[i];
            for(int j = i; j<i+k; j++){
                if(j >= 24) break;
                nowServer[j] += addServer;
            }
            answer += addServer;
        }
        return answer;
    }
}
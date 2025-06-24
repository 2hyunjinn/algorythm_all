import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자 이름 맵에 저장
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주한 사람 맵에 저장
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 값이 1인 사람을 찾으면 그 사람이 완주하지 못한 거임
        for (String key : map.keySet()) {
            if (map.get(key) > 0) return key;
        }
        return "";
    }
}
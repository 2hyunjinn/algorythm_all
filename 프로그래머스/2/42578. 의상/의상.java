import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int sum = 1;
        for (String type : map.keySet()) {
            sum *= (map.get(type) + 1);
        }
        
        return sum - 1;
    }
}
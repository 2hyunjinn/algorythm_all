import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] three = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i<answers.length; i++){
            int ans = answers[i];
            if(one[i%one.length] == ans) map.put(1, map.getOrDefault(1, 0) + 1);
            if(two[i%two.length] == ans) map.put(2, map.getOrDefault(2, 0) + 1);
            if(three[i%three.length] == ans) map.put(3, map.getOrDefault(3, 0) + 1);
        }
        
        int maxV = 0;
        for(int v : map.values()){
            maxV = Math.max(maxV, v);
        }
        
        List<Integer> list = new LinkedList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxV) list.add(key);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new LinkedList<>();
        
        int tY = Integer.parseInt(today.split("\\.")[0]) * 12 * 28;
        int tM = Integer.parseInt(today.split("\\.")[1]) * 28;
        int tD = Integer.parseInt(today.split("\\.")[2]);
        int t = tY + tM + tD;
        
        Map<String, Integer> term = new HashMap<>();
        for(String te : terms){
            term.put(te.split(" ")[0], Integer.parseInt(te.split(" ")[1])*28);
        }
        
        int idx = 1;
        for(String privacy : privacies){
            String type = privacy.split(" ")[1];
            int pY = Integer.parseInt(privacy.split("\\.")[0]);
            int pM = Integer.parseInt(privacy.split("\\.")[1]);
            int pD = Integer.parseInt(privacy.split("\\.")[2].substring(0,2));
            int p = pY * 12 * 28 + pM * 28 + pD;
            if(term.get(type) + p <= t) answer.add(idx);
            idx++;
        }
        return answer;
    }
}
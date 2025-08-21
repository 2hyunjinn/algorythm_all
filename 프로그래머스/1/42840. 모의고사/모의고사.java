import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0; int cnt2 = 0; int cnt3 = 0;
        for(int i = 0; i<answers.length; i++){
            int nowA = answers[i];
            int now1 = one[i%5];
            int now2 = two[i%8];
            int now3 = three[i%10];
            
            if(nowA == now1) cnt1++;
            if(nowA == now2) cnt2++;
            if(nowA == now3) cnt3++;
        }
        
        int maxV = Math.max(cnt1, Math.max(cnt2, cnt3));
        int idx = 0;
        List<Integer> list = new LinkedList<>();
        
        if(cnt1 == maxV) list.add(1);
        if(cnt2 == maxV) list.add(2);
        if(cnt3 == maxV) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
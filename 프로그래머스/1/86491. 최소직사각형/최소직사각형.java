import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> w = new LinkedList<>();
        List<Integer> h = new LinkedList<>();
        
        for(int[] size : sizes){
            int a = size[0]; int b = size[1];
            if(a > b){
                w.add(a); h.add(b);
            } else {
                w.add(b); h.add(a);
            }
        }
        Collections.sort(w, Collections.reverseOrder());
        Collections.sort(h, Collections.reverseOrder());
        return w.get(0) * h.get(0);
    }
}
import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        Arrays.sort(bans, (x, y) -> {
            if (x.length() != y.length()) return Integer.compare(x.length(), y.length());
            return x.compareTo(y);
        });
        long cnt = 0;
        
        for(String b : bans){
            long bN = 0;
            for (int j = 0; j < b.length(); j++) {
                long now = b.charAt(j) - 'a' + 1; 
                bN = bN * 26 + now;
            }
            if(bN <= n + cnt) cnt++;
        }
        
        n += cnt;
        while(n > 0){
            n--;
            int alpha = (int)(n%26);
            answer += (char)('a'+alpha);
            n /= 26;
        }
        
        return new StringBuilder(answer).reverse().toString();
    }
}
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashSet<Integer> hash = new HashSet<>();
        for(int num : nums){
            hash.add(num);
        }
        return Math.min(n, hash.size());
    }
}
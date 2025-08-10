import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeSet<Integer> set = new TreeSet<>();
        for(String op : operations){
            if(op.split(" ")[0].equals("I")){
                set.add(Integer.parseInt(op.split(" ")[1]));
            } else if(op.split(" ")[0].equals("D") && !set.isEmpty()){
                if(op.split(" ")[1].equals("1")) set.remove(set.last());
                else set.remove(set.first());
            }
        }
        
        return (set.isEmpty())? new int[]{0,0} : new int[]{set.last(), set.first()};
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();
        for(String op : operations){
            String[] o = op.split(" ");
            if(o[0].equals("I")) set.add(Integer.parseInt(o[1]));
            else if(o[0].equals("D")){
                if(set.isEmpty()) continue;
                else if(o[1].equals("1")) set.remove(set.last());
                else set.remove(set.first());
            }                     
        }
        return (set.isEmpty())? new int[]{0,0} : new int[]{set.last(), set.first()};
    }
}
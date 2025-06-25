import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // 합계를 구하는 Map 하나
        // 인덱스와 재생횟수를 저장하는 Map 하나
        HashMap<String, Integer> mapSum = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
            String genre = genres[i]; int play = plays[i];
            mapSum.put(genre, mapSum.getOrDefault(genre, 0) + play);
            
            String key = genre + String.format("%05d", play) + String.format("%05d", 9999 - i);
            map.put(key, i);
        }

        // 총 재생 수 기준으로 장르 정렬
        List<String> sumKeySet = new ArrayList<>(mapSum.keySet());
        sumKeySet.sort((o1, o2) -> mapSum.get(o2).compareTo(mapSum.get(o1)));

        // key는 "장르+재생수+인덱스"이므로 전체 내림차순 정렬 시 재생수 기준 우선
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(Comparator.reverseOrder());
        
        for (String sumK : sumKeySet){
            int cnt = 0;
            for(String key : keySet){
                if(cnt == 2) break;
                if(key.startsWith(sumK)){
                    answer.add(map.get(key));
                    cnt++;
                }
            }    
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
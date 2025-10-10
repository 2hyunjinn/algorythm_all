class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skills = skill.split("");
        
        for(String trees : skill_trees){
            String[] tree = trees.split("");
            
            boolean valid = true;
            int idx = 0;
            
            for(String s : tree){
                if(skill.contains(s)){ // skill 안에 포함된 문자라면?
                    if(skills[idx].equals(s)){ // 선행 스킬이라면?
                        idx++;
                    } else { // 배울 수 없는게 먼저 나왔다면?
                        valid = false;
                        break;
                    }
                }
            }
            if(valid) answer++;
        }
        return answer;
    }
}
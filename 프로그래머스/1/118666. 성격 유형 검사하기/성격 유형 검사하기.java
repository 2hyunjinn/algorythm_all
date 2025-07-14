class Solution {
    int[] kakao = new int[8];
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
       
        for(int i = 0; i<choices.length; i++){
            String disagree = survey[i].substring(0, 1);
            String agree = survey[i].substring(1,2);
            int choice = choices[i];
            if(choice > 4) { // 동의라면 후자
                setScore(choice%4, agree);
            } else if (choice < 4) { // 비동의라면 전자
                setScore(4-choice, disagree);
            } else continue; // 모르겠다면 패스
        }
        
        String option = "RTCFJMAN";
        for(int i = 0; i<8; i+=2){
            answer += (kakao[i] < kakao[i+1])? option.substring(i+1, i+2) : option.substring(i, i+1);
        }
        return answer;
    }
    
    public void setScore(int score, String type){
        if(type.equals("R")) kakao[0]+=score;
        else if(type.equals("T")) kakao[1]+=score;
        else if(type.equals("C")) kakao[2]+=score;
        else if(type.equals("F")) kakao[3]+=score;
        else if(type.equals("J")) kakao[4]+=score;
        else if(type.equals("M")) kakao[5]+=score;
        else if(type.equals("A")) kakao[6]+=score;
        else if(type.equals("N")) kakao[7]+=score;
    }
}
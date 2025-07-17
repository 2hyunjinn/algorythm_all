import collections

def solution(survey, choices):
    answer = ''
    for i in range(len(survey)) :
        s = survey[i]
        c = choices[i]
        if (c < 4) : # 비동의라면
            answer += ((4-c) * s[0])
        elif(c > 4) : # 동의라면
            answer += ((c%4) * s[1])
    
    result = ''
    cnt = collections.Counter(answer)
    result += 'R' if (cnt['R'] >= cnt['T']) else 'T'
    result += 'C' if (cnt['C'] >= cnt['F']) else 'F'
    result += 'J' if (cnt['J'] >= cnt['M']) else 'M'
    result += 'A' if (cnt['A'] >= cnt['N']) else 'N'
    return result
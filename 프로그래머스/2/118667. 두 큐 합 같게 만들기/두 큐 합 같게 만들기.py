from collections import deque

def solution(queue1, queue2):
    answer = -2
    
    cnt = 0
    dq1 = deque()
    dq2 = deque()
    sum1 = 0
    sum2 = 0
    for i in range(len(queue1)) :
        dq1.append(queue1[i])
        dq2.append(queue2[i])
        sum1 += queue1[i]
        sum2 += queue2[i]
        
    while(sum1 != sum2) :
        if cnt > len(queue1)*3 :
            return -1
        
        if(sum1 > sum2) :
            v = dq1.popleft()
            dq2.append(v)
            sum1 -= v
            sum2 += v
            
        elif(sum1 < sum2) :
            v = dq2.popleft()
            dq1.append(v)
            sum1 += v
            sum2 -= v
        cnt+=1        
    return cnt
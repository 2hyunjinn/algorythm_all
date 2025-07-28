def solution(lottos, win_nums):
    count = [6,6,5,4,3,2,1]
    
    zero = lottos.count(0)
    minV = 0
    for l in lottos :
        if l in win_nums :
            minV += 1
    
    return [count[zero + minV], count[minV]]
def solution(rows, columns, queries):
    arr = [[r * columns + c + 1 for c in range(columns)] for r in range(rows)]
    answer = []

    for y1, x1, y2, x2 in queries:
        y1, x1, y2, x2 = y1-1, x1-1, y2-1, x2-1  # 0-index 변환
        prev = arr[y1][x1]
        minV = prev
        
        # 왼 → 오
        for c in range(x1+1, x2+1):
            arr[y1][c], prev = prev, arr[y1][c]
            minV = min(minV, prev)
        
        # 위 → 아래
        for r in range(y1+1, y2+1):
            arr[r][x2], prev = prev, arr[r][x2]
            minV = min(minV, prev)
        
        # 오 → 왼
        for c in range(x2-1, x1-1, -1):
            arr[y2][c], prev = prev, arr[y2][c]
            minV = min(minV, prev)
        
        # 아래 → 위
        for r in range(y2-1, y1-1, -1):
            arr[r][x1], prev = prev, arr[r][x1]
            minV = min(minV, prev)

        answer.append(minV)

    return answer

def solution(places):
    answer = []
    for place in places:
        flag = True
        for r in range(5):
            for c in range(5):
                if place[r][c] != 'P':
                    continue
                if not (내_근처_사람_찾기(r, c, place) and 내_근처근처_사람_찾기(r, c, place) and 내_대각선_사람_찾기(r, c, place)):
                    flag = False
                    break
            if not flag:
                break
        answer.append(1 if flag else 0)
                            
    return answer

def 내_근처_파티션_찾기(현재세로, 현재가로, 체크노드, places):
    if 체크노드 == '위' and 현재세로-1 >= 0:
        return places[현재세로-1][현재가로] == 'X'
    elif 체크노드 == '아래' and 현재세로+1 < 5:
        return places[현재세로+1][현재가로] == 'X'
    elif 체크노드 == '왼' and 현재가로-1 >= 0:
        return places[현재세로][현재가로-1] == 'X'
    elif 체크노드 == '오' and 현재가로+1 < 5:
        return places[현재세로][현재가로+1] == 'X'
    return False

def 내_근처_사람_찾기(세로, 가로, places):
    for dy, dx in [(-1,0), (1,0), (0,-1), (0,1)]:
        ny, nx = 세로 + dy, 가로 + dx
        if 0 <= ny < 5 and 0 <= nx < 5 and places[ny][nx] == 'P':
            return False
    return True


def 내_근처근처_사람_찾기(세로, 가로, places):
    거리2 = [(-2,0,'위'), (2,0,'아래'), (0,-2,'왼'), (0,2,'오')]
    for dy, dx, 방향 in 거리2:
        ny, nx = 세로 + dy, 가로 + dx
        if 0 <= ny < 5 and 0 <= nx < 5 and places[ny][nx] == 'P':
            if not 내_근처_파티션_찾기(세로, 가로, 방향, places):
                return False
    return True

def 내_대각선_사람_찾기(세로, 가로, places):
    대각선 = [(-1,-1,'위','왼'), (-1,1,'위','오'), (1,-1,'아래','왼'), (1,1,'아래','오')]
    for dy, dx, dir1, dir2 in 대각선:
        ny, nx = 세로 + dy, 가로 + dx
        if 0 <= ny < 5 and 0 <= nx < 5 and places[ny][nx] == 'P':
            if not (내_근처_파티션_찾기(세로, 가로, dir1, places) and 내_근처_파티션_찾기(세로, 가로, dir2, places)):
                return False
    return True
        
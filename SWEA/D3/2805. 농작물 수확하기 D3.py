t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    array = [list(map(int, input())) for _ in range(n)]
    mid, start, end = n // 2, n // 2, n // 2
    result = 0
    for i in range(n):
        for j in range(start, end + 1):
            result += array[i][j]
        if i < mid: # i가 중간으로 오기 전이면 범위 늘려줌
            start -= 1
            end += 1
        else: # i가 중간으로 왔으면 범위 좁혀줌
            start += 1
            end -= 1
    print(f'#{tc}', result)
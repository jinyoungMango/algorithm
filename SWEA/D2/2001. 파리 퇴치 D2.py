t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    array = [list(map(int, input().split())) for _ in range(n)]
    max_value = 0
    for i in range(n):
        for j in range(n):
            temp = 0
            for mi in range(m):
                for mj in range(m):
										# 제약사항 : 리스트 크기 넘어가면 break
                    if i + mi >= n or j + mj >= n:
                        break
                    temp += array[i + mi][j + mj]
            if max_value < temp:
                max_value = temp
    print(f'#{tc}',max_value)
t = int(input())
for t in range(1, t + 1):
    n, k = map(int, input().split())
    array = [list(map(int, input().split())) for _ in range(n)]
    result = 0
    # 열방향
    for i in range(n):
        cnt = 0
        for j in range(n):
            if array[i][j] == 1:
                cnt += 1
            else:
                if cnt == k:
                    result += 1
                cnt = 0
        if cnt == k:
            result += 1

    # 행방향
    for i in range(n):
        cnt = 0
        for j in range(n):
            if array[j][i] == 1:
                cnt += 1
            else:
                if cnt == k:
                    result += 1
                cnt = 0
        if cnt == k:
            result += 1

    print(f'#{t} {result}')
t = int(input())

for tc in range(1, t + 1):
    n = int(input())
    result = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(0, i + 1):
            result[i][j] = 1
            if i > 0 and j > 0:
                left = result[i-1][j-1]
                right = result[i-1][j]
                result[i][j] = left + right
    print(f'#{tc}')
    for i in range(n):
        for j in range(n):
            if result[i][j] > 0:
                print(result[i][j], end=' ')
        print()
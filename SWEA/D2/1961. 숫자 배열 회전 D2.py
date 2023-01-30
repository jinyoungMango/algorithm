t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    array = [list(map(int, input().split())) for _ in range(n)]

    print(f'#{tc}')
    for i in range(n):
        for j in range(n-1, -1, -1):
            print(array[j][i], end='')
        print(end=' ')
        for j in range(n-1, -1, -1):
            print(array[n-1-i][j], end='')
        print(end=' ')
        for j in range(n):
            print(array[j][n-1-i], end='')
        print()
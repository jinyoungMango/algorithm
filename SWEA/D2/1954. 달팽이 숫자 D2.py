t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    array = [[0 for _ in range(n)] for _ in range(n)]
    # 우, 하, 좌, 상 방향 벡터
    nx = [0, 1, 0, -1]
    ny = [1, 0, -1, 0]
    x, y = 0, 0
    direction = 0
    for i in range(1, n * n + 1):
        array[x][y] = i
        x += nx[direction]
        y += ny[direction]

        if x < 0 or x >= n or y < 0 or y >=n or array[x][y] != 0 :
            x -= nx[direction]
            y -= ny[direction]
            direction = (direction + 1) % 4
            x += nx[direction]
            y += ny[direction]

    print(f'#{tc}')
    for i in array:
        print(*i)
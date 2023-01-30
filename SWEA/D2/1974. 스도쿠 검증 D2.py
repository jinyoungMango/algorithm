t = int(input())
for tc in range(1, t + 1):
    puzzle = [list(map(int, input().split())) for _ in range(9)]

    result = 1
    for i in range(9):
        cnt_r = [0] * 10
        cnt_c = [0] * 10
        for j in range(9):
            cnt_r[puzzle[i][j]] += 1
            cnt_c[puzzle[j][i]] += 1
            cnt_box = [0] * 10
            for k in range(3):
                for l in range(3):
                    if i in [0, 3, 6] and j in [0, 3, 6]:
                        cnt_box[puzzle[i+k][j+l]] += 1
                    else: break
            for c in cnt_box:
                if c > 1: result = 0

        for c in cnt_r:
            if c > 1: result = 0
        for c in cnt_c:
            if c > 1: result = 0
    print(f'#{tc}', result)
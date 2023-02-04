for tc in range(1, 11):
    t = int(input())
    array = [list(map(int, input().split())) for _ in range(100)]


    max_value = 0
    # 행, 열 기준
    for i in range(100):
        sum_c = 0
        sum_l = 0
        sum_diag = array[i][i]
        for j in range(100):
            sum_c += array[i][j]
            sum_l += array[j][i]
        if max_value < sum_c:
            max_value = sum_c
        if max_value < sum_l:
            max_value = sum_l
        if max_value < sum_diag:
            max_value = sum_diag
    print(f'#{tc}',max_value)
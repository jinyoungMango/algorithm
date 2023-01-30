for tc in range(1, 11):
    n = int(input())
    array = [list(input()) for _ in range(8)]
    result = 0
		# 가로 확인
    for i in range(8):
        for j in range(8 - n + 1):
            check = array[i][j:j+n]
            if check == check[::-1]:
                result += 1
		# 세로 확인
    for i in range(8):
        for j in range(8 - n + 1):
            check = ''
            for k in range(n):
                check += array[j+k][i]
            if check == check[::-1]:
                result += 1

    print(f'#{tc}',result)
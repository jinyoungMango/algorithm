t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    if n > m:
        n, m = m, n
        a, b = b, a
    max_value = 0
		# 반복문 범위 잘 생각하기 
    for i in range(m - n + 1):
        temp = 0
        for j in range(n): # 작은 박스 기준으로 반복
            temp += a[j] * b[j + i]
        if temp > max_value:
            max_value = temp
    print(f'#{tc} {max_value}')
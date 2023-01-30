t = int(input())

for tc in range(1, t + 1):
    n = int(input())
    price = list(map(int, input().split()))
    max_index = 0
    result = 0
    # 배열 거꾸로 순회
    for val in price[::-1]:
        if val >= max_index:
            max_index = val # 최대값 업데이트
        else:
            result += max_index - val
    print(f'#{tc}', result)
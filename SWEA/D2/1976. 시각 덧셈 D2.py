t = int(input())
for tc in range(1, t + 1):
    hour1, min1, hour2, min2 = map(int, input().split())
    result_hour, result_min = 0, 0

    result_hour = hour1 + hour2
    result_min = min1 + min2
    if result_min >= 60:
        result_hour += 1
        result_min -= 60

    if result_hour >= 13:
        result_hour -= 12

    print(f'#{tc}', result_hour, result_min)
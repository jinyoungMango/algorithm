for tc in range(1, 11):
    n = int(input())
    building = list(map(int, input().split()))

    result = 0
    for i in range(2, n - 2):
        surround_building = [building[i-2], building[i-1], building[i+1], building[i+2]]
        if building[i] > max(surround_building):
            result += building[i] - max(surround_building)
    print(f'#{tc}', result)
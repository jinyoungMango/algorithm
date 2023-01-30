for tc in range(1, 11):
    n = int(input())
    box = list(map(int, input().split()))

    for i in range(n):
        max_index = box.index(max(box))
        min_index = box.index(min(box))
        box[max_index] -= 1
        box[min_index] += 1

    print(f'#{tc}',max(box) - min(box))
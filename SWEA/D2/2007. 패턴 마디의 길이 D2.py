t = int(input())
for tc in range(1, t + 1):
    data = input()
    data_length = 0
    for i in range(len(data)):
        if data[:i + 1] == data[i + 1:2 * (i + 1)]:
            data_length = i + 1
            break
    print(f'#{tc}', data_length)
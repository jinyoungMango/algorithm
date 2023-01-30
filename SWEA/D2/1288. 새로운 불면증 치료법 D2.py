t = int(input())
for t in range(1, t + 1):
    n = int(input())
    result = [0] * 10
    i = 0
    while 0 in result:
        i += 1
        num = n * i
        for j in str(num):
            result[int(j)] += 1


    print(f'#{t} {num}')
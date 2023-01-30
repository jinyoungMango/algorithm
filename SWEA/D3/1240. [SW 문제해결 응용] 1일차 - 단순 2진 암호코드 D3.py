t = int(input())

for tc in range(1, t + 1):
    n, m = map(int, input().split())
    pw = [list(input().split()) for _ in range(n)]
    incode = [(0, '0001101'), (1, '0011001'), (2, '0010011'), (3, '0111101'), (4, '0100011'),
             (5, '0110001'), (6, '0101111'), (7, '0111011'), (8, '0110111'), (9, '0001011')]
    pwcode = ''
    decode = []
    code = ''
    for i in pw:
        if int(*i) != 0:
            pwcode = i
            break
    for i in pwcode:
        for j in range(len(i) - 1, 0, -1):
            if i[j] == '1':
                code = i[j-55:j+1]
                break

    for i in range(8):
        decode.append(code[i*7:(i+1)*7])
    num = ''
    for i in range(len(decode)):
        for j in range(len(incode)):
            if decode[i] == incode[j][1]:
                num += str(incode[j][0])

    odd, even, result = 0, 0, 0
    for i in range(len(num)):
        result += int(num[i])
        if i % 2 == 0:
            odd += int(num[i])
        else:
            even += int(num[i])
    check = odd * 3 + even

    if check % 10 != 0:
        result = 0
    print(f'#{tc}', result)
t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    command = []
    for i in range(n):
        command.append(list(map(int, input().split())))
        speed = 0
        length = 0
    for c in command:
        if c[0] == 1: # 가속
            speed += c[1]
            length += speed
        elif c[0] == 2 : # 감속
            speed -= c[1]
            if speed < 0: # 제약사항 : 속도가 0 아래로 떨어지면 0
                speed = 0
            length += speed
        else: # 유지
            length += speed

    print(f'#{tc} {length}')
t = int(input())

for tc in range(1, t + 1):
    n, k = map(int, input().split())
    score = [list(map(int, input().split())) for _ in range(n)]
    grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    sum = [0] * n
    for i in range(n):
        sum[i] = [i, score[i][0] * 0.35 + score[i][1] * 0.45 + score[i][2] * 0.20]
    sum.sort(key = lambda x:x[1], reverse = True)
    
    for i in range(n):
        if sum[i][0] == k - 1:
            print(f'#{tc}',grade[i//(n//10)])
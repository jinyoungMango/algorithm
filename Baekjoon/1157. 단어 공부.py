# word = input()
word = input().upper()
word_dict = dict()

for i in word:
    word_dict[i] = 0

for i in range(len(word)):
    word_dict[word[i]]+= 1

max_value = 0
result = ""
chk = 0
for i in word_dict:
    if word_dict[i] > max_value:
        max_value = word_dict[i]
        result = i
        chk = 0
    elif word_dict[i] == max_value:
        chk = 1

if chk == 0:
    print(result)
else :
    print("?")
    
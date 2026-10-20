from collections import defaultdict

input = "1321131112"


def look_and_say(input):
    counter = 1
    output = ""
    for i in range(len(input) - 1):
        if input[i] == input[i + 1]:
            counter += 1
        else:
            output += str(counter) + input[i]
            counter = 1
    output += str(counter) + input[-1]
    return output


for i in range(40):
    input = look_and_say(input)
print(len(input))

for i in range(10):
    input = look_and_say(input)
print(len(input))

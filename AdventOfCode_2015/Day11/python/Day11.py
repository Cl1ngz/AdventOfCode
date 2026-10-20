input = "vzbxkghb"
banned = ["i", "o", "l"]


def has_straight(input):
    for i in range(len(input) - 2):
        if ord(input[i]) + 1 == ord(input[i + 1]) and ord(input[i + 1]) + 1 == ord(
            input[i + 2]
        ):
            return True
    return False


def has_pairs(input):
    pairs = set()
    for i in range(len(input) - 1):
        if input[i] == input[i + 1]:
            pairs.add(input[i])
    return len(pairs) >= 2


def is_valid(input):
    if any(c in banned for c in input):
        return False
    if not has_straight(input):
        return False
    if not has_pairs(input):
        return False
    return True


def increment(input):
    input = list(input)
    for i in range(len(input) - 1, -1, -1):
        if input[i] == "z":
            input[i] = "a"
        else:
            input[i] = chr(ord(input[i]) + 1)
            break
    return "".join(input)


while not is_valid(input):
    input = increment(input)
print(input)

input = increment(input)
while not is_valid(input):
    input = increment(input)
print(input)

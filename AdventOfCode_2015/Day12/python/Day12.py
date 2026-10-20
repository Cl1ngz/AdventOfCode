import re

with open("../input.txt") as f:
    data = f.read().strip()

numbers = re.findall(r"-?\d+", data)
print(sum(int(n) for n in numbers))

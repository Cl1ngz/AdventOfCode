import itertools

with open("../input.txt") as f:
    bucket = [int(line.strip()) for line in f]

target = 150
valid_combinations = 0

for i in range(1, len(bucket) + 1):
    for combination in itertools.combinations(bucket, i):
        if sum(combination) == target:
            valid_combinations += 1

print(valid_combinations)

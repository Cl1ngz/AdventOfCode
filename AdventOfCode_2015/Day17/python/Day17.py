import itertools

with open("../input.txt") as f:
    bucket = [int(line.strip()) for line in f]

target = 150
valid_combinations = 0
min_number_buckets = 0

for i in range(1, len(bucket) + 1):
    valid_combos = 0
    for combination in itertools.combinations(bucket, i):
        if sum(combination) == target:
            valid_combinations += 1
            valid_combos += 1
    if valid_combos > 0 and min_number_buckets == 0:
        min_number_buckets = valid_combos

print(f"Part 1: {valid_combinations}")
print(f"Part 2: {min_number_buckets}")

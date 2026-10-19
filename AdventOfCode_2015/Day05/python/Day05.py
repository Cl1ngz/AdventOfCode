import re

with open("../input.txt") as f:
    lines = f.read().strip().splitlines()

vowels = "aeiou"
banned = ["ab", "cd", "pq", "xy"]


def part1():
    count = 0
    for line in lines:
        vowels_count = True if sum(1 for c in line if c in vowels) >= 3 else False
        twice_in_a_row = any(c1 == c2 for c1, c2 in zip(line, line[1:]))
        banned_check = not any(c in line for c in banned)
        if vowels_count and twice_in_a_row and banned_check:
            count += 1

    print(count)


def part2():
    count = 0
    for line in lines:
        valid_pair = False
        repeating_letter = False

        seen_pairs = {}
        for i in range(len(line) - 1):
            pair = line[i : i + 2]
            if pair in seen_pairs:
                if i - seen_pairs[pair] > 1:
                    valid_pair = True
            else:
                seen_pairs[pair] = i

        for i in range(len(line) - 2):
            if line[i] == line[i + 2]:
                repeating_letter = True
                break

        if valid_pair and repeating_letter:
            count += 1

    print(count)


def part2_regex():
    count = 0
    for line in lines:
        if re.search(r"(..).*\1", line) and re.search(r"(.).\1", line):
            count += 1

    print(count)


part1()
part2()
part2_regex()

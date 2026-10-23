import itertools

with open("../input.txt") as f:
    lines = f.read().strip().splitlines()
    happines_map = {}
    people = set()
    for line in lines:
        modifier = line.replace("gain ", "").replace("lose ", "-")
        parts = modifier.split()
        p1, p2, happiness = parts[0], parts[-1][:-1], parts[2]
        happines_map[(p1, p2)] = int(happiness)
        people.add(p1)


def calculate_happiness(perm):
    max_happiness = -10000
    for perm in itertools.permutations(people):
        hap = 0
        for i in range(len(perm)):
            p1 = perm[i]
            p2 = perm[(i + 1) % len(perm)]
            hap += happines_map.get((p1, p2), 0)
            hap += happines_map.get((p2, p1), 0)
        max_happiness = max(max_happiness, hap)
    return max_happiness


print("Part 1:", calculate_happiness(people))
people.add("Me")
print("Part 2:", calculate_happiness(people))

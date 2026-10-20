import itertools

with open("../input.txt") as f:
    lines = f.read().strip().splitlines()

distances = {}
cities = set()
for line in lines:
    c1, c2 = line.split("to")
    c2, distance = c2.split("=")
    c1 = c1.strip()
    c2 = c2.strip()
    distances[c1, c2] = int(distance)
    distances[c2, c1] = int(distance)
    cities.add(c1)
    cities.add(c2)


def part1():
    shortest = 0
    shortes_route = []
    for perm in itertools.permutations(cities):
        distance = 0
        for i in range(len(perm) - 1):
            distance += distances[perm[i], perm[i + 1]]
        if shortest == 0 or distance < shortest:
            shortest = distance
            shortes_route = perm
    print(shortest, shortes_route)


def part2():
    longest = 0
    longest_route = []
    for perm in itertools.permutations(cities):
        distance = 0
        for i in range(len(perm) - 1):
            distance += distances[perm[i], perm[i + 1]]
        if distance > longest:
            longest = distance
            longest_route = perm
    print(longest, longest_route)


part1()
part2()
